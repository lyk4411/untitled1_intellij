package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-12-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email: emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll(".", "");
            seen.add(local + rest);
        }

        return seen.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses uea = new UniqueEmailAddresses();
        System.out.println(uea.numUniqueEmails(
                new String[]{"test.email+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com",
                        "test.e.m.ail+david@lee.tcode.com"}
        ));

    }
}
