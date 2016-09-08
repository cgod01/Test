package cgod.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;

public class RmiClient {
	
	public static void showRemoteObjects(Context nameContext) throws Exception{
		NamingEnumeration<NameClassPair> e = nameContext.list("rmi:");
		while(e.hasMore()){
			System.out.println(e.next().getName());
		}
	}
	
	public static void main(String[] args) {
		try {
			Context nameContext = new InitialContext();
			HelloService1 hs = (HelloService1)nameContext.lookup("rmi://localhost/HelloService1");
			HelloService hs1 = (HelloService)nameContext.lookup("rmi://localhost/HelloService");
			
			Class stubClass = hs.getClass();
			Class stubClass1 = hs1.getClass();
			System.out.println(stubClass.getName()+"实例");
			System.out.println(stubClass1.getName()+"实例");
			
			Class[] interfaces = stubClass.getInterfaces();
			for (int i = 0; i < interfaces.length; i++) {
				System.out.println(stubClass.getName() + "的根存实现了" + interfaces[i].getName());
			}
			Class[] interfaces1 = stubClass1.getInterfaces();
			for (int i = 0; i < interfaces1.length; i++) {
				System.out.println(stubClass1.getName() + "的根存实现了" + interfaces1[i].getName());
			}
			
			System.out.println(hs.getTime());
			System.out.println(hs1.echo("i am cgod!"));
			
			showRemoteObjects(nameContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
