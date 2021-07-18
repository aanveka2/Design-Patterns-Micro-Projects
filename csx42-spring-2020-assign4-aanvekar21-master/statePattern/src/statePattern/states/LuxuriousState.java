package statePattern.states;

import java.io.IOException;
import java.util.List;

import statePattern.util.AvailableItemHelper;
import statePattern.util.Results;
import statePattern.util.StateInputParameter;

/**
 * @author Akshay Anvekar
 */
public class LuxuriousState implements ExpenditureStateI {

	private ExpenditureContextI expenditureContextObj;
	/**
	 * LuxuriousState Constructor
	 * @param contextObj
	 */
	public LuxuriousState(ExpenditureContextI contextObj) {

		this.expenditureContextObj = contextObj;

	}
	/**
	 * Method to fetch the Money from the list
	 */
	public void fetchListOfMoney(int money) {

		List<Integer> listOfMoney = expenditureContextObj.getlistOfMoney();
		if(money <= 0){
			System.err.println(" Incorrect value of Money. The expected value of Money is greater than or equal to 0");	
			System.exit(0);
		}
		listOfMoney.add(money);
		runningWindowAvg(listOfMoney, StateInputParameter.getInstance().getWindowSize());
		stateChange();
	}
	/**
	 * Method to fetch the Items from the list
	 */
	public void fetchListOfItems(String item) throws IOException {

		String itemCategory = AvailableItemHelper.getInstance().accessMap(item);

		if ((itemCategory.equals("basic") || itemCategory.equals("moderatelyExpensive")) && !itemCategory.isEmpty()) {
			System.out.println("LUXURIOUS::" + item + "--" + "YES");
			Results.getInstance().stateResults("LUXURIOUS::" + item + "--" + "YES");
		} else if (!itemCategory.isEmpty()) {
			Results.getInstance().stateResults("LUXURIOUS::" + item + "--" + "NO");
			System.out.println("LUXURIOUS::" + item + "--" + "NO");
		}

	}
	/**
	 * Method to perform Average window Calculation
	 * @param listOfMoney
	 * @param avgWindownSize
	 */
	private void runningWindowAvg(List<Integer> listOfMoney, int avgWindownSize) {
		int total = 0;
		if (listOfMoney.size() == avgWindownSize) {
			for (Integer entry : listOfMoney) {
				total = total + entry;
			}
			Double runWinAvg = ((double) total / avgWindownSize);
			expenditureContextObj.setAverageCal(runWinAvg);
			listOfMoney.remove(0);
		} else {
			for (Integer entry : listOfMoney) {
				total = total + entry;
			}
			Double runWinAvg = ((double) total / listOfMoney.size());
			expenditureContextObj.setAverageCal(runWinAvg);
		}

	}
	/**
	 * Method to check the state change
	 */
	private void stateChange() {

		Double avg = expenditureContextObj.getAverageCal();

		if (avg >= (double) 10000 && avg < (double) 50000) {
			expenditureContextObj.setCurrentState(expenditureContextObj.getLuxurious());

		} else if (avg >= (double) 50000) {

			expenditureContextObj.setCurrentState(expenditureContextObj.getExtravagent());
		} else {
			expenditureContextObj.setCurrentState(expenditureContextObj.getBasicState());
		}

	}
	public String toString() {
		return "Context state  obj =" + expenditureContextObj;
	}

}
