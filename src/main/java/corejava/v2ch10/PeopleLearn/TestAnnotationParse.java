package corejava.v2ch10.PeopleLearn;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PeopleLearn
 * Porject name: untitled1
 */



import org.junit.Test;

public class TestAnnotationParse {

    @Test
    public void test() {
        AnnotionParse parse = new AnnotionParse();
        parse.parse(Student.class);
    }
}
