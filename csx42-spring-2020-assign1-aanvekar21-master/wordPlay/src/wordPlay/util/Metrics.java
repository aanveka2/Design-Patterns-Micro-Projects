package wordPlay.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Akshay Anvekar
 */

public class Metrics {

	String longestWord = "";
	float wordCount = 0;
	float sentenceCount = 0;
	float characterCount = 0;
	String word = null;
	Results res = new Results();

	public FileWriter fw = null;
	public String output = null;

	SentenceHandler sent = new SentenceHandler();

	/**
	 * 
	 * This function searches longest word from the text file
	 * 
	 * @param reader
	 * @param metricsfilepath
	 * @param outputfilepath
	 * @throws IOException
	 */
	public void LongestWord(BufferedReader reader, String metricsfilepath, String outputfilepath) throws IOException {

		String line = reader.readLine();
		Pattern p = Pattern.compile("[^A-Za-z0-9.\\s]");
		if (!p.matcher(line).matches()) {

			while (line != null) {

				characterCount += line.length();
				String[] wordList = line.split("\\s");
				for (int i = 0; i < wordList.length; i++) {

					if (wordList[i].length() >= longestWord.length()) {
						longestWord = wordList[i];
					}

				}
				wordCount += wordList.length;
				String[] sentenceList = line.split("\\.");
				sentenceCount += sentenceList.length;
				sent.sentenceHandler(line, outputfilepath);

				line = reader.readLine();
			}
			longestWord = ("LONGEST_WORD = " + longestWord.replace(".", ""));

			sentenceCount = sentenceCount - 1;
			double avg_chars = Math.round((characterCount / sentenceCount) * 100.0) / 100.0;
			double avg_words = Math.round((wordCount / sentenceCount) * 100.0) / 100.0;
			String avg_num_words = ("AVG_NUMBER_WORDS_PER_SENTENCE = " + avg_words);
			String avg_num_chars = ("AVG_NUM_CHARS_PER_SENTENCE =  " + avg_chars);
			System.out.println("\n"+avg_num_words);
			System.out.println(avg_num_chars);
			System.out.println(longestWord);

			res.writeToFile(avg_num_words, metricsfilepath);
			res.writeToFile("\n" + avg_num_chars, metricsfilepath);
			res.writeToFile("\n" + longestWord, metricsfilepath);
		} else {

			System.out.println("Please furnish input text containing [a-zA-Z0-9]");
		}
	}

	public void maxFrequency(BufferedReader reader, String metricsfilepath) {
		/**
		 * Using HashMap which stores words as keys and the count of repetition
		 * as values
		 */
		HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
		String maxFreqWord = null;

		try {
			String line = reader.readLine();

			Pattern p = Pattern.compile("[^A-Za-z0-9.\\s]");
			if (!p.matcher(line).matches()) {

				while (line != null) {

					/**
					 * splitting the currentLine into words
					 */

					String[] words = line.toLowerCase().split(" ");

					/**
					 * Iterating each word
					 */

					for (String word : words) {
						/**
						 * if word is already present in wordCountMap, updating
						 * its count
						 */

						if (wordFreq.containsKey(word)) {
							wordFreq.put(word, wordFreq.get(word) + 1);
						}

						/**
						 * otherwise inserting the word as key and 1 as its
						 * value
						 */
						else {
							wordFreq.put(word, 1);
						}
					}
					line = reader.readLine();
				}

				/**
				 * Finding the highest repeated word
				 */

				int count = 0;

				Set<Entry<String, Integer>> countSet = wordFreq.entrySet();

				for (Entry<String, Integer> entry : countSet) {
					if (entry.getValue() > count) {
						maxFreqWord = ("MAX_FREQ_WORD = " + entry.getKey());

						count = entry.getValue();
					}
				}
				System.out.println(maxFreqWord);
				res.writeToFile("\n" + maxFreqWord, metricsfilepath);
			} else {
				System.out.println("Please furnish input text containing [a-zA-Z0-9]");

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
