package statePattern.util;


/**
 * @author Akshay Anvekar
 */
public class StateInputParameter implements StateInputParametersI {

	private static StateInputParametersI inputParamsObj = new StateInputParameter();

	private String inputFilePath;

	private String itemInputFilePath;

	private int windowSize;

	private String outputFilePath;

	private StateInputParameter() {

	}

	public static StateInputParametersI getInstance() {

		return inputParamsObj;
	}

	public void setInputFilePath(String path) {
		inputFilePath = path;
	}

	public String getInputFilePath() {
		return inputFilePath;
	}

	public void setItemInputFilePath(String path) {
		itemInputFilePath = path;
	}

	public String getItemInputFilePath() {
		return itemInputFilePath;
	}

	public void setWindowSize(String avgWindowSize) {
		windowSize = Integer.parseInt(avgWindowSize);
	}

	public int getWindowSize() {
		return windowSize;
	}

	public void setoutputFilePath(String path) {
		outputFilePath = path;
	}

	public String getoutputFilePath() {
		return outputFilePath;
	}

}
