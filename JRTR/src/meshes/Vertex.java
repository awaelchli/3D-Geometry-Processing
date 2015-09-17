package meshes;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.vecmath.Point3f;
import javax.vecmath.Tuple3f;


/**
 * Implementation of a vertex for the {@link HalfEdgeStructure}
 */
public class Vertex extends HEElement{
	
	/**position*/
	Point3f pos;
	/**adjacent edge: this vertex is startVertex of anEdge*/
	HalfEdge anEdge;
	
	/**The index of the vertex, mainly used for toString()*/
	public int index;

	public Vertex(Point3f v) {
		pos = v;
		anEdge = null;
	}
	
	
	public Point3f getPos() {
		return pos;
	}

	public void setHalfEdge(HalfEdge he) {
		anEdge = he;
	}
	
	public HalfEdge getHalfEdge() {
		return anEdge;
	}
	
	/**
	 * Get an iterator which iterates over the 1-neighbouhood
	 * @return
	 */
	public Iterator<Vertex> iteratorVV(){
		//Implement this...
		return null;
	}
	
	/**
	 * Iterate over the outgoing edges
	 * @return
	 */
	public Iterator<HalfEdge> iteratorVE(){
		//Implement this...
		return null;

	}
	
	/**
	 * Iterate over the neighboring faces
	 * @return
	 */
	public Iterator<Face> iteratorVF(){
		//Implement this...
		return null;

	}
	
	
	public String toString(){
		return "" + index;
		//return pos.toString();
	}
	
	/**
	 * Test if vertex w is adjacent to this vertex.
	 * Will work once the iterators over neigbors are implemented
	 * @param w
	 * @return
	 */
	public boolean isAdjascent(Vertex w) {
		boolean isAdj = false;
		Vertex v = null;
		Iterator<Vertex> it = iteratorVV();
		while(it.hasNext()){
			v= it.next();
			if( v==w){
				isAdj=true;
			}
		}
		return isAdj;
	}


	/**
	 * Test if vertex w is adjacent to this vertex.
	 * Will work once the iterators over neigbors are implemented
	 * @param w
	 * @return
	 */
	public boolean isOnBoundary() {
		Iterator<HalfEdge> it = iteratorVE();
		while(it.hasNext()){
			if(it.next().isOnBorder()){
				return true;
			}
		}
		return false;
	}
	
}
