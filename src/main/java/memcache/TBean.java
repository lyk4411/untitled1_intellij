package memcache;

import java.io.Serializable;

/**
 * Created by lyk on 2016/7/25.
 * Package name: memcache
 * Porject name: untitled1
 */

public class TBean implements Serializable {

    private static final long serialVersionUID = 1945562032261336919L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}