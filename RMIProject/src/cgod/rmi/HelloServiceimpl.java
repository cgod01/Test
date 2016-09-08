package cgod.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class HelloServiceimpl implements HelloService1{
	private String name;
	
	public HelloServiceimpl(String name) throws RemoteException{
		this.name = name;
		UnicastRemoteObject.exportObject(this, 0);
	}
	
	@Override
	public Date getTime() throws RemoteException {
		System.out.println(name + "调用getTime()方法");
		return new Date();
	}
}
