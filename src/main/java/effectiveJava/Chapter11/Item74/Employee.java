package effectiveJava.Chapter11.Item74;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item74
 * Porject name: untitled1
 */
public class Employee implements java.io.Serializable
{
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }
}
