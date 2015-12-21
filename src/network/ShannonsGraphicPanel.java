/**
 * network is the package for class placement	
 */
package network;
// import statements
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JPanel;
/**
 * This class represents a view in the MVC design pattern. Specifically, 
 * it draws the bottom part of the GUI which includes Java2D classes.
 * Makes use of the Observer interface and inherits from JPanel.
 * @author		Richard Barney
 * @version		1.0.0 March 6, 2015
 */
public class ShannonsGraphicPanel extends JPanel implements Observer {
	/** Eclipse-generated serialVersionUID. */
	private static final long serialVersionUID = 3709888226995317332L;
	/** ShannonsModel object. */
	private ShannonsModel model;
	
	/** 
	 * Default constructor.
	 */
	public ShannonsGraphicPanel() {
		this.model = null; // set to null to prevent this class from drawing at launch
	} // end constructor
	
	/**
	 * Overridden update method called by the Observable object.
	 * @param	o		the observable object
	 * @param	args	an argument passed to the notifyObservers method
	 */
	@Override
	public void update(Observable o, Object args) {
		if (o instanceof ShannonsModel) {
			model = (ShannonsModel) o;
			this.repaint();
		}
	} // end update method
	 
	/**
	 * Draws the rectangles, Strings, etc.
	 * @param	g	Graphics object
	 */
	public void paintComponent(Graphics g) {
		// if ShannonsModel is not null, then draw the stuff, this way the program
		// starts without this area painted yet as per the specs
		if (model != null) {
			int nBarHeight = (this.getHeight() / 3); // used to determine height of ea individual bar, code provided by prof. Stan Pieda
			int nMaxBandwidth = 3000; // used to help calculate the width of bandwidth bar
			int nMaxSignalToNoise = 30; // used to help calculate the snr bar
			double dMaxMaximumDataRate = 29901.68; // used to help calculate the mdr bar
			Color barColor = new Color(232, 227, 135); // bar color
			Color fontColor = new Color(0,0,0); // font color
			Color rectangleColor = new Color(255, 255, 255); // bg rectangle color
			Font font = new Font("SansSerif", Font.PLAIN, 10); // font style
			g.setFont(font); // set the font
			g.setColor(rectangleColor); // set the bg rectangle color
			g.fillRect(0, 0, this.getWidth(), this.getHeight()); // draw the bg rectangle
			
			// draw bandwidth bar
			g.setColor(barColor);
			g.fillRect(0, 0, (int) ((model.getBandwidth() / nMaxBandwidth) * this.getWidth()), nBarHeight);
			g.setColor(fontColor);
			g.drawString("bw(herz):" + model.getBandwidth(), 0, 12);
			
			// draw snr bar
			g.setColor(barColor);
			g.fillRect(0, 17, (int) ((model.getSignalToNoise() / nMaxSignalToNoise) * this.getWidth()), nBarHeight);
			g.setColor(fontColor);
			g.drawString("snr(db):" + model.getSignalToNoise(), 0, 30);
			
			// draw mdr bar
			g.setColor(barColor);
			g.fillRect(0, 34, (int) ((model.getMaximumDataRate() / dMaxMaximumDataRate) * this.getWidth()), nBarHeight);
			g.setColor(fontColor);
			g.drawString("mdr(bps):" + model.getMaximumDataRate(), 0, 48);
		}
	} // end method paintComponent
} // end class ShannonsGraphicPanel