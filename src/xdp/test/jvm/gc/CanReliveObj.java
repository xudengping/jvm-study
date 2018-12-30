package xdp.test.jvm.gc;

import java.util.concurrent.TimeUnit;

public class CanReliveObj {
	private static CanReliveObj obj;
	
	// gcֻ�����һ��
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("CanReliveObj finalize called");
		obj = this;
	}

	@Override
	public String toString() {
		
		return "I am CanReliveObj";
	}
	
	public static void main(String[] args) throws InterruptedException {
		obj = new CanReliveObj();
		obj = null;
		System.out.println("��һ��gc");
		System.gc();
		TimeUnit.SECONDS.sleep(1);
		if(obj == null) {
			System.out.println("obj is null");
		}else {
			System.out.println("obj can use");
		}
		
		System.out.println("�ڶ���gc");
		obj = null;
		System.gc();
		TimeUnit.SECONDS.sleep(1);
		if(obj == null) {
			System.out.println("obj is null");
		}else {
			System.out.println("obj can use");
		}
	}
}
