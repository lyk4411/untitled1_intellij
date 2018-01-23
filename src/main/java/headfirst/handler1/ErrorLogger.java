package headfirst.handler1;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.handler1
 * Porject name: untitled1
 */

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}