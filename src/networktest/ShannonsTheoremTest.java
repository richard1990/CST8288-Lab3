/**
 * 	networktest is the package for class placement	
 */
package networktest;
//import statements
import java.text.DecimalFormat;
import network.ShannonsTheorem;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This class tests the ShannonsTheorem.java class using JUnit 4
 * @author    	Richard Barney
 * @version   	1.0.1 March 6, 2015
 */
public class ShannonsTheoremTest {
	/** ShannonsTheorem object used to call methods */
	ShannonsTheorem app = new ShannonsTheorem();
	/** DecimalFormat used to reduce decimals to two places */
	DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * Method that tests constructors
	 */
	@Test
	public void testConstructors() {
		new ShannonsTheorem();
	}
	
	/**
	 * Method that tests setBandwidth()
	 */
	@Test
	public void testSetBandwidth() {
		app.setBandwidth(3000);
		assertEquals(3000, app.getBandwidth(), 0);
	}
	
	/**
	 * Method that tests getBandwidth()
	 */
	@Test
	public void tesGetBandwidth() {
		app.setBandwidth(1000);
		assertEquals(1000, app.getBandwidth(), 0);
	}
	
	/**
	 * Method that tests setSignalToNoise()
	 */
	@Test
	public void testSetSignalToNoise() {
		app.setSignalToNoise(30);
		assertEquals(30, app.getSignalToNoise(), 0);
	}
	
	/**
	 * Method that tests getSignalToNoise()
	 */
	@Test
	public void testGetSignalToNoise() {
		app.setSignalToNoise(10);
		assertEquals(10, app.getSignalToNoise(), 0);
	}
	
	/**
	 * Method that tests getMaximumDataRate()
	 */
	@Test
	public void testGetMaximumDataRate() {
		app.setBandwidth(3000);
		app.setSignalToNoise(30);
		assertEquals(29901.68, Double.parseDouble(df.format(app.getMaximumDataRate())), 0);
	}
} // end class ShannonsTheoremTest
