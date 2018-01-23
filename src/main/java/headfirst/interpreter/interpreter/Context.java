package headfirst.interpreter.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.interpreter.interpreter
 * Porject name: untitled1
 */
public class Context {

    private Map<Variable,Boolean> map = new HashMap<Variable,Boolean>();

    public void assign(Variable var , boolean value){
        map.put(var, new Boolean(value));
    }

    public boolean lookup(Variable var) throws IllegalArgumentException{
        Boolean value = map.get(var);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}