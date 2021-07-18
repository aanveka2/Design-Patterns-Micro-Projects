package spellChecker.results;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Results {

	public void storeResults(String data);
	
	public void writeToFile() throws FileNotFoundException,NullPointerException, IOException;

}
