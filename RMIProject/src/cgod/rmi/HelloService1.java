package cgod.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface HelloService1 extends Remote{
	public Date getTime() throws RemoteException;
}
