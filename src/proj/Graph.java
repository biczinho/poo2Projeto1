package proj;

import java.util.ArrayList;

public class Graph {
	public ArrayList<Node> graph = new ArrayList<Node>();

	public Graph newNode(Node node) {
		graph.add(node);
		return this;
	}

	public void printGraph() {
		for (Node node : this.graph) {
			System.out.println(node.toString());
		}
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Node node : this.graph) {
			str.append(node.toString());
			str.append("\n");
		}
		return str.toString();
	}

	public boolean isOrigin(String origin) {
		for (Node node : graph) {
			if (node.getOrigin().equals(origin))
				return true;
		}
		return false;
	}

	public Graph addOrigin(String word) {
		if (!this.isOrigin(word)) {
			this.newNode(new Node(word));
		}
		return this;
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
