package headfirst.composite.company;

/**
 * Created by lyk on 2017-11-14.
 * Package name: headfirst.composite.company
 * Porject name: untitled1
 */
//根本与HRDepartment是一模一样的，不解释。
class FinanceDepartment extends Company {
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    protected void add(Company company) {
    }

    @Override
    protected void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
    }

    @Override
    protected void remove(Company company) {
    }
}
