package cfets.TCPIPSocket.common;

/**
 * Created by lyk on 2016/8/16.
 * Package name: cfets.TCPIPSocket.common
 * Porject name: untitled1
 */
public class Test1

{

    public static void main(String[] args)

    {

        int a = 1;

        try

        {

            a = a / 0;

        } catch (Exception e)

        {
            System.out.println(-0.0 == 0.0);
            System.out.println("catch");
            System.exit(0);//若用上这句，finally中的语句不会执行。直接返回，退出程序。

            return;//当return时，finally中的语句会执行。


        } finally //当没有System.exit(0);时，无论是否发生异常它都会执行。

        {

            System.out.println("finally");

        }

    }

}