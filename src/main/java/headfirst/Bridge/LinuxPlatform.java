package headfirst.Bridge;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Bridge
 * Porject name: untitled1
 */


class LinuxPlatform extends Platform {
    public LinuxPlatform(Monkey monkey) {
        this.mMonkey = monkey;
    }

    @Override
    public void program() {
        mMonkey.type();
        System.out.println("使用Linux平台！");
    }
}