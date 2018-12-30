package xdp.test.jvm.memory;

public class FinalizeEscapeGC {
	
	public static FinalizeEscapeGC SAVE_HOOK = null;
	
	public void isAlive(){
		System.out.println("I'm still alive");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}



	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();
		
		// 对象第一次成功拯救自己
		SAVE_HOOK = null;
		System.gc();
		// 暂停0.5s等待finalize方法执行完成
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("I'm dead.");
		}
		
		// 对象第二次gc,未能成功拯救自己，finalize方法只能被执行一次
		SAVE_HOOK = null;
		System.gc();
		// 暂停0.5s等待finalize方法执行完成
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("I'm dead.");
		}
		

	}

}
