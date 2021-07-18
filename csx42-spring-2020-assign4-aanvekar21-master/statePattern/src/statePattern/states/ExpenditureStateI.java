package statePattern.states;

import java.io.IOException;

/**
 * @author Akshay Anvekar
 */
public interface ExpenditureStateI {

	void fetchListOfMoney(int money);

	void fetchListOfItems(String items) throws IOException;

}
