package headfirst.acombining.observer;

import headfirst.acombining.*;

public class DecoyDuck2 extends DecoyDuck implements QuackablePlus{
	Observable observable;

	public DecoyDuck2() {
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
