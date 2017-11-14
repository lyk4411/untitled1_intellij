package headfirst.composite.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017-11-14.
 * Package name: headfirst.composite.company
 * Porject name: untitled1
 */
class ConcreteCompany extends Company {
    private List<Company> cList;//搞个数组用来存放下级公司

    public ConcreteCompany() {
        cList = new ArrayList<Company>();
    }

    public ConcreteCompany(String name) {
        super(name);//这里其实同，this.name=name，其中name指代从抽象公司类的Company中继承下来的类成员name
        cList = new ArrayList<Company>();
    }

    @Override
    protected void add(Company company) {
        cList.add(company);
    }

    @Override
    protected void display(int depth) {//根据级别的不同，级别越低前面的横线越多
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());//打印横线与当前公司的名词
        for (Company c : cList) {
            c.display(depth + 2);//每下一级，前面的横条就多2
        }
    }

    @Override
    protected void remove(Company company) {
        cList.remove(company);
    }
}
