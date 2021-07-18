package spellChecker.element;

import java.io.FileNotFoundException;
import java.io.IOException;

import spellChecker.util.FileProcessor;
import spellChecker.visitor.Visitor;

public interface Element {

	void accept(Visitor visitor) throws FileNotFoundException,NullPointerException, IOException;



}
