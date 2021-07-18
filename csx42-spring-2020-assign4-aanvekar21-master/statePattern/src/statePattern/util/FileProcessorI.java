package statePattern.util;

import java.io.IOException;

/**
 * @author Akshay Anvekar
 */
public interface FileProcessorI {
	
	public String readLine() throws IOException;
	
	public void closeFile() throws IOException;

}
