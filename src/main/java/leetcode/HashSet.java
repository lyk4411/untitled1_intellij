package leetcode;

/**
 * Created by lyk on 2018-7-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HashSet {
    int[] arr;

    /** Initialize your data structure here. */
    public HashSet() {
        arr = new int[1000000];
    }

    public void add(int key) {
        arr[hash(key)] = key+1;  // handle the case key=0
    }

    public void remove(int key) {
        arr[hash(key)] = 0;
    }

    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        return (arr[hash(key)]!=0);
    }

    private int hash(int i){
        return i;
    }

    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(0);
        hs.add(1);
        hs.add(2);
        hs.add(2);
        System.out.println(hs.contains(2));
        hs.remove(2);
        System.out.println(hs.contains(2));
    }
}
