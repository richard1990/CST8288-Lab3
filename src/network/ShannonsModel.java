/**
 * network is the package for class placement	
 */
package network; 
//import statements
import java.lang.Math;
import java.util.Observable;
/**
 * This class holds the data for a simulation of Shannon's Theorem and 
 * is the model in the MVC design pattern, inherits from Observable.
 * @author    	Richard Barney
 * @version   	1.0.0 March 6, 2015
 */
public class ShannonsModel extends Observable {
	/** Double used for bandwidth input (hertz). */
	private double bandwidth;
	/** Double used for signal-to-noise ratio input (decibels). */
	private double signalToNoise;

	/** Default constructor */
	public ShannonsModel() {
		super();
	}

	/**
	 * Get method that returns the bandwidth (hertz).
	 * @return	bandwidth	double containing the bandwidth.
	 */
	public double getBandwidth() { return bandwidth; }
	/**
	 * Get method that returns the signal-to-noise ratio (decibels).
	 * @return	signalToNoise	double containing the signal-to-noise ratio.
	 */
	public double getSignalToNoise() { return signalToNoise; }
	/**
	 * Private get method that returns the maximum data rate in bits per second.
	 * @param    hertz    		double to represent bandwidth in hertz.
	 * @param    signalToNoise	double to represent signal-to-noise ratio (decibels).
	 * @return maximum data rate in bits per second as a double.
	 */
	private double getMaximumDataRate(double hertz, double signalToNoise) { return (hertz *  (Math.log(1+Math.pow(10, signalToNoise/10)) / Math.log(2))); }
	/**
	 * Overloaded get method that returns the maximum data rate
	 * @return maximum data rate as a double
	 */
	public double getMaximumDataRate() { return getMaximumDataRate(bandwidth, signalToNoise); }

	/**
	 * Set method for bandwidth and notifies observers of change.
	 * @param    bandwidth    double containing the bandwidth (hertz).
	 */
	public void setBandwidth(double bandwidth) { 
		this.bandwidth = bandwidth;
		this.setChanged();
		this.notifyObservers();	
	}
	/**
	 * Set method for signal-to-noise ratio and notifies observers of change.
	 * @param    signalToNoise   double containing the signal-to-noise ratio (decibels).
	 */
	public void setSignalToNoise(double signalToNoise) { 
		this.signalToNoise = signalToNoise;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * toString method that returns all data entered by user and displays maximum data rate.
	 * @return String containing bandwidth, signal-to-noise ratio, and bits-per-second.
	 */
	public String toString() {
		 return	"["
		 		+"After calculating Shannon's Theorem with a bandwidth of "
		 		+getBandwidth()
		 		+" hertz and a\nsignal-to-noise ratio of "
		 		+getSignalToNoise()
		 		+" decibels, the result is "
		 		+String.format("%.2f",getMaximumDataRate())
		 		+" bits-per-second.]";
	} // end method toString
} // end class ShannonsModel