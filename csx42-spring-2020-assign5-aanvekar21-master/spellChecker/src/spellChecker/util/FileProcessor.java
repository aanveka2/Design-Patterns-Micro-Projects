package spellChecker.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


/**
 * @author Akshay Anvekar
 */
public class FileProcessor implements FileProcessorI {

	private BufferedReader br = null;

	/**
	 * The FileProcessor constructor that initializes Buffered Reader with
	 * filepath
	 * 
	 * @param filePath
	 *            - Path of the file to be read
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public FileProcessor(String inputFilePath) throws FileNotFoundException {
		try {
			br = new BufferedReader(new FileReader(inputFilePath));

		} catch (FileNotFoundException e) {
			throw e;
		}

	}

	/**
	 * This method reads the file line by line at a time and returns the line
	 * back to the caller function for processing
	 * 
	 * @return A single line read from the file
	 * @throws If
	 *             an I/O error occurs
	 */
	public String readLine() throws IOException {
		String line = null;
		return ((line = br.readLine()) != null) ? line.trim() : line;

	}

	/**
	 * Method for closing a file
	 * 
	 * @throws IOException
	 */
	public void closeFile() throws IOException {
		try {
			/**
			 *  Closing the file
			 */
			if (br != null)
				br.close();
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public String toString() {
		return "FileProcessor Buffered reader =" + br;
	}
}
