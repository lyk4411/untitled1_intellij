package headfirst.Bridge;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Bridge
 * Porject name: untitled1
 */


public class Main {
    public static void main(String[] args) {
        Monkey monkeyS = new ServerMonkey();
        Monkey monkeyM = new MobileMonkey();
        Platform platform = new WindowsPlatform(monkeyS);
        platform.program();
        System.out.println("000000000000000000000000000000000000");
        Company company = new GoogleCompany(platform);
        company.work();
        System.out.println("1111111111111111111111111111111111");

        platform = new WindowsPlatform(monkeyM);
        platform.program();
        System.out.println("22222222222222222222222222222222");

        company = new TaoBaoCompany(platform);
        company.work();
        System.out.println("33333333333333333333333333333333333");

        platform = new LinuxPlatform(monkeyS);
        platform.program();
        System.out.println("444444444444444444444444444444444444");

        company = new GoogleCompany(platform);
        company.work();
        System.out.println("5555555555555555555555555555555555555");

        platform = new LinuxPlatform(monkeyM);
        platform.program();
        System.out.println("66666666666666666666666666666666666");

        company = new TaoBaoCompany(platform);
        company.work();
        System.out.println("777777777777777777777777777777777777777");

    }
}
