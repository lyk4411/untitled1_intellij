package headfirst.Visitor;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Visitor
 * Porject name: untitled1
 */

public class Monitor  implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}