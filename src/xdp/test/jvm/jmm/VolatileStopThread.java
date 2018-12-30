package xdp.test.jvm.jmm;

import java.util.concurrent.TimeUnit;

public class VolatileStopThread extends Thread{
	private volatile boolean stop = false;
	public void stopMe() {
		stop = true;
	}
	
	@Override
	public void run() {
		long i=0;
		while(!stop) {
			i++;
		}
		
		System.out.println(System.currentTimeMillis()+"stop thread "+i);
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileStopThread thread = new VolatileStopThread();
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(System.currentTimeMillis());
		thread.stopMe();
		TimeUnit.SECONDS.sleep(1);

	}

}
