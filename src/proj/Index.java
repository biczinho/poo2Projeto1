package proj;

import javax.swing.JOptionPane;

public class Index {
	public static void main(String[] args) {
		String fileName = JOptionPane.showInputDialog("Insert file name");
		GephiFormat gephifier = new GephiFormat(fileName);
//		main object for gephi-format algorithm
		Graph graph = gephifier.formatForGephi();
		gephifier.file.writeGraphAsCSV(graph);
//		System.out.print(graph.toString());
	}
}
