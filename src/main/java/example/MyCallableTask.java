package example;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by lyk on 2019-3-19.
 * Package name: example
 * Porject name: untitled1
 */

public class MyCallableTask implements Callable<Integer>
{
    @Override
    public Integer call()
            throws Exception
    {
        System.out.println("callable do somothing");
        Thread.sleep(500);
        return new Random().nextInt(100);
    }
}