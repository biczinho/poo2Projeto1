package proj;

import java.util.ArrayList;
import java.util.Collections;

public class GephiFormat {
	FileHandling file;
	String fileName;

	public GephiFormat(String fileName) {
		this.fileName = fileName;
		file = new FileHandling(fileName);
	}

	public Graph formatForGephi() {
		Graph graph = new Graph();

		ArrayList<String> everyWord = file.splitByWord(file.readFile());
		ArrayList<String> origins = file.splitByWord(file.readFile());
		ArrayList<String> destinations = file.splitByWord(file.readFile());

//		preparing origins ArrayList:
//		every word, except the last one, is an origin
//		origins must be sorted alphabetically
		origins.remove(origins.size() - 1);
		Collections.sort(origins);

//		preparing destinations ArrayList:
//		every word, expect the first one, is a destination  
		destinations.remove(0);

		for (String word : origins) { // adding every origin into the graph
			graph.addOrigin(word);
		}
		for (int i = 1; i < everyWord.size(); i++) {// add every destination
			if (!graph.findByOrigin(everyWord.get(i - 1)).isDestination(everyWord.get(i)))// making sure no repetitions
				graph.findByOrigin(everyWord.get(i - 1)).addDestination(everyWord.get(i));
		}

		return graph;
	}
}
