package headfirst.acombining.observer;

import headfirst.acombining.*;

public class DuckCall2 extends DuckCall implements QuackablePlus{
	Observable observable;

	public DuckCall2() {
		observable = new Observable(this);
	}
 
	public void quack() {
		super.quack();
		notifyObservers();
	}
 
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
}
