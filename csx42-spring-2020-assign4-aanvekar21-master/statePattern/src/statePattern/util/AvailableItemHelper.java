package statePattern.util;

import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

/**
 * @author Akshay Anvekar
 */
public class AvailableItemHelper implements AvailableItemHelperI {

	private static AvailableItemHelperI itemsObj = new AvailableItemHelper();
	private HashMap<String, List<String>> map = new HashMap<>();
	/**
	 * AvailableItemHelper Constructor
	 */
	private AvailableItemHelper() {

	}
	
	public static AvailableItemHelperI getInstance() {
		return itemsObj;
	}
	/**
	 * Method to Process the Available items File
	 *  and read it line by line
	 */
	public void processFile(FileProcessor fp) throws IOException {
		String input;
		try {
			input = fp.readLine();

			if (input == null) {
				System.err.println("The Available Items input file is empty. Please provide the valid Available Items input file.");
			}
			while (input != null) {

				String[] itemsKeyValue = input.split(":", 2);
				insertItems(itemsKeyValue[0].trim(), itemsKeyValue[1].trim());
				input = fp.readLine();
			}
		} catch (IOException e) {
			try {
				fp.closeFile();
			} catch (IOException er) {
				er.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	/**
	 * Method to insert the items in hashmap with key and value pair
	 * @param key
	 * @param value
	 */
	public void insertItems(String key, String value) {

		List<String> list;
		if (map.containsKey(key)) {
			list = map.get(key);
			list.add(value);
			map.put(key, list);
		} else {
			list = new ArrayList<>();
			list.add(value);
			map.put(key, list);

		}

	}
	/**
	 * Method to return the each Key of an items
	 */
	public String accessMap(String inItem) {
		for (HashMap.Entry<String, List<String>> entry : map.entrySet()) {
			for (String item : entry.getValue()) {
				if (item.equals(inItem)) {
					return entry.getKey();
				}
			}

		}
		return null;

	}

	public HashMap<String, List<String>> getMap() {
		return map;
	}

	@Override
	public String toString() {
		return "AvailableItemHelper obj =" + itemsObj;
	}

}