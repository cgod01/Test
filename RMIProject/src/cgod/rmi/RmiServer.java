package cgod.rmi;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

public class RmiServer {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			HelloService1 hs1 = new HelloServiceimpl("server1");
			HelloService hs2 = new HelloService1impl("server2");
			Context nameContext = new InitialContext();
			nameContext.rebind("rmi://localhost:1099/HelloService1", hs1);
			nameContext.rebind("rmi://localhost:1099/HelloService", hs2);
			System.out.println("服务器注册了HelloService,HelloService1两个对象!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
