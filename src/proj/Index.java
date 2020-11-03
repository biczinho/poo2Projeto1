package proj;

import javax.swing.JOptionPane;

/**
 * Class <b> Index </b> used for User-Software interaction
 * @author Gabriel Gomes
 * @version 1.2
 * @since November 2020
 * 
*/
public class Index {
	/** <b> main </b> class control the flow of execution and object's creation.
	 * @param args default argumentsS of execution.
	 */
	public static void main(String[] args) {
		String fileName = JOptionPane.showInputDialog("Insert file name");
		GephiFormat gephifier = new GephiFormat(fileName);
//		main object for gephi-format algorithm
		Graph graph = gephifier.formatForGephi();
		gephifier.file.writeGraphAsCSV(graph);
//		System.out.print(graph.toString());
	}
}
