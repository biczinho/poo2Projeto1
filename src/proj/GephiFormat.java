package proj;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class <b> GephiFomat </b> implements the algorithm that converts an Text File into an CSV File ready for use with Gephi.
 * @author Gabriel Gomes
 * @version 1.2
 * @since November 2020 
*/
public class GephiFormat {
	/** Attribute <b> file </b> of type FileHandling is used for handling inputed file and writing the output .csv file
	 */
	FileHandling file;
	/** Attribute <b> fileName </b> is used to construct FileHandling object 
	 */
	String fileName;

	/** Constructor instantiates the fileName attribute.
	 * @param fileName is the file's name 
	 */
	public GephiFormat(String fileName) {
		this.fileName = fileName;
		file = new FileHandling(fileName);
	}

	/** Method <b> formatForGephi </b> classifies every word (from the file attribute) into origins and destinations.
	 * @return <b>graph</b> object of Graph class populated with nodes, each with at least one destination word and exactly one origin word.
	 */
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
