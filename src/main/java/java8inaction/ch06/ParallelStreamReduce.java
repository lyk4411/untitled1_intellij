package java8inaction.ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2019-2-14.
 * Package name: java8inaction.ch06
 * Porject name: untitled1
 */
public class ParallelStreamReduce {
    public static void main(String[] args) {
        //accumulator不写入list,不需要线程同步,初始值使用普通的list
        List<Integer> list = new ArrayList<>();
        AtomicInteger accumulateCount = new AtomicInteger(0);
        AtomicInteger combineCount = new AtomicInteger(0);
        List<Integer> reduceResult = IntStream.range(0, 100)
                .parallel()
                .boxed()
                .reduce(list, (i, j) -> {
                    accumulateCount.incrementAndGet();
                    //不改变初始的i,而是返回一个新的i
                    ArrayList<Integer> newI = new ArrayList<>(i);
                    newI.add(j);
                    return newI;
                }, (i, j) -> {
                    combineCount.incrementAndGet();
                    System.out.println(String.format("i==j: %s, thread name:%s", i == j, Thread.currentThread().getName()));
//                    ArrayList<Integer> newI = new ArrayList<>(i);
                    i.addAll(j);
                    return i;
                });
        System.out.println("---------------------------------------");
        System.out.println("reduce result size: "+reduceResult.size());
        System.out.println("reduce result : "+reduceResult);
        System.out.println("accumulateCount: "+accumulateCount.get());
        System.out.println("combineCount: "+combineCount.get());
    }
}
