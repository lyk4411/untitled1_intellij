package headfirst.interpreter;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.interpreter
 * Porject name: untitled1
 */

public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}