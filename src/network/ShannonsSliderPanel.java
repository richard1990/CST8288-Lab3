/**
 * network is the package for class placement	
 */
package network;
// import statements
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
/**
 * This class represents a view in the MVC design pattern. Specifically, 
 * it draws the middle part of the GUI which includes JScrollBars and JLabels.
 * Makes use of the Observer interface and inherits from JPanel.
 * @author		Richard Barney
 * @version		1.0.0 March 6, 2015
 */
public class ShannonsSliderPanel extends JPanel implements Observer {
	/** Eclipse-generated serialVersionUID. */
	private static final long serialVersionUID = 9064893956178440057L;
	/** ShannonsController object. */
	private ShannonsController controller;
	/** JLabel object to display max data rate. */
	private JLabel maxDataRateJLabel;
	/** JScrollBar object for bandwidth. */
	private JScrollBar bandwidthJScrollBar;
	/** JScrollBar object for signal-to-noise ratio. */
	private JScrollBar signalToNoiseJScrollBar;
	
	/**
	 * Constructor that passes ShannonsController as a parameter.
	 * Sets up class and calls configureEvents() for listeners and
	 * assembleUserInterface() to create the GUI.
	 * @param	controller	ShannonsController object
	 */
	public ShannonsSliderPanel(ShannonsController controller) {
		this.controller = controller;
		maxDataRateJLabel = new JLabel();
		bandwidthJScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 3001); //  max is 3001 to allow proper formating when 3000 is entered
		signalToNoiseJScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 31); // max is 31 to allow proper formating when 30 is entered
		configureEvents();
		assembleUserInterface();
	} // end constructor
	
	/**
	 * Overridden update method called by the Observable object.
	 * @param	o		the observable object.
	 * @param	args	an argument passed to the notifyObservers method.
	 */
	@Override
	public void update(Observable o, Object args) {
		if (o instanceof ShannonsModel) {
			ShannonsModel model = (ShannonsModel) o;
			bandwidthJScrollBar.setValue((int) model.getBandwidth()); // set bandwidthJScrollBar's value to the bandwidth
			signalToNoiseJScrollBar.setValue((int) model.getSignalToNoise()); // set signalToNoiseJScrollBar's value to the signal-to-noise
			maxDataRateJLabel.setText(String.valueOf(model.getMaximumDataRate())); // display the max data rate
		}
	} // end method update

	/**
	 * Void method that sets up the UI, makes use of GridLayouts 
	 * and BorderLayouts.
	 */
	private void assembleUserInterface() {
		// set up three JLabels on left to specify what they associate with on right
		JPanel 	labelsJPanel = new JPanel(new GridLayout(3,1));
		labelsJPanel.add(new JLabel("Bandwidth (hertz)"));
		labelsJPanel.add(new JLabel("Signal to Noise (db)"));
		labelsJPanel.add(new JLabel("Maximum Data Rate (bps)"));
		
		// set up the two JScrollBars and one JLabel on right for max data rate
		JPanel scrollBarsJPanel = new JPanel(new GridLayout(3,1));
		scrollBarsJPanel.add(bandwidthJScrollBar);
		scrollBarsJPanel.add(signalToNoiseJScrollBar);
		scrollBarsJPanel.add(maxDataRateJLabel);
		
		// set up the layout
		this.setLayout(new BorderLayout());
		this.add(labelsJPanel, BorderLayout.WEST);
		this.add(scrollBarsJPanel, BorderLayout.CENTER);
	} // end method assembleUserInterface
	
	/**
	 * Void method that configures events on the JScrollBar using 
	 * AdjustmentListeners.
	 */
	private void configureEvents() {
		// if an action is performed on bandwidthJScrollBar, set the bandwidth with the
		// current value of bandwidthJScrollBar
		bandwidthJScrollBar.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				controller.setBandwidth((double) bandwidthJScrollBar.getValue());
			}
		});
		
		// if an action is performed on signalToNoiseJScrollBar, set the signal-to-noise with the
		// current value of signalToNoiseJScrollBar		
		signalToNoiseJScrollBar.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				controller.setSignalToNoise((double) signalToNoiseJScrollBar.getValue());
			}
		});
	} // end method configureEvents
} // end class ShannonsSliderPanel