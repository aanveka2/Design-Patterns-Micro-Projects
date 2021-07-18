package statePattern.util;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Akshay Anvekar
 */
public interface ResultsI {
	
	
	public void openFile(String FilePath) throws FileNotFoundException, IOException;
	public void stateResults(String dataStr) throws IOException;

	public void closeFile() throws IOException;

	




}
