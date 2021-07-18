package numberPlay.subject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class IntegerFilter implements FilterI {

	private static IntegerFilter IntFilter;

	/**
	 * 
	 * Method to check the Integer values of the input number
	 */
	public boolean check(String number) {

		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException nfe) {

			return false;
		}

	}

	public static IntegerFilter getInstance()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (null == IntFilter) {
			IntFilter = new IntegerFilter();

		}
		return IntFilter;

	}

}
