package proj;

import java.util.ArrayList;
import java.util.Collections;

public class PrepareForGephi {

	public static void main(String[] args) {
//		Arquivos arquivo = new Arquivos("parabens.txt");
		FileHandling file = new FileHandling("Luar do Sertão.txt");

		ArrayList<String> origins = file.splitByWord(file.readFile());
//		every word, except the last one, is an origin
		origins.remove(origins.size() - 1);
		Collections.sort(origins);
//		origins must be sorted alphabetically
		ArrayList<String> destinations = file.splitByWord(file.readFile());
		destinations.remove(0);
//		every word, expect the first one, is a destination  
		Graph graph = new Graph();
		for (String word : origins) { // adding every origin into the graph
			graph.addOrigin(word);
		}
		ArrayList<String> aux = file.splitByWord(file.readFile());
		for (int i = 1; i < aux.size(); i++) {// add every destination
			if (!graph.findByOrigin(aux.get(i - 1)).isDestination(aux.get(i)))// making sure no repetitions
				graph.findByOrigin(aux.get(i - 1)).addDestination(aux.get(i));
		}
		graph.printGraph();
	}
}
