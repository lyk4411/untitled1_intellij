package corejava.v1ch05;

/**
 * Created by lyk on 2018-8-23.
 * Package name: corejava.v1ch05
 * Porject name: untitled1
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class Base
{
    //子类Derive将重写此方法，将返回类型设置为InputStream的子类
    public InputStream getInput()
    {
        return System.in;
    }
}
public  class Derive extends Base
{

    @Override
    public ByteArrayInputStream getInput()
    {

        return new ByteArrayInputStream(new byte[1024]);
    }
    public static void main(String[] args)
    {
        Derive d=new Derive();
        System.out.println(d.getInput().getClass());
    }
}
/*程序输出：
class java.io.ByteArrayInputStream
*/