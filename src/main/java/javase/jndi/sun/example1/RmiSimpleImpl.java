package javase.jndi.sun.example1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiSimpleImpl extends UnicastRemoteObject implements RmiSimple {
	private static final long serialVersionUID = -684732203883510610L;

	protected RmiSimpleImpl() throws RemoteException {
		super();
	}

	public String sayHello() throws RemoteException {
		return "Hello World!";
	}
}