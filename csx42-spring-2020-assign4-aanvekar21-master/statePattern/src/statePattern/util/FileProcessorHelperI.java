package statePattern.util;

import java.io.IOException;

/**
 * @author Akshay Anvekar
 */
public interface FileProcessorHelperI {

	void processFile(FileProcessor inputFile_fp, int windowsize) throws IOException;

}
