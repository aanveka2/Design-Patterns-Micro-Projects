package statePattern.states;

import java.io.IOException;
import java.util.List;

/**
 * @author Akshay Anvekar
 */
public interface ExpenditureContextI {

	List<Integer> getlistOfMoney();

	void setAverageCal(double d);

	Double getAverageCal();
	
	public ExpenditureStateI getCurrentState();
	
	public void setCurrentState(ExpenditureStateI currentStateIn);
	
	public ExpenditureStateI getBasicState();
	
	public ExpenditureStateI getLuxurious();
	
	public ExpenditureStateI getExtravagent();

	void fetchListOfMoney(int parseInt);

	public void fetchListOfItems(String items )throws IOException;
	
	public String getlistOfItems();

	
}
