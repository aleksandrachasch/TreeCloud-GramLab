package tree;

import org.apache.batik.dom.events.DOMMouseEvent;
import org.apache.batik.dom.svg.SVGOMPoint;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGMatrix;


public class DragLabel{
	
	protected int drag;
	protected Element selectedItem;
	protected SVGOMPoint initialDragPoint;
	protected final int DRAG_UP = 0;
	protected final int DRAG_DOWN = 0;
	
	public class OnDownAction implements EventListener {
        public void handleEvent(Event evt) {
        	
        	SVGLocatable thisNode = (SVGLocatable)evt.getTarget();
        	
        	drag = DRAG_DOWN;
        	DOMMouseEvent elEvt = (DOMMouseEvent)evt;
            int nowToX = elEvt.getClientX();
            int nowToY = elEvt.getClientY();
            
            SVGOMPoint pt = new SVGOMPoint(nowToX, nowToY);
            SVGMatrix mat = thisNode.getScreenCTM();
            mat = mat.inverse();                  
            initialDragPoint = (SVGOMPoint)pt.matrixTransform(mat);
        	
        }
        
        public class OnUpAction implements EventListener {
            public void handleEvent(Event evt) {
                            drag = DRAG_UP;
            }
    }
        
        public class OnMoveAction implements EventListener {
            public void handleEvent(Event evt) {
                    if (drag == DRAG_DOWN) {
                    	DOMMouseEvent elEvt = (DOMMouseEvent)evt;
                        int nowToX = elEvt.getClientX();
                        int nowToY = elEvt.getClientY();
                        SVGOMPoint pt = new SVGOMPoint(nowToX, nowToY);
                        SVGMatrix mat = ((SVGLocatable)evt.getTarget()).getScreenCTM();  

                        mat = mat.inverse();           
                        SVGOMPoint dragpt = (SVGOMPoint)pt.matrixTransform(mat);
                        

        
	}
}
        }
        

        
	}
}
        