package effectiveJava.Chapter11.Item78;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item78
 * Porject name: untitled1
 */


public class School{

    public String sName = null;
    public String sId = null;

    public School(){
        this.sName = "";
        this.sId = "";
    }
    public School(String name, String id){
        this.sName = name;
        this.sId = id;
    }
}