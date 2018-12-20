package JavaConcurrencyinPractice;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lyk on 2018-12-20.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */

public class BrokenPrimeProducer_Main {

    public static void main(String[] args){
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<>(3);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(queue);
        producer.start();
        while(true){
            try {
                System.out.println(Thread.currentThread().getName()
                        +"消费数据"+queue.take());// 从队列取出一个数
                TimeUnit.MICROSECONDS.sleep(1);// 停止1s,显示出消费速度慢于生产速度　
                producer.cancel();// 消费者请求停止生产　

            } catch (InterruptedException e) {
                System.out.println("被中断了");
            }
        }
    }
}