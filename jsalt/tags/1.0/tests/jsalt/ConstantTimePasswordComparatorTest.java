package jsalt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import jsalt.VariableTimePasswordComparator;

import org.junit.Test;


public class ConstantTimePasswordComparatorTest {
	
	private static String password = "00000000000000000000000000000000";
	private static String passwordSameSize1 = "11111111111111111111111111111111";
	private static String passwordQuarterSize0 = "00000000";
	private static String passwordQuarterSize1 = "11111111";
	private static String passwordDoubleSize0 = "0000000000000000000000000000000000000000000000000000000000000000";
	private static String passwordDoubleSize1 = "1111111111111111111111111111111111111111111111111111111111111111";
	private static String passwordOtherInstance = new String("00000000000000000000000000000000");
	private static String emptyPassword = "";
	private static String nullPassword = null;
	
	@Test
	public void testComparison() {
		assertTrue(VariableTimePasswordComparator.equals(password, password));
		assertTrue(VariableTimePasswordComparator.equals(password, passwordOtherInstance));
		assertTrue(VariableTimePasswordComparator.equals(emptyPassword, emptyPassword));
		assertTrue(VariableTimePasswordComparator.equals(nullPassword, nullPassword));
		assertFalse(VariableTimePasswordComparator.equals(password, emptyPassword));
		assertFalse(VariableTimePasswordComparator.equals(emptyPassword, password));
		assertFalse(VariableTimePasswordComparator.equals(nullPassword, password));
		assertFalse(VariableTimePasswordComparator.equals(password, nullPassword));
		assertFalse(VariableTimePasswordComparator.equals(password, passwordSameSize1));
		assertFalse(VariableTimePasswordComparator.equals(password, passwordQuarterSize0));
		assertFalse(VariableTimePasswordComparator.equals(password, passwordDoubleSize0));
		assertFalse(VariableTimePasswordComparator.equals(password, passwordQuarterSize1));
		assertFalse(VariableTimePasswordComparator.equals(password, passwordDoubleSize1));
	}
}
