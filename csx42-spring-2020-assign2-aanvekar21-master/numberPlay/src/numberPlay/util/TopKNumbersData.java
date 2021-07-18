package numberPlay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;

public class TopKNumbersData implements PersisterI, TopKNumbersResultsI {

	private static TopKNumbersData TopK;
	private List result = new ArrayList<String>();
	File file;

	/**
	 * Constructor to take the File path as arguments
	 * 
	 * @param TopKFilPath
	 * @throws InvalidPathException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public TopKNumbersData(String TopKFilPath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		file = new File(TopKFilPath);

	}

	public static TopKNumbersData getInstance(String TopKFilPath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (null == TopK) {
			TopK = new TopKNumbersData(TopKFilPath);

		}
		return TopK;

	}

	@Override
	public void store(List<Double> list) {

		System.out.println(list.toString());
	}

	@Override
	public void writeToFile() {

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			PrintStream printStream = new PrintStream(fileOutputStream);
			printStream.println(result);
			System.out.println("Running Top K Numbers File is  written successfully");

		} catch (IOException ioe) {
			System.out.println("There was a problem in writing Running Average file");
		}

	}

	@Override
	public void close() {
	}
}
