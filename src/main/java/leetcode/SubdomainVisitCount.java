package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2018-4-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }

    public static void main(String[] args) {
        SubdomainVisitCount svc = new SubdomainVisitCount();
        String[] cpdomains1 = new String[]{
                "9001 discuss.leetcode.com"
        };
        String[] cpdomains2 = new String[]{
                "900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"
        };
        svc.subdomainVisits(cpdomains1).stream().
                forEach(n -> System.out.print(n + "; "));
        System.out.println();
        svc.subdomainVisits(cpdomains2).stream().
                forEach(n -> System.out.print(n + "; "));
    }
}
