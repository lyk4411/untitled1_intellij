package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNjum(1);
        System.out.println(mf.findMedian());
        mf.addNjum(2);
        System.out.println(mf.findMedian());
        mf.addNjum(3);
        System.out.println(mf.findMedian());
        mf.addNjum(4);
        System.out.println(mf.findMedian());
        mf.addNjum(5);
        System.out.println(mf.findMedian());
        mf.addNjum(6);
        System.out.println(mf.findMedian());
        mf.addNjum(7);
        System.out.println(mf.findMedian());
        mf.addNjum(8);
        System.out.println(mf.findMedian());
        mf.addNjum(1);
        System.out.println(mf.findMedian());
        mf.addNjum(2);
        System.out.println(mf.findMedian());
        mf.addNjum(3);
        System.out.println(mf.findMedian());
        mf.addNjum(4);
        System.out.println(mf.findMedian());
        mf.addNjum(5);
        System.out.println(mf.findMedian());
        mf.addNjum(6);
        System.out.println(mf.findMedian());
        mf.addNjum(7);
        System.out.println(mf.findMedian());
        mf.addNjum(8);
        System.out.println(mf.findMedian());

    }
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder(){
        // 新建最大堆
        maxheap = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        // 新建最小堆
        minheap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNjum(int num) {
        // 如果最大堆为空，或者该数小于最大堆堆顶，则加入最大堆
        if(maxheap.size() == 0 || num <= maxheap.peek()){
            // 如果最大堆大小超过最小堆，则要平衡一下
            if(maxheap.size() > minheap.size()){
                minheap.offer(maxheap.poll());
            }
            maxheap.offer(num);
            // 数字大于最小堆堆顶，加入最小堆的情况
        } else if (minheap.size() == 0 || num > minheap.peek()){
            if(minheap.size() > maxheap.size()){
                maxheap.offer(minheap.poll());
            }
            minheap.offer(num);
            // 数字在两个堆顶之间的情况
        } else {
            if(maxheap.size() <= minheap.size()){
                maxheap.offer(num);
            } else {
                minheap.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        // 返回大小较大的那个堆堆顶，如果大小一样说明是偶数个，则返回堆顶均值
        if (maxheap.size() > minheap.size()) {
            return maxheap.peek();
        } else if (maxheap.size() < minheap.size()) {
            return minheap.peek();
        } else if (maxheap.isEmpty() && minheap.isEmpty()) {
            return 0;
        } else {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
    }
}
