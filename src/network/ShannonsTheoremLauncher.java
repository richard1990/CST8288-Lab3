/**
 * network is the package for class placement	
 */
package network;
// import statements
import javax.swing.JFrame;
import java.awt.GridLayout;
/**
 * This class creates the MVC objects, assembles them together, and
 * then runs the program in a JFrame. Code provided by prof. Stan Pieda.
 * @author    	Stan Pieda, Richard Barney
 * @version   	1.0.0 March 6, 2015
 */
public class ShannonsTheoremLauncher {
	/**
	 * Entry point "main()" as required by the JVM.
	 * @param	args	standard command line parameters (arguments) as a string array
	 */
	public static void main(String[] args) {
		ShannonsTheorem controller = new ShannonsTheorem();
		ShannonsPanel view = new ShannonsPanel(controller);
		ShannonsSliderPanel sliderView = new ShannonsSliderPanel(controller);
		ShannonsGraphicPanel graphicView = new ShannonsGraphicPanel();
		
		controller.addObserver(view);
		controller.addObserver(sliderView);
		controller.addObserver(graphicView);
		
		JFrame frame = new JFrame("Shannon's Theorem");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3,1));
		frame.getContentPane().add(view);
		frame.getContentPane().add(sliderView);
		frame.getContentPane().add(graphicView);
	    frame.setVisible(true);
	} // end method main
} // end class ShannonsTheoremLauncher