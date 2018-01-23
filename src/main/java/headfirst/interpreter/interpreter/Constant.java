package headfirst.interpreter.interpreter;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.interpreter.interpreter
 * Porject name: untitled1
 */

public class Constant extends Expression{

    private boolean value;

    public Constant(boolean value){
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj != null && obj instanceof Constant){
            return this.value == ((Constant)obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {

        return value;
    }

    @Override
    public String toString() {
        return new Boolean(value).toString();
    }

}