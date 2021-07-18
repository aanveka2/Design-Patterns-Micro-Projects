package wordPlay.util;

import java.io.FileWriter;

/**
 * @author Akshay Anvekar
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	public FileWriter fileWriter = null;
	public String metricfile = null;
	public FileWriter fw = null;

	/**
	 * 
	 * This method write the output to the file
	 * 
	 * @param s
	 * @param outputfile
	 */
	public void writeToFile(String s, String outputfile) {
		try {

			fw = new FileWriter(outputfile, true);
			// System.out.println(s);
			fw.write(s);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

		
}