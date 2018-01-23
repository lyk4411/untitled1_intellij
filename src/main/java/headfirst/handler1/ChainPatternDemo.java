package headfirst.handler1;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.handler1
 * Porject name: untitled1
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");
        System.out.println("=======================================");
        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");
        System.out.println("=======================================");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
        System.out.println("=======================================");
        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is an error information.");
        System.out.println("=======================================");

    }
}