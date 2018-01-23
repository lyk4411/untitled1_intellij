package headfirst.Prototype;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Prototype
 * Porject name: untitled1
 */

public class Client {
    public static void main(String[] args){
        ConcretePrototype cp = new ConcretePrototype();
        for(int i=0; i< 10; i++){
            ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
            clonecp.show();
        }
    }
}