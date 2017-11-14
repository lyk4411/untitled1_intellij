package headfirst.composite.company;

/**
 * Created by lyk on 2017-11-14.
 * Package name: headfirst.composite.company
 * Porject name: untitled1
 */
//这两个类，其实也是公司的子类，然而，其没有存放公司类的数组，故，注定是一个叶子节点，下面不得有子节点
class HRDepartment extends Company {
    public HRDepartment(String name) {
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
