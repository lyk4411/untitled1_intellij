package headfirst.acombining.observer;

import headfirst.acombining.*;

public class GooseAdapter2 extends GooseAdapter implements QuackablePlus {
	Observable observable;

	public GooseAdapter2(Goose goose) {
		super(goose);
		observable = new Observable(this);
	}
 
	public void quack() {
		goose.honk();
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
}
