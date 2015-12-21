/**
 * 	networktest is the package for class placement	
 */
package networktest;
//import statements
import network.ShannonsModel;
import static org.junit.Assert.*;
import java.text.DecimalFormat;
import org.junit.Test;
/**
 * This class tests the ShannonsModel.java class using JUnit 4
 * @author    	Richard Barney
 * @version   	1.0.1 March 6, 2015
 */
public class ShannonsModelTest {
	/** ShannonsModel object used to call methods */
	ShannonsModel model = new ShannonsModel();
	/** DecimalFormat used to reduce decimals to two places */
	DecimalFormat df = new DecimalFormat("#.##");
	
	/**
	 * Method that tests constructors
	 */
	@Test
	public void testConstructors() {
		new ShannonsModel();
	}
	
	/**
	 * Method that tests setBandwidth()
	 */
	@Test
	public void testSetBandwidth() {
		model.setBandwidth(3000);
		assertEquals(3000, model.getBandwidth(), 0);
	}
	
	/**
	 * Method that tests getBandwidth()
	 */
	@Test
	public void tesGetBandwidth() {
		model.setBandwidth(1000);
		assertEquals(1000, model.getBandwidth(), 0);
	}
	
	/**
	 * Method that tests setSignalToNoise()
	 */
	@Test
	public void testSetSignalToNoise() {
		model.setSignalToNoise(30);
		assertEquals(30, model.getSignalToNoise(), 0);
	}
	
	/**
	 * Method that tests getSignalToNoise()
	 */
	@Test
	public void testGetSignalToNoise() {
		model.setSignalToNoise(10);
		assertEquals(10, model.getSignalToNoise(), 0);
	}
	
	/**
	 * Method that tests getMaximumDataRate()
	 */
	@Test
	public void testGetMaximumDataRate() {
		model.setBandwidth(3000);
		model.setSignalToNoise(30);
		assertEquals(29901.68, Double.parseDouble(df.format(model.getMaximumDataRate())), 0);
	}
	
	/**
	 * Method that tests toString()
	 */
	@Test
	public void testToString() {
		String sMessage = "[After calculating Shannon's Theorem with a bandwidth of 0.0 hertz and a\nsignal-to-noise ratio of 0.0 decibels, the result is 0.00 bits-per-second.]";
		assertEquals(sMessage, model.toString());
	}
} // end class ShannonsTheoremTest