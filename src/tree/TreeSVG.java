package tree;



import java.util.ArrayList;

import javax.swing.JFrame;

import org.apache.batik.dom.svg.SVGDOMImplementation;

import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
	
	public static void drawTreeCloud(ArrayList<TreeNode> nodes){
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		Document doc = impl.createDocument(svgNS, "svg", null);
		
		Element svgRoot = doc.getDocumentElement();
		svgRoot.setAttributeNS(null, "width", "777");
		svgRoot.setAttributeNS(null, "height", "729");
		svgRoot.setAttributeNS(null, "viewBox", "0 0 250 250");
		svgRoot.setAttributeNS(null, "preserveAspectRatio", "xMinYMin meet");
		
		for(int i=0; i<nodes.size(); i++){
	
				Element path = doc.createElementNS(svgNS, "path");
				path.setAttributeNS(null, "stroke-width", "0.9");
				path.setAttributeNS(null, "stroke", "#fec44f");
				path.setAttributeNS(null, "stroke-linecap","round");
				path.setAttributeNS(null, "stroke-linejoin", "round");
				path.setAttributeNS(null, "d", nodes.get(i).pathattr);
				//System.out.println(n.pathattr);
				svgRoot.appendChild(path);
				
				if(nodes.get(i).isLeaf){
					
					Element text = doc.createElementNS(svgNS, "text");
					text.setAttributeNS(null, "style" , "fill:blue");
					text.setAttributeNS(null, "font-size", "5");
					//text.setTextContent(nodes.get(i).name);
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
	
	
	
			
		
			
		


    JSVGCanvas c = new JSVGCanvas();
	
	c.setSVGDocument((SVGDocument) doc);
	
	JFrame f = new JFrame("TreeCloud");
	f.setSize(800, 800);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	f.getContentPane().add(c);
	f.setVisible(true);
			}
	
	
}