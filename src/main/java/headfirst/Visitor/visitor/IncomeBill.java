package headfirst.Visitor.visitor;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Visitor.visitor
 * Porject name: untitled1
 */
public class IncomeBill implements Bill{

    private double amount;

    private String item;

    public IncomeBill(double amount, String item) {
        super();
        this.amount = amount;
        this.item = item;
    }

    public void accept(AccountBookViewer viewer) {
        viewer.view(this);
    }

    public double getAmount() {
        return amount;
    }

    public String getItem() {
        return item;
    }
}
