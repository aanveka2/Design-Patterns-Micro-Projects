package statePattern.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Akshay Anvekar
 */
public interface AvailableItemHelperI {

	void processFile(FileProcessor availableItem_fp) throws IOException;

//	void setAccessMap(String item);
//
//	public String getAccessMap();

	String accessMap(String getlistOfItems);
	public HashMap<String, List<String>> getMap();

	

}
