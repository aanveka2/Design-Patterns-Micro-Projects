package spellChecker.visitor;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import spellChecker.element.MyElement;
import spellChecker.results.Results;
import spellChecker.util.FileProcessor;

public class SpellCheckAnalyzer implements Visitor {

	Hashtable<String, String> dictionary;
	boolean suggestWord;
	boolean correct = true;
	private Results spellCheckResults;
	public String acceptableWordsFilename;

	private List<String> acceptableList = new ArrayList<>();
	private List<String> finalWordList = new ArrayList<>();
	char inputChar;
	char acceptableChar;
	/**
	 * Constructor to set the input filepath of acceptable words
	 * and spellCheckResults
	 * @param inAcceptableWordsFilename
	 * @param inSpellCheckResults
	 * @throws IOException
	 */
	public SpellCheckAnalyzer(String inAcceptableWordsFilename, Results inSpellCheckResults) throws IOException {
		spellCheckResults = inSpellCheckResults;
		acceptableWordsFilename = inAcceptableWordsFilename;
		FileProcessor fp = new FileProcessor(acceptableWordsFilename);

		String acceptableWord = "";
		while ((acceptableWord = fp.readLine()) != null) {

			try {

				acceptableList.add(acceptableWord);

			} catch (NullPointerException p) {

			}

		}
	}
	/**
	 * This method performs the spell check 
	 * i.e it compares the input words with 
	 * the acceptable words
	 * 
	 */
	@Override
	public void visit(MyElement myElement) throws NullPointerException, IOException {

		String wordList[] = myElement.getWordList();

		for (String word : wordList) {
			
			
			for (String acceptable : acceptableList) {
				
				if (word.toLowerCase().length() == acceptable.toLowerCase().length()&& word.length()>2) {
					int count = 0;
					for (int i = 0; i < word.length(); i++) {

						if (word.charAt(i) == acceptable.charAt(i)) {

						} else {
							count++;

						}
					}
					if (count == 1) {

						finalWordList.add(acceptable);
					}

				}

			}
			if (!finalWordList.isEmpty()) {
				spellCheckResults.storeResults(word + "::" + finalWordList.toString());
				finalWordList.clear();

			}
		}

	}
	
	public String toString() {
		return "SpellCheckResults  obj =" + spellCheckResults;
	}
}
