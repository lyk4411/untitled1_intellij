package headfirst.Memento;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Memento
 * Porject name: untitled1
 */

public class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}