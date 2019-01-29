package effectiveJava.Chapter11.Item78;

import java.io.*;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item78
 * Porject name: untitled1
 */
public class Student implements Serializable {
    private final static long serialVersionUID = 1L;

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
        if(this.age < 0)
            try {
                throw new InvalidObjectException("invalid data: age < 0");
            } catch (InvalidObjectException e) {
                e.printStackTrace();
            }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        //invoke default serialization method
        out.defaultWriteObject();

        if(school == null)
            school = new School();
        out.writeObject(school.sName);
        out.writeObject(school.sId);
    }

//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        //invoke default serialization method
//        in.defaultReadObject();
//        if(this.age < 0)
//            throw new InvalidObjectException("invalid data: age < 0");
//        String name = (String) in.readObject();
//        String id = (String) in.readObject();
//        school = new School(name, id);
//    }
    private class SerializationProxy4Student implements Serializable {

        private final static long serialVersionUID = 11L; // Any number will do

        private String firstName = null;
        private String lastName = null;
        private Integer age = null;
        private String schoolName = null;
        private String schoolId = null;

        SerializationProxy4Student (Student s) {
            this.firstName = s.firstName;
            this.lastName = s.lastName;
            this. age = s.age;
            this.schoolName = s.school.sName;
            this.schoolId = s.school.sId;
        }
    }
    private void readObject( ObjectInputStream stream) throws InvalidObjectException{
        throw new InvalidObjectException("Proxy Pattern Required");
    }

    private Object writeReplace ( ) {
        return new SerializationProxy4Student(this); // this：Student instance
    }
}
