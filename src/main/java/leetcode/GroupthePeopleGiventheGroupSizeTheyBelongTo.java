package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2020-1-22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        int n = groupSizes.length;

        List<Integer>[] arr = new List[n+1];
        for(int i=0;i<n+1;i++) {
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++) {
            arr[groupSizes[i]].add(i);
        }
        for(int i=1;i<n+1;i++) {
            if(arr[i].size()>=i) {
                for(int k=0;k<arr[i].size();k+=i) {
                    List<Integer> list = (arr[i].subList(k,k+i));
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GroupthePeopleGiventheGroupSizeTheyBelongTo gp = new GroupthePeopleGiventheGroupSizeTheyBelongTo();
        int[] groupSizes1 = new int[]{3,3,3,3,3,1,3};
        int[] groupSizes2 = new int[]{2,1,3,3,3,2};
        int[] groupSizes3 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
        System.out.println(gp.groupThePeople(groupSizes1));
        System.out.println(gp.groupThePeople(groupSizes2));
        System.out.println(gp.groupThePeople(groupSizes3));
    }
}
