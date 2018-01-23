package headfirst.Mediator;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Mediator
 * Porject name: untitled1
 */

public abstract class Fly {
    //定义飞机是进站还是出站
    public static String typeIn = "IN";
    public static String typeOUT = "OUT";

    protected String name;
    protected int id;
    //定义中介者飞机场调度中心
    protected AirportMediator airportMediator;

    public Fly(String name, int id) {
        super();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public AirportMediator getAirportMediator() {
        return airportMediator;
    }

    public void setAirportMediator(AirportMediator airportMediator) {
        this.airportMediator = airportMediator;
    }
    //定义飞机执行自己的操作
    public abstract void doSelfMethod(String type);
    //定义飞机执行与机场调度中心的操作
    public abstract void doDepMethod(String type);
    //定义飞机进站操作
    public abstract void in();
    //定义飞机出站操作
    public abstract void out();
    //定义飞机监听机场调度中心的通知
    public abstract void listerMediatorNotification(String notification);

}