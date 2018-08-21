package corejava.v2ch11.warehouse1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

/**
 * A client that invokes a remote method.
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseClient
{
   public static void main(String[] args) throws NamingException, RemoteException
   {
      Context namingContext = new InitialContext();
      
      System.out.print("RMI registry bindings: ");
      Enumeration<NameClassPair> e = namingContext.list("rmi://192.168.150.40:8899/");
      while (e.hasMoreElements())
         System.out.println(e.nextElement().getName());
      
      String url = "rmi://192.168.150.40:8899/central_warehouse";
      Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);      
      
      String descr = "Blackwell Toaster";
      double price = centralWarehouse.getPrice(descr);
      System.out.println(descr + ": " + price);
   }
}
