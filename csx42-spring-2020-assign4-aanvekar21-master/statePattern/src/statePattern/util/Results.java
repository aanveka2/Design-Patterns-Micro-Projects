package statePattern.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Akshay Anvekar
 */
public class Results implements ResultsI {

	static String outputFile;
	private static ResultsI resultsObj = new Results(outputFile);

	private BufferedWriter buffrdWriter;

	private FileWriter fileWriter;

	public static ResultsI getInstance() {
		return resultsObj;
	}
	
	public Results(String filePath) {
		outputFile = filePath;

	}
	/**
	 * Method to open the output file and 
	 * creates if the file does not exists
	 */
	public void openFile(String filePath) throws FileNotFoundException, IOException {
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileWriter = new FileWriter(file);
			buffrdWriter = new BufferedWriter(fileWriter);
		} catch (FileNotFoundException e) {
			throw e;
		}catch(IOException ie){
			throw ie;
		}
	}

	/**
	 * This function writes data to bufferedWrite
	 * 
	 * @param stateResult
	 *            
	 */
	public void stateResults(String stateResult) throws IOException {

		buffrdWriter.write(stateResult.trim() + "\n");
	}

	/**
	 * This function closes the file connection and flushes the buffrdWriter to
	 * the file
	 * 
	 * @throws IOException
	 */
	public void closeFile() throws IOException {
		try {
			buffrdWriter.flush();
			if (buffrdWriter != null)
				buffrdWriter.close();
		} catch (IOException e) {
			throw e;
		}
	}
	@Override
	public String toString() {
		return "Results Buffered Writer =" + buffrdWriter;
	}

}
