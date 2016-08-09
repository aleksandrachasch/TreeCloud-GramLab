package tree;



import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.apache.batik.dom.svg.SVGDOMImplementation;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.JSVGScrollPane;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.svg.SVGDocument;

/**
 * Class used for generating and rendering SVG image of a tree
 * @author Aleksandra Chashchina
 *
 */

public class TreeSVG {
	
	/**
	 * Generate SVG file from tree data structure
	 * @param nodes ArrayList of nodes of a tree
	 * 
	 */
	
	public static void drawTreeCloud(ArrayList<TreeNode> nodes, String edgecolor){
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		Document doc = impl.createDocument(svgNS, "svg", null);
		
		Element svgRoot = doc.getDocumentElement();
		svgRoot.setAttributeNS(null, "width", "500");
		svgRoot.setAttributeNS(null, "height", "500");
		//svgRoot.setAttributeNS(null, "viewBox", "140 130 350 350");
		//svgRoot.setAttributeNS(null, "preserveAspectRatio", "xMaxYMax meet");
		
		for(int i=0; i<nodes.size(); i++){
	
				Element path = doc.createElementNS(svgNS, "path");
				path.setAttributeNS(null, "stroke-width", "0.9");
				path.setAttributeNS(null, "stroke", edgecolor.toLowerCase());
				path.setAttributeNS(null, "stroke-linecap","round");
				path.setAttributeNS(null, "stroke-linejoin", "round");
				path.setAttributeNS(null, "d", nodes.get(i).pathattr);
				//System.out.println(n.pathattr);
				svgRoot.appendChild(path);
				
				if(nodes.get(i).isLeaf){
					
					Element text = doc.createElementNS(svgNS, "text");
					text.setAttributeNS(null, "style" , "fill:" + nodes.get(i).fontcolor);
					text.setAttributeNS(null, "font-size", nodes.get(i).fontsize);
					text.setAttributeNS(null, "font-family", "Arial");
					//text.setTextContent(nodes.get(i).name);
					text.setAttributeNS(null, "class", "draggable");
					text.setAttributeNS(null, "ID", "1");
					text.setAttributeNS(null, "x", Double.toString(nodes.get(i).endX));
					text.setAttributeNS(null, "y", Double.toString(nodes.get(i).endY));
				
					svgRoot.appendChild(text);
					
					if(nodes.get(i).angle >= Math.PI/4 & nodes.get(i).angle <= Math.PI*3/4){
					
						Element tspan = doc.createElementNS(svgNS, "tspan");
						tspan.setAttributeNS(null, "style", "baseline-shift:sub");
						tspan.setTextContent(nodes.get(i).name);
						text.appendChild(tspan);
						
						if(nodes.get(i).hasSisterLeaf){
							text.setAttributeNS(null, "text-anchor" , "start");
							text.setAttributeNS(null, "y",  Double.toString(nodes.get(i).endY+5));
						}else{
							text.setAttributeNS(null, "text-anchor" , "middle");
						}
						}
					
					else if(nodes.get(i).angle >= Math.PI*3/4 & nodes.get(i).angle <= Math.PI*5/4){
						text.setTextContent(nodes.get(i).name);
						text.setAttributeNS(null, "text-anchor" , "end");
					}
					
					else if(nodes.get(i).angle >= Math.PI*5/4 & nodes.get(i).angle <= Math.PI*7/4){
						Element tspan = doc.createElementNS(svgNS, "tspan");
						tspan.setAttributeNS(null, "style", "baseline-shift:super");
						tspan.setTextContent(nodes.get(i).name);
						text.appendChild(tspan);
						text.setAttributeNS(null, "text-anchor" , "middle");
						
						if(nodes.get(i).hasSisterLeaf){
							text.setAttributeNS(null, "text-anchor" , "end");
							text.setAttributeNS(null, "y",  Double.toString(nodes.get(i).endY-6));
						}else{
							text.setAttributeNS(null, "text-anchor" , "middle");
						}
					}
					else{
						text.setTextContent(nodes.get(i).name);
						text.setAttributeNS(null, "text-anchor", "start");
						
					}
					
				
			}
				
	}
	        // Gets an element from the loaded document.
	        // document is your SVGDocument
	        //NodeList n = doc.g
	       // for(int i=0; i<n.getLength(); i++){
	        //	System.out.println(n.item(i).getTextContent());
	        
	
	        //System.out.println(elt.getTagName());
	        //EventTarget t = (EventTarg

//	        t.addEventListener("mousedown", new OnDownAction(), false);
//	        t.addEventListener("mousemove", new OnMoveAction(), false);
//	        t.addEventListener("mouseup", new OnUpAction(), false);
//	        t.addEventListener("mouseover", new OnOverAction(), false);
//	        t.addEventListener("click", new OnClickAction(), false);
	   // }
	
	
	
			
		
			
		


    JSVGCanvas c = new JSVGCanvas();
    //c.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
    //c.setSize(7000);
	c.setSVGDocument((SVGDocument) doc);
	//c.setEnableImageZoomInteractor(true);
	//c.setAutoscrolls(true);
	JSVGScrollPane scroll = new JSVGScrollPane(c);
	scroll.add(c);
	
	System.out.println(getViewBox(nodes));

	JFrame f = new JFrame("TreeCloud");
	f.setSize(500,500);
	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//f.getContentPane().setPreferredSize(new Dimension(500,500));
	f.getContentPane().add(scroll);
	//c.setPreferredSize(new Dimension(500,500));
	f.setVisible(true);
			}
	
	private static String getViewBox(ArrayList<TreeNode> nodes){
		ArrayList<Double> allX = new ArrayList<Double>();
		ArrayList<Double> allY = new ArrayList<Double>();
		for(TreeNode node : nodes){
			allX.add(node.startX);
			allX.add(node.endX);
			allY.add(node.startY);
			allY.add(node.endY);
		}
		double c = Collections.min(allY)-20.0;
		double m = Collections.max(allY)+ 20.0;
		double mx = Collections.min(allX) - 20.0;
		double maxx = Collections.max(allX) + 20.0;
		String result = mx + " " 
				+ c + " "
				+ maxx + " "
				+ m;
		return result;
	}
	
	
}