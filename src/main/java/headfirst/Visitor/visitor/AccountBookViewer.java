package headfirst.Visitor.visitor;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Visitor.visitor
 * Porject name: untitled1
 */

public interface AccountBookViewer {

    //查看消费的单子
    void view(ConsumeBill bill);

    //查看收入的单子
    void view(IncomeBill bill);

}