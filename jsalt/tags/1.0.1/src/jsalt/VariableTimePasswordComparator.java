package jsalt;


/**
 * Utility for variable time comparison to prevent against timing attacks.
 * 
 * @author Peter P. Lupo
 */
public class VariableTimePasswordComparator {

	/**
	 * Variable time comparison to prevent against timing attacks.
	 * In opposition to constant time comparison, this comparison has the time defined by the length
	 * of the testing password instead of being based on the length of the actual password.
	 * 
	 * @param password The actual password.
	 * @param testingPassword The testing password. Time of comparison varies according to the length of this parameter.
	 * @return true if passwords are equal. False otherwise.
	 */
	public static boolean equals(String password, String testingPassword) {
		if ((password == testingPassword) || ("".equals(password) && "".equals(testingPassword))) {
			return true;
		}
		
		boolean equals = true;
		
		String[] splitTestingPassword = new String[0];
		if (testingPassword != null) {
			splitTestingPassword = testingPassword.split("");
		}
		
		String[] splitPassword = new String[0];
		if (password != null) {
			splitPassword = password.split("");
		}
		
		int diff = splitPassword.length - splitTestingPassword.length;
		
		equals = diff == 0;
		
		if (diff >= 0) {
			for (int i = 0; i < splitTestingPassword.length; i++) {
				if (i > splitPassword.length-1) {
					splitTestingPassword[i].equals(splitTestingPassword[i]);
					continue;
				}
				if (equals) {
					equals = splitPassword[i].equals(splitTestingPassword[i]);
				}
				if (!equals) {
					splitPassword[i].equals(splitTestingPassword[i]);	
				}
			}
		}
		if (diff < 0) {
			for (int i = 0; i < splitTestingPassword.length; i++) {
				if (i > splitPassword.length-1) {
					splitTestingPassword[i].equals(splitTestingPassword[i]);
					continue;
				}
				if (equals) {
					equals = splitPassword[i].equals(splitTestingPassword[i]);
				}
				if (!equals) {
					splitPassword[i].equals(splitTestingPassword[i]);	
				}
			}
		}
		return equals;
	}
	
	private VariableTimePasswordComparator() {
	}
}