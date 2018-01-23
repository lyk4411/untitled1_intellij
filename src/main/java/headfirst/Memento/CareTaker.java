package headfirst.Memento;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Memento
 * Porject name: untitled1
 */

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}