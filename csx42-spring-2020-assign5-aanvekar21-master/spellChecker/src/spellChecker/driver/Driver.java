package spellChecker.driver;

import java.io.FileNotFoundException;
import java.io.IOException;

import spellChecker.element.Element;
import spellChecker.element.MyArrayList;
import spellChecker.results.Results;
import spellChecker.results.SpellCheckResults;
import spellChecker.results.TopKFreqWordsResults;
import spellChecker.util.FileProcessor;
import spellChecker.visitor.SpellCheckAnalyzer;
import spellChecker.visitor.TopKMostFreqAnalyzer;
import spellChecker.visitor.Visitor;


/**
 * @author Akshay Anvekar
 */
public class Driver {

	private static void runAnalysis(FileProcessor fileProcessor, Visitor... visitors) throws NullPointerException, IOException {
		Element myArrayList = new MyArrayList.Builder().withFileProcessor(fileProcessor).build();

		for (Visitor visitor : visitors) {
			myArrayList.accept(visitor);
		}
	}

	private static void persistResults(Results... analysisResults) throws NullPointerException,FileNotFoundException, IOException {
		for (Results results : analysisResults) {
			results.writeToFile();
		}
	}

	public static void main(String[] args)
			throws InterruptedException, NullPointerException, IOException{
		try {

			/**
			 * As the build.xml specifies the arguments as argX, in case the
			 * argument value is not given java takes the default value
			 * specified in build.xml. To avoid that, below condition is used
			 */
			if (args.length != 5 || args[0].equals("${inputFile}") || args[1].equals("${acceptableWords}")
					|| args[2].equals("${sizeOfFreqWords}") || args[3].equals("${topKoutputFile}")
					|| args[4].equals("${spellCheckerOutputFile}")) {
				System.err.println("Error: Incorrect number of arguments. Program accepts 5 arguments.");
				System.exit(0);
			} 
			String inputFilename = args[0];
			String acceptableWordsFilename = args[1];
			int k = Integer.parseInt(args[2]);
			String topKOutputFilename = args[3];
			String spellCheckOutputFilename = args[4];
			
			/**
			 * Input validation on Window Size taken as Argument
			 */
			if (!(k> 0)) {
				System.err.println(
						" Incorrect value of Window Size. The expected value of Window Size is greater than  0");
				System.exit(0);
			}
			
			FileProcessor fileProcessor = new FileProcessor(inputFilename);

			Results topKFreqWordsResults = new TopKFreqWordsResults(topKOutputFilename);
			Visitor topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(k, topKFreqWordsResults);

			Results spellCheckResults = new SpellCheckResults(spellCheckOutputFilename);
			Visitor spellCheckAnalyzer = new SpellCheckAnalyzer(acceptableWordsFilename, spellCheckResults);

			runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);

			persistResults(topKFreqWordsResults, spellCheckResults);
			
	
		} catch (FileNotFoundException e) {
			System.err.println("Error: Please enter correct input argument with correct filepath");
			e.printStackTrace();
		}  catch (NullPointerException e) {
			e.printStackTrace();
		}

	}
}