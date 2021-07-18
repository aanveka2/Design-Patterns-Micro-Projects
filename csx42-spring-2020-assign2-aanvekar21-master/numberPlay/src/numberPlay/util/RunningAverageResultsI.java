package numberPlay.util;

/**
* RunningAverageResultsI defines an interface to be implemented by
* classes that intend to stroe the running average for each number
* processed in a stream of numbers.
*/
public interface RunningAverageResultsI {
	void store(double d);
}
