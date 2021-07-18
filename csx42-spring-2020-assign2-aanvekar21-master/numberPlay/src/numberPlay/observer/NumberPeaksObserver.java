package numberPlay.observer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import numberPlay.subject.FilterI;
import numberPlay.util.InputDataMembers;
import numberPlay.util.NumberPeaksData;

public class NumberPeaksObserver implements ObserverI {
    InputDataMembers obj;
    private NumberPeaksData NumData;

    public NumberPeaksObserver() throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

        obj = InputDataMembers.getInstance();
        NumData = NumberPeaksData.getInstance(InputDataMembers.getInstance().getPeakFilePath());

    }

    private static NumberPeaksObserver PeakObserver;
    public double temp = 0;

    /**
     * Method to Create an Instance of a class
     * 
     * @param size
     * @return
     * @throws InvalidPathException
     * @throws SecurityException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static NumberPeaksObserver getInstance(final int size)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        if (null == PeakObserver) {
            PeakObserver = new NumberPeaksObserver();

        }
        return PeakObserver;

    }

    /**
     * The method is used to update the data to the observers
     */
    @Override
    public void update(final String number, final FilterI f) {

        if (temp > Float.parseFloat(number)) {

            // System.out.println(temp);
            NumData.store(temp);

        }
        temp = Float.parseFloat(number);

    }
}
