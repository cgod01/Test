package cgod.daili.dtdaili;

public class RealSubject implements Subject{
	@Override
	public void request(String aaa) {
		System.out.println("Form real subject: "
				+aaa);
	}
	public RealSubject() {
	}
}
