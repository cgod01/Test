package cgod.daili;

public class Testdaili {
	public static void main(String[] args) {
		RunnablleModel rm = new RunnablleModel();
		Thread1 t = new Thread1(rm);
		t.run();
		
		ThreadModel tm = new ThreadModel();
		tm.run();
	}
}
