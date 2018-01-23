package headfirst.Mediator;

import java.util.ArrayList;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Mediator
 * Porject name: untitled1
 */

public class AirportMediator {
    //本机场所有的飞机
    private ArrayList<Fly> array = new ArrayList<Fly>();

    public void add(ConcreteFly fly){
        array.add(fly);
    }

    public void remove(ConcreteFly fly){
        array.remove(fly);
    }
    //执行调度命令
    public void doManager(Fly fly,String type){
        System.out.println("AirportMediator---doManager");

        if(type.equals(Fly.typeIn)){
            if(!array.contains(fly)){
                array.add(fly);
            }
        }else if (type.equals(Fly.typeOUT)) {
            if(array.contains(fly)){
                array.remove(fly);
            }
        }

        for(int i=0;i<array.size();i++){
            ((ConcreteFly)array.get(i)).listerMediatorNotification("Mediator Notifycation:Fly:"+fly.getName()
                    +"---"+type.toLowerCase()+"---各个飞机按命令调度");
        }

    }

}