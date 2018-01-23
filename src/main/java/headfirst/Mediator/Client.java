package headfirst.Mediator;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Mediator
 * Porject name: untitled1
 */

public class Client {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AirportMediator airportMediator = new AirportMediator();

        ConcreteFly f1 = new ConcreteFly("0001", 1);
        ConcreteFly f2 = new ConcreteFly("0002", 2);
        ConcreteFly f3 = new ConcreteFly("0003", 3);

        f1.setAirportMediator(airportMediator);
        f2.setAirportMediator(airportMediator);
        f3.setAirportMediator(airportMediator);

        f1.in();
        System.out.println("---------------------------------------");
        f2.in();
        System.out.println("---------------------------------------");
        f3.in();
        System.out.println("---------------------------------------");
        f1.out();
        System.out.println("---------------------------------------");
        f2.out();
        System.out.println("---------------------------------------");
        f3.out();
        System.out.println("---------------------------------------");
    }
}