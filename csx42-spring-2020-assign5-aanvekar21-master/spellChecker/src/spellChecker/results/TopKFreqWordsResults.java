package spellChecker.results;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TopKFreqWordsResults implements Results {
	private String topKOutputFilename = "";

	private BufferedWriter buffrdWriter;

	private FileWriter fileWriter;
	private String topKWords = "";

	public TopKFreqWordsResults(String inTopKOutputFilename) {
		topKOutputFilename = inTopKOutputFilename;
	}
	/**
	 * This method performs the 
	 * writing onto the output file
	 */
	@Override
	public void writeToFile() throws FileNotFoundException, NullPointerException, IOException {
		try {
			File file = new File(topKOutputFilename);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileWriter = new FileWriter(file);
			buffrdWriter = new BufferedWriter(fileWriter);
			System.out.println(topKWords);
			buffrdWriter.write(topKWords);
		} catch (FileNotFoundException e) {
			throw e;
		} catch (NullPointerException ie) {
			throw ie;
		}

		catch (IOException ie) {
			throw ie;
		} finally {
			buffrdWriter.close();
		}

	}
	/**
	 * Method to store the incoming data from the visitor
	 */
	@Override
	public void storeResults(String data) {
		topKWords = topKWords + data + "\n";

	}

}
