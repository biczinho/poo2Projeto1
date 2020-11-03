package proj;

import java.util.ArrayList;

/**
 * Class <b> Node </b> defines data structure composed of a String and a ArrayList&lt;String&gt;.
 * @author Gabriel Gomes
 * @version 1.2
 * @since November 2020
 * 
*/
public class Node {
	/**
	 * Attribute <b> origin </b> is the definition of the start of an Node.
	 */
	private String origin;
	/**
	 * Attribute <b> destination </b> is the definition of all the Strings that an origin can lead to.
	 */
	private ArrayList<String> destination = new ArrayList<>();

	/** Constructor method instantiates the origin attribute with the received parameter
	 * @param origin is a String that represents the object's origin Attribute.
	 */
	public Node(String origin) {
		this.origin = origin;
	}

	/** Get method
	 * @return Object's origin attribute.
	 */
	public String getOrigin() {
		return origin;
	}

	/** Method <b> isDestination </b> used to identify whether a given string is a destination of this node.
	 * @param word is the string used to check if any matches with the node's destinations
	 * @return <b> True </b> if the parameter is contained. <br> <b> False </b> if the parameter is not contained.
	 */
	public boolean isDestination(String word) {
		if (destination.contains(word))
			return true;
		else
			return false;
	}

	/** Method <b> addDestionation </b> inserts the parameter into the object's destination ArrayList.
	 * @param word is the string being added.
	 */
	public void addDestination(String word) {
		destination.add(word);
	}

	/** Method <b> printNode </b> mostly used for debugging, prints the node in the system console. 
	 */
	public void printNode() {
		System.out.print(origin);
		for (String aux : destination)
			System.out.print(", " + aux);
	}

	/** @return Node ready to write into CSV
	 * 
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.origin);
		str.append(", ");
		for (String aux : destination)
			str.append(aux+", ");
		return str.toString();
	}
}
