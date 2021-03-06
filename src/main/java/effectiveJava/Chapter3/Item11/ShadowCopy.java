package effectiveJava.Chapter3.Item11;

/**
 * Created by lyk on 2019-1-18.
 * Package name: effectiveJava.Chapter3.Item11
 * Porject name: untitled1
 */

public class ShadowCopy {

    public static void main(String[] args) {
        Professor p1 = new Professor();
        p1.setName("Professor Zhang");
        p1.setAge(30);

        Student s1 = new Student();
        s1.setName("xiao ming");
        s1.setAge(18);
        s1.setProfessor(p1);

        System.out.println(s1);

        try {
            Student s2 = (Student) s1.clone();
            Professor p2 = s2.getProfessor();
            p2.setName("Professor Li");
            p2.setAge(45);
            s2.setProfessor(p2);
            System.out.println("复制后的：s1 = " + s1);
            System.out.println("复制后的：s2 = " + s2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}