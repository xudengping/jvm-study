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
		
		// �����һ�γɹ������Լ�
		SAVE_HOOK = null;
		System.gc();
		// ��ͣ0.5s�ȴ�finalize����ִ�����
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("I'm dead.");
		}
		
		// ����ڶ���gc,δ�ܳɹ������Լ���finalize����ֻ�ܱ�ִ��һ��
		SAVE_HOOK = null;
		System.gc();
		// ��ͣ0.5s�ȴ�finalize����ִ�����
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("I'm dead.");
		}
		

	}

}
