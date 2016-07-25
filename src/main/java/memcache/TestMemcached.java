package memcache;

/**
 * Created by lyk on 2016/7/25.
 * Package name: memcache
 * Porject name: untitled1
 */

import junit.framework.TestCase;
import org.junit.Test;

public class TestMemcached extends TestCase {

    private static MemCachedManager cache;

    @Test
    public void testCache() {

        TBean tb = new TBean();
        tb.setName("E网打进");
        cache.add("bean", tb);

        TBean tb1 = (TBean) cache.get("bean");
        System.out.println("name=" + tb1.getName());
        tb1.setName("E网打进_修改的");

        tb1 = (TBean) cache.get("bean");
        System.out.println("name=" + tb1.getName());
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        cache = MemCachedManager.getInstance();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        cache = null;
    }

}