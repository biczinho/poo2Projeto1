package proj;

import java.util.ArrayList;

/** Class <b> Graph </b> defines data structure to handle multiple <i> Nodes </i> .
 * @author Gabriel Gomes
 * @version 1.2
 * @since November 2020 
*/
public class Graph {
	/**
	 * Attribute <b> graph </b> is the identity element of the Graph class, defined as an ArrayList&lt;Node&gt;
	 */
	public ArrayList<Node> graph = new ArrayList<Node>();

	/** Method <b> newNode </b> inserts the parameter into the Object's Node attribute
	 * @param node of Node type is inserted.
	 * @return <b>this</b> object
	 */
	public Graph newNode(Node node) {
		graph.add(node);
		return this;
	}

	/** Method <b> printGraph </b> used mostly for debugging, prints the Object into the system console.
	 * 
	 */
	public void printGraph() {
		for (Node node : this.graph) {
			System.out.println(node.toString());
		}
	}

	/**
	 * @return The object as String.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Node node : this.graph) {
			str.append(node.toString());
			str.append("\n");
		}
		return str.toString();
	}

	
	/** Method <b> isOrigin </b> is used to identify whether a given String is the origin attribute of any of this object's nodes 
	 * @param origin is the string being searched
	 * @return <b> True </b> if the parameter is found. <br> <b> False </b> if the parameter is not found.
	 */
	public boolean isOrigin(String origin) {
		for (Node node : graph) {
			if (node.getOrigin().equals(origin))
				return true;
		}
		return false;
	}

	/** Method <b> addOrigin </b> inserts the parameter as a new Node into the object's Node ArrayList
	 * @param word is the word added as origin
	 * @return <b>this</b> object
	 */
	public Graph addOrigin(String word) {
		if (!this.isOrigin(word)) {
			this.newNode(new Node(word));
		}
		return this;
	}

	/** Method <b> findByOrigin </b> looks into all the nodes in the object's ArrayList&lt;Node&gt; and determines if the parameter is the origin of any node.
	 * @param origin is the word being searched 
	 * @return <b> Node </b> with the found origin <br> <b> Null </b> if none is found.
	 */
	public Node findByOrigin(String origin) {
		for (Node node : graph) {
			if (node.getOrigin().equals(origin))
				return node;
		}
		return null;
	}
}
