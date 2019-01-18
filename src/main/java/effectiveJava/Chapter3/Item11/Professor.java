package effectiveJava.Chapter3.Item11;

/**
 * Created by lyk on 2019-1-18.
 * Package name: effectiveJava.Chapter3.Item11
 * Porject name: untitled1
 */
public class Professor implements Cloneable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Professor [name=" + name + ", age=" + age + "]";
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}