package javaTuning.ch02.observor;

public class Main {
	public static void main(String[] args) {
		ConcreteSubject sub=new ConcreteSubject();
		sub.attach(new ConcreteObserver());
		sub.inform();
	}
}
