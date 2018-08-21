package corejava.v2ch11.warehouse1;

import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * This server program instantiates a remote warehouse object, registers it with the naming
 * service, and waits for clients to invoke methods.
 * @version 1.12 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseServer
{
   public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException, MalformedURLException {
      System.out.println("Constructing server implementation...");
      WarehouseImpl centralWarehouse = new WarehouseImpl();

      System.out.println("Binding server implementation to registry...");
//      Context namingContext = new InitialContext();
//      namingContext.bind("rmi://192.168.150.40:1099/central_warehouse", centralWarehouse);
      LocateRegistry.createRegistry(8899);

      Naming.bind("rmi://192.168.150.40:8899/central_warehouse",centralWarehouse);
      System.out.println("Waiting for invocations from clients...");
   }
}
