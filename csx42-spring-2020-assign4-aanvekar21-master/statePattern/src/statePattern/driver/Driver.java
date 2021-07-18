package statePattern.driver;

import java.io.FileNotFoundException;
import java.io.IOException;

import statePattern.util.AvailableItemHelper;
import statePattern.util.FileProcessor;
import statePattern.util.FileProcessorHelper;
import statePattern.util.Results;
import statePattern.util.StateInputParameter;
import statePattern.util.StateInputParametersI;

/**
 * @author Akshay Anvekar
 */
public class Driver {
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException,NullPointerException {
		try {

			StateInputParametersI stateInputParamsObj = StateInputParameter.getInstance();
			/**
			 * As the build.xml specifies the arguments as argX, in case the
			 * argument value is not given java takes the default value
			 * specified in build.xml. To avoid that, below condition is used
			 */
			if (args.length != 4 || args[0].equals("${inputFile}") || args[1].equals("${availableItemsFile}")
					|| args[2].equals("${runningAverageWindowSize}") || args[3].equals("${outputFile}")) {
				System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
				System.exit(0);
			} else {

				stateInputParamsObj.setInputFilePath(args[0]);
				stateInputParamsObj.setItemInputFilePath(args[1]);
				stateInputParamsObj.setWindowSize(args[2]);
				stateInputParamsObj.setoutputFilePath(args[3]);

			}
			/**
			 * Input validation on Window Size taken as Argument
			 */
			if (!(stateInputParamsObj.getWindowSize() >= 0)) {
				System.err.println(" Incorrect value of Window Size. The expected value of Window Size is greater than or equal to 0");
				System.exit(0);
			}
			/**
			 * Create FileProcessor object for input file and available items
			 */
			FileProcessor inputFile_fp = new FileProcessor(stateInputParamsObj.getInputFilePath());
			FileProcessor availableItem_fp = new FileProcessor(stateInputParamsObj.getItemInputFilePath());

			/**
			 * Create Result object for the Output File
			 */
			Results.getInstance().openFile(stateInputParamsObj.getoutputFilePath());

			AvailableItemHelper.getInstance().processFile(availableItem_fp);

			FileProcessorHelper.getInstance().processFile(inputFile_fp, stateInputParamsObj.getWindowSize());

			/**
			 * Closing the Input and Output files 
			 */
			inputFile_fp.closeFile();
			availableItem_fp.closeFile();
			Results.getInstance().closeFile();
		}  catch (FileNotFoundException e) {
			System.err.println("Error: Please enter correct input argument with correct filepath");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}

	}
}