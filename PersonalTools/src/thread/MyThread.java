package thread;

public class MyThread implements Runnable{

	public String aa = "";
	public int asland = 0;
	@Override
	public void run() {
//		System.out.println(aa);
		System.out.println("*******1111******");
		aa = asland/0 + "----";
		System.out.println("*******2222******");
	}
	public MyThread(int value){
//		getAA(value);
		asland = value;
	}

	public MyThread(String str){
		
	}
	
	public void getAA(int value){
		aa = value/0 + "----";
	}

}
