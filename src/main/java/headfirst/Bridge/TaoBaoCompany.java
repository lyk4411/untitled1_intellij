package headfirst.Bridge;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Bridge
 * Porject name: untitled1
 */

class TaoBaoCompany extends Company {
    public TaoBaoCompany(Platform platform) {
        this.mPlatform = platform;
    }

    @Override
    public void work() {
        System.out.print("TaoBao公司的");
        this.mPlatform.program();
    }
}