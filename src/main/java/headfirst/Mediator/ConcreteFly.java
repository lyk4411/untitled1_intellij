package headfirst.Mediator;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Mediator
 * Porject name: untitled1
 */

public class ConcreteFly extends Fly {

    public ConcreteFly(String name, int id) {
        super(name, id);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void doSelfMethod(String type) {
        // TODO Auto-generated method stub
        System.out.println("ConcreteFly---doSelfMethod");
        System.out.println("Fly:"+ super.name +"---"+type.toLowerCase());
    }

    @Override
    public void doDepMethod(String type) {
        // TODO Auto-generated method stub
        System.out.println("ConcreteFly---doDepMethod");
        System.out.println("Fly:"+ super.name +"-------doDepMethod()");
        super.airportMediator.doManager(this,type);

    }

    @Override
    public void in() {
        // TODO Auto-generated method stub
        System.out.println("ConcreteFly---in()---Fly:"+ super.name +"-------in");
        doSelfMethod(typeIn);
        doDepMethod(typeIn);
    }

    @Override
    public void out() {
        // TODO Auto-generated method stub
        System.out.println("ConcreteFly---out()---Fly:"+ super.name +"-------out");
        doSelfMethod(typeOUT);
        doDepMethod(typeOUT);
    }


    @Override
    public void listerMediatorNotification(String notification) {
        // TODO Auto-generated method stub
        System.out.println("ConcreteFly----listerMediatorNotification");
        System.out.println("Fly:"+super.name + "--lister Mediator Notification:"+notification);
    }

}