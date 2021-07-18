package numberPlay.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import numberPlay.observer.NumberPeaksObserver;
import numberPlay.observer.RunningAverageObserver;
import numberPlay.observer.TopKNumbersObserver;
import numberPlay.subject.FloatFilter;
import numberPlay.subject.IntegerFilter;
import numberPlay.subject.NumberProcessor;
import numberPlay.subject.ProcessingComplete;
import numberPlay.util.FileProcessor;
import numberPlay.util.InputDataMembers;
import numberPlay.util.NumberPeaksData;
import numberPlay.util.RunningAverageData;
import numberPlay.util.TopKNumbersData;

/**
 * @author John Doe TODO update the author name.
 */
public class Driver {
	public static void main(String[] args) throws Exception {

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used FIXME Refactor commandline validation using the
		 * validation design taught in class.
		 */

		final int REQUIRED_NUMBER_OF_ARGS = 6;
		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${inputNumStream}"))
				|| (args[1].equals("${runAvgWindowSize}")) || (args[2].equals("${runAvgOutFile}"))
				|| (args[3].equals("${k}")) || (args[4].equals("${topKNumOutFile}"))
				|| (args[5].equals("${numPeaksOutFile}"))) {

			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_ARGS);
			System.exit(0);
		}
		InputDataMembers obj = InputDataMembers.getInstance();

		obj.setPeakFilePath(args[5]);
		obj.setTopKOutPath(args[4]);
		obj.setkWindowSize(args[3]);
		obj.setwindowSize(args[1]);
		obj.setAvgOutputFilePath(args[2]);
		obj.setinputFilePath(args[0]);

		/**
		 * Registering the RunningAverageObserver for Integer and Processing Complete
		 */
		NumberProcessor.getInstance().register(RunningAverageObserver.getInstance(Integer.parseInt(args[1])),
				IntegerFilter.getInstance());
		NumberProcessor.getInstance().register(RunningAverageObserver.getInstance(Integer.parseInt(args[1])),
				ProcessingComplete.getInstance());

		/**
		 * Registering the TopKNumbersObserver for Integer events, Float Events and
		 * Processing Complete
		 * 
		 */
		NumberProcessor.getInstance().register(TopKNumbersObserver.getInstance(Integer.parseInt(args[1])),
				IntegerFilter.getInstance());
		NumberProcessor.getInstance().register(TopKNumbersObserver.getInstance(Integer.parseInt(args[1])),
				FloatFilter.getInstance());
		NumberProcessor.getInstance().register(TopKNumbersObserver.getInstance(Integer.parseInt(args[1])),
				ProcessingComplete.getInstance());

		/**
		 * Registering the NumberPeaksObserver for Integer events, Float Events and
		 * Processing Complete
		 */

		NumberProcessor.getInstance().register(NumberPeaksObserver.getInstance(Integer.parseInt(args[1])),
				IntegerFilter.getInstance());
		NumberProcessor.getInstance().register(NumberPeaksObserver.getInstance(Integer.parseInt(args[1])),
				FloatFilter.getInstance());
		NumberProcessor.getInstance().register(NumberPeaksObserver.getInstance(Integer.parseInt(args[1])),
				ProcessingComplete.getInstance());

		FileProcessor fp = FileProcessor.getInstance(args[0]);

		String value = fp.poll();

		while (value != null) {
			NumberProcessor np = NumberProcessor.getInstance();
			np.ProcessNumber(value);
			value = fp.poll();

		}
		RunningAverageData avg = new RunningAverageData(args[2]);
		avg.writeToFile();

		NumberPeaksData NumPeak = new NumberPeaksData(args[5]);
		NumPeak.writeToFile();

		TopKNumbersData TopK = new TopKNumbersData(args[4]);
		TopK.writeToFile();

	}
}
