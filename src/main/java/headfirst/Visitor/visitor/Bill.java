package headfirst.Visitor.visitor;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Visitor.visitor
 * Porject name: untitled1
 */
public interface Bill {
    void accept(AccountBookViewer viewer);
}
