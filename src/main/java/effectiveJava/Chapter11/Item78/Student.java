package effectiveJava.Chapter11.Item78;

import java.io.Serializable;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item78
 * Porject name: untitled1
 */
public class Student implements Serializable {

    private String firstName = null;
    private String lastName = null;
    private Integer age = null;
    // unserializable field
    private transient School school= null;

    public Student () { }

    public Student (String fname, String lname, Integer age, School school) {
        this.firstName = fname;
        this.lastName = lname;
        this.age = age;
        this.school = school;
    }
}
