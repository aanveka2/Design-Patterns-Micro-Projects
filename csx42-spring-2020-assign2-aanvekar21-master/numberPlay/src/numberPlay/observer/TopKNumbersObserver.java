package numberPlay.observer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import numberPlay.subject.FilterI;
import numberPlay.util.InputDataMembers;
import numberPlay.util.TopKNumbersData;

public class TopKNumbersObserver implements ObserverI {

    private static TopKNumbersObserver TopObserver;
    private static TopKNumbersData TopK;
    InputDataMembers obj;

    public TopKNumbersObserver() throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

        obj = InputDataMembers.getInstance();
        TopK = TopKNumbersData.getInstance(InputDataMembers.getInstance().getTopKOutPath());

    }

    /**
     * 
     * Method for the instance of Top K numbers
     * 
     * @param size
     * @return
     * @throws InvalidPathException
     * @throws SecurityException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static TopKNumbersObserver getInstance(final int size)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        if (null == TopObserver) {
            TopObserver = new TopKNumbersObserver(size);

        }
        return TopObserver;

    }

    public static List<Double> list;

    public int sz;

    public TopKNumbersObserver(final int size) {
        list = new ArrayList<Double>();
        sz = size;
    }

    /**
     * Method to update the Top K numbers observers
     */
    @Override
    public void update(String number, FilterI f) {

        // System.out.println(number);
        // ArrayList<String> list = new ArrayList<String>();

        if (list.size() >= sz) {
            list.remove(sz - 1);
            list.add(Double.parseDouble(number));
        } else {
            list.add(Double.parseDouble(number));
        }
        Collections.sort(list, Collections.reverseOrder());
        // TopK.store(list);
        System.out.println(list);

    }

}
