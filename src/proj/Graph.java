package proj;

import java.util.ArrayList;

public class Graph {
	public ArrayList<Node> graph = new ArrayList<Node>();

	public void newNode(Node node) {
		graph.add(node);
	}

	public void printGraph() {
		for (Node aux : this.graph) {
			System.out.println();
			aux.printNode();
		}
	}

	public boolean isOrigin(String origin) {
		for (Node node : graph) {
			if (node.getOrigin().equals(origin))
				return true;
		}
		return false;
	}

	public void addOrigin(String word) {
		if (!this.isOrigin(word)) {
			this.newNode(new Node(word));
		}
	}

//	given an origin, finds the Node with that origin
	public Node findByOrigin(String origin) {
		for (Node node : graph) {
			if (node.getOrigin().equals(origin))
				return node;
		}
		return null;
	}
}
