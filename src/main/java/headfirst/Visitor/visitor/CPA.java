package headfirst.Visitor.visitor;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Visitor.visitor
 * Porject name: untitled1
 */

public class CPA implements AccountBookViewer{

    //注会在看账本时，如果是支出，则如果支出是工资，则需要看应该交的税交了没
    public void view(ConsumeBill bill) {
        if (bill.getItem().equals("工资")) {
            System.out.println("注会查看工资是否交个人所得税。");
        }
        if (bill.getItem().equals("材料费")) {
            System.out.println("注会查看材料费。");
        }
    }
    //如果是收入，则所有的收入都要交税
    public void view(IncomeBill bill) {
        System.out.println("注会查看收入交税了没。");
    }

}