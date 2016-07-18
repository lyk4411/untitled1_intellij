package designPattern.factory;

/**
 * Created by lyk on 2016/7/18.
 * Package name: designPattern.factory
 * Porject name: untitled1
 */
public class FactoryBMW523 implements FactoryBMW {
    @Override
    public BMW523 createBMW() {

        return new BMW523();
    }
}