package spellChecker.visitor;

import java.io.FileNotFoundException;
import java.io.IOException;

import spellChecker.element.MyElement;

public interface Visitor {

	void visit(MyElement myElement) throws FileNotFoundException,NullPointerException, IOException;

}
