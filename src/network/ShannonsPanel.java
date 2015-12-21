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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class represents a view in the MVC design pattern. Specifically, 
 * it draws the top part of the GUI which includes JTextFields and JLabels.
 * Makes use of the Observer interface and inherits from JPanel.
 * @author    	Richard Barney
 * @version   	1.0.0 March 6, 2015
 */
public class ShannonsPanel extends JPanel implements Observer {
	/** Eclipse-generated serialVersionUID. */
	private static final long serialVersionUID = 1619047577451673769L;
	/** ShannonsController object. */
	private ShannonsController controller;
	/** JLabel object to display max data rate. */
	private JLabel maxDataRateJLabel;
	/** JTextField object for bandwidth. */
	private JTextField bandwidthJTextField;
	/** JTextField object for signal-to-noise ratio. */
	private JTextField signalToNoiseJTextField;
	
	/**
	 * Constructor that passes ShannonsController as a parameter.
	 * Sets up class and calls configureEvents() for listeners and
	 * assembleUserInterface() to create the GUI.
	 * @param	controller	ShannonsController object
	 */
	public ShannonsPanel(ShannonsController controller) {
		this.controller = controller;
		bandwidthJTextField = new JTextField();
		signalToNoiseJTextField = new JTextField();
		maxDataRateJLabel = new JLabel();
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
			bandwidthJTextField.setText(String.valueOf(model.getBandwidth())); // set bandwidthJTextField by getting the bandwidth
			signalToNoiseJTextField.setText(String.valueOf(model.getSignalToNoise())); // set signalToNoiseJTextField by getting the signal-to-noise
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
		
		// set up the two JTextFields and one JLabel on right for max data rate
		JPanel fieldsJPanel = new JPanel(new GridLayout(3,1));
		fieldsJPanel.add(bandwidthJTextField);
		fieldsJPanel.add(signalToNoiseJTextField);
		fieldsJPanel.add(maxDataRateJLabel);
		
		// set up the layout
		this.setLayout(new BorderLayout());
		this.add(labelsJPanel, BorderLayout.WEST);
		this.add(fieldsJPanel, BorderLayout.CENTER);
	} // end method assembleUserInterface
	
	/**
	 * Void method that configures events on the JTextFields 
	 * using ActionListeners.
	 */
	private void configureEvents() {
		// if an action is performed on bandwidthJTextField, set the bandwidth with what the
		// user entered, also check for valid input
		bandwidthJTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.setBandwidth(Double.parseDouble(bandwidthJTextField.getText()));
				} catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(ShannonsPanel.this, "Invalid input! Please enter a valid number!", "Error encountered!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	
		// if an action is performed on signalToNoiseJTextField, set the signal-to-noise with what the
		// user entered, also check for valid input
		signalToNoiseJTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.setSignalToNoise(Double.parseDouble(signalToNoiseJTextField.getText()));
				} catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(ShannonsPanel.this, "Invalid input! Please enter a valid number!", "Error encountered!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	} // end method configureEvents
} // end class ShannonsPanel