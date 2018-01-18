package headfirst.acombining.observer;

import headfirst.acombining.*;

public class MallardDuck2 extends MallardDuck implements QuackablePlus{
	Observable observable;
 
	public MallardDuck2() {
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
