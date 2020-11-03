package proj;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Class <b> FileHandling </b> is an utility class to open and handle files
 * @author Gabriel Gomes
 * @version 1.2
 * @since November 2020 
*/
public class FileHandling {
	/**
	 * Attribute <b> fileName </b> is used as the file name for reading and writing files.
	 */
	String fileName;

	/** Constructor instantiates the fileName attribute
	 * @param str is the String being written
	 */
	public FileHandling(String str) {
		fileName = str;
	}

	/** Method <b> readFile </b> reads a file into an ArrayList&lt;String&gt;
	 * @return ArrayList&lt;String&gt; containing the whole file.
	 */
	public ArrayList<String> readFile() {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(this.fileName + ".txt");
			DataInputStream dstream = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(dstream));

			String strLine;
			while ((strLine = br.readLine()) != null) {
				if (!strLine.isEmpty())
					lines.add(strLine);
			}
			dstream.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}

	/** Method <b> splitByWord </b> runs through the parameter and split every word into a separate string. This method also removes punctuation (could have been an separate method).
	 * @param al is the ArrayList with the file's content.
	 * @return ArrayList&lt;String&gt; with every word in the parameter.
	 */
	public ArrayList<String> splitByWord(ArrayList<String> al) {
		ArrayList<String> wordList = new ArrayList<String>();

		String[] s = al.get(0).split(" ", 0); // poorly allocating space to the auxiliary string

		for (int i = 0; i < al.size(); i++) { // iterating through the array
			s = al.get(i).split(" ", 0); // splitting by space
			for (int j = 0; j < s.length; j++) { // iterating through a line
				String aux = s[j];
				aux = aux.replaceAll("\\p{Punct}", "");// using RegEx to remove Punctuations
				wordList.add(aux.toLowerCase());
			}
		}
		return wordList;
	}

	/** Method <b>writeGraphAsCSV</b> writes the parameter into a new CSV File.
	 * @param graph object of Graph class
	 */
	public void writeGraphAsCSV(Graph graph) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File(fileName + ".csv"));
			writer.write(graph.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found by the CSV Writer!");
		}
	}
}
