package numberPlay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.InvalidPathException;

public class RunningAverageData implements PersisterI, RunningAverageResultsI {

	private static RunningAverageData avg;
	private static String result = "";
	File file;

	/**
	 * Constructor takes the filepath as argument
	 * 
	 * @param AvgFilepath
	 * @throws InvalidPathException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public RunningAverageData(String AvgFilepath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		file = new File(AvgFilepath);

	}

	/**
	 * The Method Creates an RunningAverageData instnace for this class
	 * 
	 * @param AvgFilepath
	 * @return
	 * @throws InvalidPathException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static RunningAverageData getInstance(String AvgFilepath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (null == avg) {
			avg = new RunningAverageData(AvgFilepath);

		}
		return avg;

	}

	/**
	 * 
	 * This method stores the data recieved from the Observer
	 */
	public void store(double d) {

		result = result.concat(String.valueOf(d) + "\n");
		// System.out.println(result);

	}

	/**
	 * 
	 * This Method writes results of Running Observer to a file
	 */
	public void writeToFile() {

		try {

			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			PrintStream printStream = new PrintStream(fileOutputStream);
			printStream.println(result);
			System.out.println("Running Average File is  written successfully");
		} catch (IOException ioe) {
			System.out.println("There was a problem in writing Running Average file");
		}
	}

	public void close() {

	}
}
