package headfirst.Memento;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Memento
 * Porject name: untitled1
 */

public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}