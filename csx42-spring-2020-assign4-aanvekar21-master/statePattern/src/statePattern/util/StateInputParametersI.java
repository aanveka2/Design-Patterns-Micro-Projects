package statePattern.util;

/**
 * @author Akshay Anvekar
 */
public interface StateInputParametersI {

	
	
	
	public void setInputFilePath(String path);
	
	public String getInputFilePath();
	
	public void setItemInputFilePath(String path);
	
	public String getItemInputFilePath();
	
	public void setWindowSize(String avgWindowSize);
	
	public int getWindowSize();
	
	public void setoutputFilePath(String path);
	
	public String getoutputFilePath();
}
