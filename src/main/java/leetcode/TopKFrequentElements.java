package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/4/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements tkfe = new TopKFrequentElements();
        int[] nums = new int[]{1,1,1,2,2,2,3,3,3,4,4};
        System.out.println(tkfe.topKFrequent(nums,2));
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.count-b.count;
            }
        });

        //maintain a heap of size k.
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while(queue.size()>0){
            result.add(queue.poll().num);
        }
        //reverse the order
        Collections.reverse(result);

        return result;
    }
//    public List<Integer> topKFrequent(int[] nums, int k) {
//
//        List<Integer>[] bucket = new List[nums.length + 1];
//        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
//
//        for (int n : nums) {
//            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
//        }
//
//        for (int key : frequencyMap.keySet()) {
//            int frequency = frequencyMap.get(key);
//            if (bucket[frequency] == null) {
//                bucket[frequency] = new ArrayList<>();
//            }
//            bucket[frequency].add(key);
//        }
//
//        List<Integer> res = new ArrayList<>();
//
//        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
//            if (bucket[pos] != null) {
//                res.addAll(bucket[pos]);
//            }
//        }
//        return res;
//    }
}

class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}
