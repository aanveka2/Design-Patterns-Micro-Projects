package numberPlay.subject;

import numberPlay.observer.ObserverI;
import numberPlay.subject.FilterI;
public interface SubjectI {

	
	
	public void register(ObserverI o, FilterI f);

	public void notifyObserver(String number, FilterI f);
}