package headfirst.acombining.observer;

import headfirst.acombining.*;

public class RedheadDuck2 extends RedheadDuck implements QuackablePlus{
	Observable observable;

	public RedheadDuck2() {
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
