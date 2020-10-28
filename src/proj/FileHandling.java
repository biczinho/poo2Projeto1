package proj;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileHandling {
	String fileName;

	public FileHandling(String str) {
		fileName = str;
	}

//	method that reads a file and returns an ArrayList with all its lines
	public ArrayList<String> readFile() {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(this.fileName);
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

	public void imprimeArrayList(ArrayList<String> al) {
		for (String line : al)
			System.out.println(line);
	}

//	metodo recebe uma ArrayList<String> e retorna uma ArrayList<String> separando cada palavra em uma linha
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
}
