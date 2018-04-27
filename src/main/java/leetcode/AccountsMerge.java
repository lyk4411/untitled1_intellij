package leetcode;

import java.util.*;

/**
 * Created by lyk on 2018-4-27.
 * Package name: leetcode
 * Porject name: untitled1
 */

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        AccountsMerge am = new AccountsMerge();
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();
        List<String> l4 = new ArrayList<>();
        l1.add(0, "john00@mail.com");
        l1.add(0, "johnsmith@mail.com");
        l1.add(0, "John");
        l2.add(0, "johnnybravo@mail.com");
        l2.add(0, "John");
        l3.add(0, "john_newyork@mail.com");
        l3.add(0, "johnsmith@mail.com");
        l3.add(0, "John");
        l4.add(0, "mary@mail.com");
        l4.add(0, "Mary");
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(l1);
        accounts.add(l2);
        accounts.add(l3);
        accounts.add(l4);
        List<List<String>> result = am.accountsMerge(accounts);
        for (List<String> j : result){
            for (String k: j){
                System.out.print(k + ":");
            }
            System.out.println();
        }
    }
}
