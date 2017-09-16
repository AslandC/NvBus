package thread;

public class TestThread {
	public static void main(String[] args) {
		System.out.println("--------begin---------");
//		TestThread test = new TestThread();
//		new Thread(new MyThread(test.getAA(9))).start();
		new Thread(new MyThread(9)).start();
		System.out.println("--------end---------");
	}
	
	public String getAA(int value){
		return value/0 + "----";
	}
}
