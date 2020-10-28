package proj;

import java.util.ArrayList;

public class Node {
	private String origin;
	private ArrayList<String> destination = new ArrayList<>();

	public Node(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}

	public boolean isDestination(String word) {
		if (destination.contains(word))
			return true;
		else
			return false;
	}

	public void addDestination(String word) {
		destination.add(word);
//		return this;
	}

	public void printNode() {
		System.out.print(origin);
		for (String aux : destination)
			System.out.print(", " + aux);
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.origin);
		str.append(", ");
		for (String aux : destination)
			str.append(aux);
		return str.toString();
	}
}
