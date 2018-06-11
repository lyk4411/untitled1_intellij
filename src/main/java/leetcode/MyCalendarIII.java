package leetcode;

import java.util.TreeMap;

/**
 * Created by lyk on 2018-6-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
//        下面这种方法相当的巧妙，我们建立一个时间点和次数之间的映射，
//        规定遇到起始时间点，次数加1，遇到结束时间点，次数减1。那么我
//        们首先更改新的起始时间start和结束时间end的映射，start对应值增1，
//        end对应值减1。然后定义一个变量cnt，来统计当前的次数。我们使用
//        treemap具有自动排序的功能，所以我们遍历的时候就是按时间顺序的，
//        最先遍历到的一定是一个起始时间，所以加上其映射值，一定是个正数。
//        那么我们想，如果此时只有一个区间，就是刚加进来的区间的话，那么
//        首先肯定遍历到start，那么cnt此时加1，然后就会遍历到end，那么此
//        时cnt减1，最后下来cnt为0，没有重叠。还是用具体数字来说吧，我们
//        现在假设treemap中已经加入了一个区间[3, 5)了，那么我们就有下面的
//        映射：
//        3 -> 1
//        5 -> -1
//        假如我们此时要加入的区间为[6, 8)的话，那么在遍历到6的时候，前面
//        经过3和5，分别加1减1，那么cnt又重置为0了，而后面的6和8也是分别
//        加1减1，还是0。那么加入我们新加入的区间为[3, 8]时，那么此时的映射为：
//        3 -> 2
//        5 -> -1
//        8 -> -1
//        那么我们最先遍历到3，cnt为2，没有超过3，我们知道此时有两个事件有重
//        叠，是允许的。然后遍历5和8，分别减去1，最终又变成0了，始终cnt没有超
//        过2，所以是符合题意的。如果此时我们再加入一个新的区间[1, 4)，那么此
//        时的映射为：
//        1 -> 1
//        3 -> 2
//        4 -> -1
//        5 -> -1
//        8 -> -1
//        那么我们先遍历到1，cnt为1，然后遍历到3，此时cnt为3了，那么我们就知道有三个
//        事件有重叠区间了，所以这个新区间是不能加入的，那么我们要还原其start和end
//        做的操作，把start的映射值减1，end的映射值加1，然后返回false。否则没有三个
//        事件有共同重叠区间的话，返回true即可，参见代码如下：
public class MyCalendarIII {
    TreeMap<Integer, Integer> delta;

    public MyCalendarIII() {
        delta = new TreeMap();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);
        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }
        return ans;
    }

    public static void main(String[] args) {
        MyCalendarIII mciii = new MyCalendarIII();
        System.out.println(mciii.book(10, 20));
        System.out.println(mciii.book(50, 60));
        System.out.println(mciii.book(10, 40));
        System.out.println(mciii.book(5,  15));
        System.out.println(mciii.book(5,  10));
        System.out.println(mciii.book(25, 55));
    }
}
