package xdp.test.jvm.memory;

public class StackOOM {

	public static void main(String[] args) {
		StackOOM oom = new StackOOM();
		oom.stackLeakByThread();
	}
	
	public  void stackLeakByThread(){
		int count = 0;
		while(true){
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						
					}
				}
			});
			t.start();
			count++;
			System.out.println(count);
		}
	}
	
	

}
