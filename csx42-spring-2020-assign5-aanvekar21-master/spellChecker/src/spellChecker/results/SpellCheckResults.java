package spellChecker.results;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SpellCheckResults implements Results {

	private BufferedWriter buffrdWriter;
	private FileWriter fileWriter;

	private String spellCheckWord = "";
	private String spellCheckOutputFilename;

	public SpellCheckResults(String inSpellCheckOutputFilename) {
		spellCheckOutputFilename = inSpellCheckOutputFilename;
	}
	/**
	 * This method performs the 
	 * writing onto the output file
	 */
	@Override
	public void writeToFile() throws FileNotFoundException, NullPointerException, IOException {

		try {
			File file = new File(spellCheckOutputFilename);
			if (!file.exists()) {
				file.createNewFile();
			}
			// System.out.print(file.getAbsolutePath());
			fileWriter = new FileWriter(file);
			buffrdWriter = new BufferedWriter(fileWriter);
			System.out.println(spellCheckWord);
			buffrdWriter.write(spellCheckWord);
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

		spellCheckWord = spellCheckWord + data + "\n";

	}

}
