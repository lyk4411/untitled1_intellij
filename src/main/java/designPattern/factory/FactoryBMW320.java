package designPattern.factory;

/**
 * Created by lyk on 2016/7/18.
 * Package name: designPattern.factory
 * Porject name: untitled1
 */
public class FactoryBMW320 implements FactoryBMW{

    @Override
    public BMW320 createBMW() {

        return new BMW320();
    }

}