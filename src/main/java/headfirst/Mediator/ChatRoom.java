package headfirst.Mediator;

import java.util.Date;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Mediator
 * Porject name: untitled1
 */

public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}