package JavaConcurrencyinPractice;

import java.util.concurrent.*;

/**
 * Created by lyk on 2018-12-19.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */

public class CallbleTask implements Callable<Integer> {
    /**
     * 休眠时间
     */
    private int sleepSeconds;
    /**
     * 返回的值
     */
    private int returnValue;

    public CallbleTask(int sleepSeconds, int returnValue) {
        this.sleepSeconds = sleepSeconds;
        this.returnValue = returnValue;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("begin to execute.");

        TimeUnit.SECONDS.sleep(sleepSeconds);

        System.out.println("end to execute.");

        return returnValue;
    }

    public static void main(String[] args) {
        int taskSize = 5;

        ExecutorService executor = Executors.newFixedThreadPool(taskSize);

        // 构建完成服务
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
        int sleep = 5; // 睡眠时间，单位是秒，不是毫秒
        for (int i = 1; i <= taskSize; i++) {
            int value = i; // 返回结果
            // 向线程池提交任务
            completionService.submit(new CallbleTask(sleep, value));//返回结果类型FutureTask
        }

        // 按照完成顺序,打印结果
        for (int i = 0; i < taskSize; i++) {
            try {
                Future<Integer> f = completionService.take();
                System.out.println(f.get());// 阻塞，知道有任务完成可以获取结果
                // System.out.println(completionService.poll());//poll直接返回，不阻塞。但是没有完成的任务则返回null
                // System.out.println(completionService.poll(5, TimeUnit.SECONDS));//阻塞等待指定时间，如果有完成结果返回，没有的直接返回null																					// completionService.submit(new RunnableTask(),2);//completionService提交Runnable任务是无法获取结果的

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 所有任务已经完成,关闭线程池
        System.out.println("执行完毕....");
        executor.shutdown();
    }

}
