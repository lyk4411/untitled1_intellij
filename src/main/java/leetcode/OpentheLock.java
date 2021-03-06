package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lyk on 2018-6-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> used = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        used.add("0000");
        for (String d:deadends) {
            if(d.equals("0000"))
                return -1;
            used.add(d);
        }
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String cur = q.poll();
                if(cur.equals(target))
                    return ans;
                String[] newStr = getNext(cur);
                for (int i = 0; i < 8; i++) {
                    if(!used.contains(newStr[i])){
                        q.add(newStr[i]);
                        used.add(newStr[i]);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    //用来求出当前密码的每一种转法
    String[] getNext(String lock){
        String[] res  = new String[8];
        for (int i = 0; i < 4; i++) {
            res[i*2] = lock.substring(0,i)+((lock.charAt(i)-'0'+1)%10)+lock.substring(i+1,4);
            res[i*2+1] = lock.substring(0,i)+((lock.charAt(i)-'0'+9)%10)+lock.substring(i+1,4);
        }
        return res;
    }

    public static void main(String[] args) {
        OpentheLock ol = new OpentheLock();
        String[] dl = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(ol.openLock(dl,"1224"));
    }
}
