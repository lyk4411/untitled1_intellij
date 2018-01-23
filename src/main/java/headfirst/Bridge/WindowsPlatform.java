package headfirst.Bridge;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Bridge
 * Porject name: untitled1
 */

class WindowsPlatform extends Platform {
    public WindowsPlatform(Monkey monkey) {
        this.mMonkey = monkey;
    }

    @Override
    public void program() {
        mMonkey.type();
        System.out.println("使用Windows平台！");
    }
}