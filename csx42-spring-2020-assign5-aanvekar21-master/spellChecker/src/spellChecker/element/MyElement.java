package spellChecker.element;

import java.io.FileNotFoundException;
import java.io.IOException;
import spellChecker.visitor.Visitor;

public class MyElement implements Element {

	private String[] elementWord;
	/**
	 * Constructor to set the each word from the 
	 * 
	 * @param trimmedWord
	 */
	public MyElement(String trimmedWord) {

		elementWord = trimmedWord.split("\\s");

	}
	/**
	 * Accept method to accept the vistor
	 */
	@Override
	public void accept(Visitor visitor) throws FileNotFoundException, NullPointerException, IOException {
		// TODO Auto-generated method stub
		visitor.visit(this);

	}

	public String[] getWordList() {

		return elementWord;
	}
	
}
