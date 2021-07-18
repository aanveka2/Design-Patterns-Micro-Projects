package wordPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;
import wordPlay.util.Results;

public class SentenceHandler {

	String write = "";

	static StringBuffer reverseWords = new StringBuffer();
	float wordCount = 0;
	float sentenceCount = 0;
	float characterCount = 0;
	String word = null;
	String longestWord = "";

	public FileWriter fw = null;
	public String output = null;
	Results res = new Results();

	/**
	 * This method handles each line taking the outputfile path to pass it to 
	 * @param line
	 * @param outputfilepath
	 * @return
	 * @throws IOException
	 */
	public StringBuffer sentenceHandler(String line, String outputfilepath) throws IOException {

		/**
		 * Tokenizing line using string tokenizer
		 */
		StringTokenizer tok = new StringTokenizer(line, ". \r?\n", true);

		while (tok.hasMoreElements()) {

			/**
			 * fetch next word from string tokenizer
			 */
			word = (String) tok.nextElement();

			/**
			 * Calling Reverse Method
			 */
			reverseWords = reverseWord(word);

		}

		try {
			/**
			 * Output after reversing input text
			 */

			PrintStream outputStream = new PrintStream(new File(outputfilepath));

			outputStream.println(reverseWords.toString());
			outputStream.close();
			//System.out.print(reverseWords.toString());

			} catch (Exception e) {

			e.printStackTrace();
		}
		return reverseWords;

	}

	public static StringBuffer reverseWord(String word) {
		/**
		 * This performs reversing of words
		 */
		for (int i = word.length() - 1; i >= 0; i--) {
			reverseWords.append(word.charAt(i));

		}
		return reverseWords;
	}

}