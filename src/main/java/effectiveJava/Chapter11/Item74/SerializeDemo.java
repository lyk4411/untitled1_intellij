package effectiveJava.Chapter11.Item74;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item74
 * Porject name: untitled1
 */


public class SerializeDemo
{
    public static void main(String [] args)
    {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("F:\\temp\\employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in F:\\temp\\employee.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}