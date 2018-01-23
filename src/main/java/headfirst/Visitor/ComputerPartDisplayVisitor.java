package headfirst.Visitor;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Visitor
 * Porject name: untitled1
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor  {
    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
