package numberPlay.observer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.LinkedList;
import numberPlay.subject.FilterI;
import numberPlay.util.RunningAverageData;

public class RunningAverageObserver implements ObserverI {
	double sum;
	int size;
	static LinkedList<Integer> list;
	int windowsize = 3;
	String AvgFilePath;
	private RunningAverageData avg;

	private static RunningAverageObserver RunObserver;

	/**
	 * Constructor to declare the Linked List and Window size of the Calcuation
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SecurityException
	 * @throws InvalidPathException
	 */
	public RunningAverageObserver(int size)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		this.list = new LinkedList<>();
		this.size = size;
		this.avg = RunningAverageData.getInstance("");
	}

	/**
	 * Method for Running Average Observer instance
	 * 
	 * @param size
	 * @return
	 * @throws InvalidPathException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static RunningAverageObserver getInstance(int size)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (null == RunObserver) {
			RunObserver = new RunningAverageObserver(size);

		}
		return RunObserver;

	}

	/**
	 * Method to update the Running Average Observers
	 */
	@Override
	public void update(String number, FilterI f) {

		int val = Integer.parseInt(number);
		sum += val;
		list.offer(val);

		if (list.size() <= size) {
			avg.store((double) sum / (double) list.size());
			return;
		}

		sum -= list.poll();

		avg.store((double) sum / (double) size);

	}

}
