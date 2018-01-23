package headfirst.Visitor;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Visitor
 * Porject name: untitled1
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
