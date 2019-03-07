package javaTuning.ch04.threadLocal;

import java.util.Date;

public class MyThread implements Runnable{
	public static final ThreadLocal<Date> localvar= new ThreadLocal<Date>();
	private long time;
	public MyThread(long time){
		this.time=time;
	}
	@Override
	public void run() {
		Date d=new Date(time);
		for(int i=0;i<50000;i++){
			localvar.set(d);
			if(localvar.get().getTime()!=time)
				System.out.println("id="+time+" localvar="+localvar.get().getTime());
			System.out.print("time:" + time  + " and ");
			System.out.println("localvar.get().getTime():" + localvar.get().getTime());
		}
	}
}
