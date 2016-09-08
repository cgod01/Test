package cgod.daili;

public class Thread1 {
	private Runnable run;
	public Thread1(Runnable run) {
		this.run = run;
	}
	public Thread1() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		run.run();
	}
}
