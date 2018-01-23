package headfirst.Visitor;


/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Visitor
 * Porject name: untitled1
 */

public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}