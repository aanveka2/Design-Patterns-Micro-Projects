package statePattern.states;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Akshay Anvekar
 */
public class ExpenditureContext implements ExpenditureStateI, ExpenditureContextI {

	private ExpenditureStateI currentState;

	private ExpenditureStateI basicState;
	private ExpenditureStateI luxurious;
	private ExpenditureStateI extravagent;

	private List<Integer> listOfMoney;
	private String listOfItems;

	private Double averageCal;

	/**
	 * ExpenditureContext constructor
	 */
	public ExpenditureContext() {

		basicState = new BasicState(this);
		luxurious = new LuxuriousState(this);
		extravagent = new ExtravagentState(this);

		currentState = basicState;

		listOfMoney = new ArrayList<Integer>();

	}

	/**
	 * Method to get the Current state
	 */
	public ExpenditureStateI getCurrentState() {
		return currentState;
	}

	/**
	 * Method to set the Current state
	 */
	public void setCurrentState(ExpenditureStateI currentStateIn) {
		this.currentState = currentStateIn;
	}

	/**
	 * Method to get the basicState
	 */
	public ExpenditureStateI getBasicState() {
		return basicState;
	}

	/**
	 * Method to get the luxurious state
	 */
	public ExpenditureStateI getLuxurious() {
		return luxurious;
	}

	/**
	 * Method to get the extravagent state
	 */
	public ExpenditureStateI getExtravagent() {
		return extravagent;
	}

	/**
	 * Method to get the listOfMoney
	 */
	public List<Integer> getlistOfMoney() {
		return listOfMoney;
	}

	/**
	 * Method to fetch the ListOfMoney
	 */
	public void fetchListOfMoney(int money) {

		currentState.fetchListOfMoney(money);
	}

	/**
	 * Method to set the AverageCal
	 */
	@Override
	public void setAverageCal(double d) {
		(this).averageCal = d;
	}

	/**
	 * Method to get the averageCal
	 */
	@Override
	public Double getAverageCal() {
		return averageCal;
	}

	/**
	 * Method to get the listOfItems
	 */
	public String getlistOfItems() {
		return listOfItems;
	}

	/**
	 * Method to fetch ListOfItems
	 */
	public void fetchListOfItems(String items) throws IOException {

		currentState.fetchListOfItems(items);

	}
	public String toString() {
		return "Context state  obj =" + currentState;
	}

}
