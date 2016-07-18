package designPattern.factory;

/**
 * Created by lyk on 2016/7/18.
 * Package name: designPattern.factory
 * Porject name: untitled1
 */

public class Factory {
    public BMW createBMW(int type) {
        switch (type) {
            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
            default:
                break;
        }
        return null;
    }
}


