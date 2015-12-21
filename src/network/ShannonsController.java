/**
 * network is the package for class placement	
 */
package network;
// import statements
import java.util.Observer;
/**
 * This class is an interface that defines the methods available to the controller.
 * @author		Richard Barney
 * @version		1.0.0 March 6, 2015
 */
public interface ShannonsController {
	/**
	 * Adds an observer to the set of observers for this object.
	 * @param	observer	an observer to be added
	 */
	void addObserver(Observer observer);
	/**
	 * Set method that sets the bandwidth.
	 * @param	bandwidth	bandwidth to set as double.
	 */
	void setBandwidth(double bandwidth);
	/**
	 * Set method that sets the signal-to-noise ratio.
	 * @param	signalToNoise	signal-to-noise ratio set as double.
	 */
	void setSignalToNoise(double signalToNoise);
} // end interface ShannonsController
