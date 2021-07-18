package wordPlay.driver;

import java.io.File;
import java.io.IOException;

import wordPlay.util.FileProcessor;

/**
 * @author Akshay Anvekar
 */
public class Driver {
	
	/**
	 * 
	 * This method class the FileProcessor and takes in arguments
	 * for input
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		if (args.length <= 0 || args[0] == null || args[1] == null|| args[2] == null) {
		 System.out.println("Provide the input file Output and Metrics file");
		}
		
		String inputfile = args[0];
		String outputfile = args[1];
		String metricsfile = args[2];

		if (inputfile.isEmpty()) {
			System.out.println("Please enter valid inputfile path");
		}
		/**
		 * 
		 * This method creates a new file if output file is not created
		 */
		if (outputfile.isEmpty()) {
			try {

				File outputFile = new File("output.txt");
				outputFile.createNewFile();

				File metricFile = new File("metrics.txt");
				metricFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		FileProcessor fp = new FileProcessor(args);

		fp.inputFile(inputfile);

	}
}