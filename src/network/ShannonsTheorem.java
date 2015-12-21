/**
 * network is the package for class placement	
 */
package network;
// import statements
import java.util.Observer;
/**
 * This class implements ShannonsController and uses a delegate design pattern
 * by delegating most of its functionality to the ShannonsModel class.
 * @author		Richard Barney
 * @version		1.0.0 March 6, 2015
 */
public class ShannonsTheorem implements ShannonsController {
	/** ShannonsModel object. */
	private ShannonsModel model = new ShannonsModel();
	
	/** Default constructor. */
	public ShannonsTheorem() {
		super();
	}
	
	/**
	 * Void method that adds an observer to the set of observers 
	 * for this object.
	 * @param	observer	an observer to be added
	 */
	public void addObserver(Observer observer) {
		model.addObserver(observer);
	}
	
	/**
	 * Get method that returns ShannonsModel.getBandwidth()
	 * @return bandwidth as a double
	 */
	public double getBandwidth() { return model.getBandwidth(); }
	/**
	 * Get method that returns ShannonsModel.getSignalToNoise().
	 * @return signal-to-noise ratio as a double
	 */
	public double getSignalToNoise() { return model.getSignalToNoise(); }
	/**
	 * Get method that returns ShannonsModel.getMaximumDataRate().
	 * @return maximum data rate as a double
	 */
	public double getMaximumDataRate() { return model.getMaximumDataRate(); }
	
	/**
	 * Set method that sets hertz as a double using ShannonsModel.setBandwidth.
	 * @param    hertz    hertz to set as a double
	 */
	public void setBandwidth(double hertz) { model.setBandwidth(hertz); }
	/**
	 * Set method that sets signal-to-noise ratio as a double using ShannonsModel.setSignalToNoise.
	 * @param    signalToNoise   signal-to-noise ratio to set as a double 
	 */
	public void setSignalToNoise(double signalToNoise) { model.setSignalToNoise(signalToNoise); }
} // end class ShannonsTheorem