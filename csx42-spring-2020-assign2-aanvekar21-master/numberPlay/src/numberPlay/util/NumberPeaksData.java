package numberPlay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.InvalidPathException;

public class NumberPeaksData implements PersisterI, NumberPeaksResultsI {

	private static NumberPeaksData NumPeak;
	private static String result = "";
	File file;

	public NumberPeaksData(String PeakFilePath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		file = new File(PeakFilePath);

	}

	public static NumberPeaksData getInstance(String PeakFilePath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (null == NumPeak) {
			NumPeak = new NumberPeaksData(PeakFilePath);

		}
		return NumPeak;

	}

	/**
	 * This method store the Data recieved from the Observer
	 */
	@Override
	public void store(double d) {

		result = result.concat(String.valueOf(d) + "\n");
		// System.out.println(d);

	}

	/**
	 * This method writes the Data to a specified final
	 */
	@Override
	public void writeToFile() {
		// System.out.println(result);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			PrintStream printStream = new PrintStream(fileOutputStream);
			printStream.println(result);
			System.out.println("Running NumberPeaks File is  written successfully");

		} catch (IOException ioe) {
			System.out.println("There was a problem in writing Running Average file");
		}

	}

	@Override
	public void close() {
	}
}
