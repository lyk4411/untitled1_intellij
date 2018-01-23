package headfirst.Bridge;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Bridge
 * Porject name: untitled1
 */

class GoogleCompany extends Company {
    public GoogleCompany(Platform platform) {
        this.mPlatform = platform;
    }

    @Override
    public void work() {
        System.out.print("Google公司的");
        this.mPlatform.program();
    }
}