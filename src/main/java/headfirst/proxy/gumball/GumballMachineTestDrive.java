package headfirst.proxy.gumball;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachineRemote gumballMachine = null;
		int count;

		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}

		try {
			count = Integer.parseInt(args[1]);
			LocateRegistry.createRegistry(8877);

			gumballMachine = new GumballMachine(args[0], count);
			Naming.rebind("rmi://localhost:8877/gumballmachine", gumballMachine);
			System.out.println(">>>>>INFO:远程GumballMachineTestDrive对象绑定成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
