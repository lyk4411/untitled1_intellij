package headfirst.handler1;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.handler1
 * Porject name: untitled1
 */

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}