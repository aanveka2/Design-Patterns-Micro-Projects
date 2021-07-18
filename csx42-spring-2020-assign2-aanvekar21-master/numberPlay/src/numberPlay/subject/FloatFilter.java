package numberPlay.subject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class FloatFilter implements FilterI {

	private static FloatFilter floatFilter;

	/**
	 * 
	 * Method to check the weather input number is of Float
	 */
	public boolean check(String number) {

		try {
			Float.parseFloat(number);
			return true;
		} catch (NumberFormatException nfe) {

			return false;
		}

	}

	public static FloatFilter getInstance()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (null == floatFilter) {
			floatFilter = new FloatFilter();

		}
		return floatFilter;

	}

}
