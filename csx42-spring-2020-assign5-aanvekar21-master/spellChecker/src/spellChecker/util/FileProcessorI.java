package spellChecker.util;

import java.io.IOException;

public interface FileProcessorI {
	
public String readLine() throws IOException;
	
	public void closeFile() throws IOException;

}
