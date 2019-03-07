package javaTuning.ch04.threadLocal;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadLocal {


	@Test
	public void test() throws InterruptedException {
		ExecutorService exe=Executors.newCachedThreadPool();
		exe.execute(new MyThread(1));
		exe.execute(new MyThread(2));
		Thread.sleep(10000);
		exe.execute(new MyThread(3));
		exe.execute(new MyThread(4));


	}

}
