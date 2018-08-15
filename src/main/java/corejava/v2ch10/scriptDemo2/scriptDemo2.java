package corejava.v2ch10.scriptDemo2;

/**
 * Created by lyk on 2018-8-15.
 * Package name: corejava.v2ch10.scriptDemo2
 * Porject name: untitled1
 */


import javax.script.*;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * 实现对脚本文件的定义
 * 运用此类需要最低JDK编译为1.6+
 * @author mr_yi
 * 下午3:57
 */
public class scriptDemo2 {

    public static void main(String[] args) throws Exception{
        /*mimeType为传输的文件类型,如 application/javascript*/
        /*获取执行JavaScript的执行引擎*/
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        /*为文件注入全局变量*/
        Bindings bindings = engine.createBindings();
        bindings.put("factor", 2);
        /*设置绑定参数的作用域*/
        engine.setBindings(bindings,ScriptContext.ENGINE_SCOPE);

        Scanner scanner = new Scanner(System.in);
        /*开始等待用户输入->体现出不需要重复运行JVM就可以实现脚本文件的更换*/
        while(scanner.hasNextInt()){
            /*只有当用户输入的是整数型时才会被执行*/
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            System.out.println("当前输入的参数为: "+first+":"+second);
            /*执行js文件代码*/
            URL url = Thread.currentThread().getContextClassLoader().getResource("");
            String path;
            System.out.println("url:" + url);
            if (url!=null){
                path = url.getPath();
                engine.eval(new FileReader(path+"/script_engine.js"));
                /*查看是否可以调用方法*/
                if (engine instanceof Invocable){
                    Invocable in = (Invocable) engine;
                    Double result = (double)in.invokeFunction("formula",first,second);
                    System.out.println("输出结果为"+result);
                }
            }

        }


    }
}