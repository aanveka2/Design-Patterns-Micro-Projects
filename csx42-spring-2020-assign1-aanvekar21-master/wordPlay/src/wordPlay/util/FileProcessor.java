package wordPlay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Akshay Anvekar
 */

public class FileProcessor {

	
	String inputfilepath;
	String outputfilepath;
	String metricsfilepath;
	/**
	 * 
	 * Constructor to take arguments
	 * @param args
	 */
	public FileProcessor(String[] args ){
		
		
		this.inputfilepath = args[0];
		this.outputfilepath = args[1];
		this.metricsfilepath = args[2];
	}
	
	/**
	 * 
	 * This method takes in input from path specified in Driver 
	 * 
	 * @param inputfilepath
	 * @return
	 * @throws IOException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public String inputFile(String inputfilepath) throws IOException, ArrayIndexOutOfBoundsException {
		/**
		 * Read file to buffer
		 */
		String line = null;
		File file = new File(inputfilepath);
		FileReader input = null;
		FileReader input1 = null;
		BufferedReader sentReader = null;
		BufferedReader metricReader = null;
		try {
			input = new FileReader(file);
			input1 = new FileReader(file);
			sentReader = new BufferedReader(input);
			metricReader = new BufferedReader(input1);
			Metrics m = new Metrics();
			m.LongestWord(sentReader,metricsfilepath,outputfilepath);
			m.maxFrequency(metricReader, metricsfilepath);
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (metricReader != null) {
					metricReader.close();
				}
				if (sentReader != null) {
					sentReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return line;

	}

}