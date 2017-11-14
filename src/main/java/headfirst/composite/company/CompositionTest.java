package headfirst.composite.company;

/**
 * Created by lyk on 2017-11-14.
 * Package name: headfirst.composite.company
 * Porject name: untitled1
 */


//具体实现
public class CompositionTest {
    public static void main(String[] args) {
        //先搞一个 北京总部
        Company Beijing = new ConcreteCompany();
        Beijing.setName("北京公司总部");
        Beijing.add(new HRDepartment("总公司人力资源部"));
        Beijing.add(new FinanceDepartment("总公司财务部"));
        //再搞一个 上海分公司
        Company Shanghai = new ConcreteCompany("上海分公司");
        Shanghai.add(new FinanceDepartment("上海办事处财务部"));
        Shanghai.add(new HRDepartment("上海办事处人力资源部"));

        Beijing.add(Shanghai);//将上海分公司置于北京总部之下

        //下逻辑同，不解释了
        Company NanJing = new ConcreteCompany("南京办事处");
        NanJing.add(new FinanceDepartment("南京办事处财务部"));
        NanJing.add(new HRDepartment("南京办事处人力资源部"));
        Shanghai.add(NanJing);
        Beijing.display(0);
    }
}