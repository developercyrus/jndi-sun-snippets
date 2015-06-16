package javase.jndi.sun.example1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiSimple extends Remote {
	public String sayHello() throws RemoteException;
}