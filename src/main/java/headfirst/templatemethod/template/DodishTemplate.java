package headfirst.templatemethod.template;

/**
 * Created by lyk on 2017/9/28.
 * Package name: headfirst.templatemethod.template
 * Porject name: untitled1
 */
public abstract class DodishTemplate {

    /**
     * 具体的整个过程
     */
    protected void dodish(){
        this.preparation();
        this.doing();
        this.carriedDishes();
    }
    /**
     * 备料
     */
    public abstract void preparation();
    /**
     * 做菜
     */
    public abstract void doing();
    /**
     * 上菜
     */
    public abstract void carriedDishes ();
}
