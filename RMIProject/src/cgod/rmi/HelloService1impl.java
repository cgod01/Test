package cgod.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloService1impl extends UnicastRemoteObject implements HelloService{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public HelloService1impl(String name) throws RemoteException{
		this.name = name;
	}
	@Override
	public String echo(String msg) throws RemoteException {
		System.out.println(name+"调用echo()方法");
		return "echo" + msg + "from " + name;
	}
}
