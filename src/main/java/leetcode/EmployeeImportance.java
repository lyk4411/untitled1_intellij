package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2018-4-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
    Employee(int id, int importance, List<Integer>  subordinates){
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
public class EmployeeImportance {
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }

    public static void main(String[] args) {
        EmployeeImportance ei = new EmployeeImportance();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        List<Employee> l2 = new ArrayList<>();
        Employee e1 = new Employee(1,5,l1);
        Employee e2 = new Employee(2,3,new ArrayList<>());
        Employee e3 = new Employee(3,3,new ArrayList<>());
        l2.add(e1);
        l2.add(e2);
        l2.add(e3);

        System.out.println(ei.getImportance(l2,1));

    }
}
