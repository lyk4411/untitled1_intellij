package headfirst.state.gumball;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);
		System.out.println("111111111111111111111111111111111111111111111111");

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
		System.out.println("22222222222222222222222222222222222222222222222");

		gumballMachine.insertQuarter();
		gumballMachine.ejectQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
		System.out.println("333333333333333333333333333333333333333333333333");

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.ejectQuarter();

		System.out.println(gumballMachine);
		System.out.println("4444444444444444444444444444444444444444444444444");

		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
		System.out.println("5555555555555555555555555555555555555555555555555");

	}
}
