package numberPlay.subject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import numberPlay.observer.ObserverI;

import java.util.HashMap;

public class NumberProcessor implements SubjectI {
	Map<FilterI, List<ObserverI>> observers;
	private static NumberProcessor np;
	String filename;

	/**
	 * Method to Process number and perform the categorization on input type
	 * 
	 * @param number
	 * @throws IOException
	 */
	public void ProcessNumber(String number) throws IOException {

		try {
			Integer.parseInt(number);
			notifyObserver(number, IntegerFilter.getInstance());
		} catch (NumberFormatException nfe) {
			try {
				Float.parseFloat(number);
				notifyObserver(number, FloatFilter.getInstance());
			} catch (NumberFormatException e) {
				nfe.printStackTrace();
			}
		}

	}

	public static NumberProcessor getInstance()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (null == np) {
			np = new NumberProcessor();

		}
		return np;

	}

	private NumberProcessor() {
		observers = new HashMap<FilterI, List<ObserverI>>();
	}

	/**
	 * This method registers the List of observers along with their filters
	 */
	public void register(ObserverI o, FilterI f) {

		if (!observers.containsKey(f)) {
			observers.put(f, new ArrayList<ObserverI>());
		}
		observers.get(f).add(o);
	}

	/**
	 * This method is to notify observers by calling an update events which
	 * redirects to type of observers
	 * 
	 */
	public void notifyObserver(String number, FilterI f) {
		// System.out.print(observers.isEmpty());
		for (Map.Entry<FilterI, List<ObserverI>> entry : observers.entrySet()) {
			if (entry.getKey().check(number) && entry.getKey().equals(f)) {
				for (ObserverI o : entry.getValue()) {
					o.update(number, f);
				}
			}
		}
	}

}
