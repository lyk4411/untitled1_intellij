package cfets.TCPIPSocket.common;

/**
 * Created by lyk on 2016/9/17.
 * Package name: cfets.TCPIPSocket.common
 * Porject name: untitled1
 */
public class breakB {

    public static void main(String[] args){
        lableB:
        for(int i=0;i<3;i++){
            lableA:
            for(int j=0;j<3;j++){
                System.out.println(j);
                if(j==1){
                    break lableB;
                }
            }
        }
        System.out.println("over!");
    }
}
