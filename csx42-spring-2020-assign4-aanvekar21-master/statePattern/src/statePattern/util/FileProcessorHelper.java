package statePattern.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import statePattern.states.ExpenditureContext;
import statePattern.states.ExpenditureContextI;
import statePattern.states.ExpenditureStateI;

/**
 * @author Akshay Anvekar
 */
public class FileProcessorHelper implements FileProcessorHelperI {

	private ExpenditureContextI expenditureContextObj = new ExpenditureContext();

	private static FileProcessorHelperI filePrcHelperObj = new FileProcessorHelper();
	/**
	 * FileProcessorHelper Constructor
	 */
	private FileProcessorHelper() {

	}

	public static FileProcessorHelperI getInstance() {
		return filePrcHelperObj;
	}
	/**
	 * Method to Process the input File
	 *  and read it line by line
	 */
	public void processFile(FileProcessor fp, int windowsize) throws IOException,NullPointerException {

		try {
			String input;
			input = fp.readLine();

			if (input == null) {
				System.err.println("The input file is empty.Please provide the valid input file.");
			} 

			while (input != null) {
				
								
				
				String inputFormated[] = input.split(":");

				if (inputFormated[1].matches("[+-]?[0-9]+")) {
					expenditureContextObj.fetchListOfMoney(Integer.parseInt(inputFormated[1]));
				} else {
					expenditureContextObj.fetchListOfItems(inputFormated[1].trim());
				}
				input = fp.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "FileProcessorHelper obj =" + filePrcHelperObj;
	}

}
