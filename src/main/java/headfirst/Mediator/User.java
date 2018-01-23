package headfirst.Mediator;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Mediator
 * Porject name: untitled1
 */

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}