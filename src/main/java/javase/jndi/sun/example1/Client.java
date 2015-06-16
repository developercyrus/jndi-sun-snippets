package javase.jndi.sun.example1;

import java.rmi.RemoteException;
import java.util.Properties;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {
    public static void main(String[] args) {
        System.out.println(getValue());
    }
    
    public static String getValue() {    
	    Properties properties = new Properties();
	    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY , "com.sun.jndi.rmi.registry.RegistryContextFactory");
	    properties.setProperty(Context.PROVIDER_URL, "rmi://localhost:1059");
	    try {        	
	        InitialContext ctx = new InitialContext(properties);
	        RmiSimple remote = (RmiSimple) ctx.lookup("RmiSimple");
	        return remote.sayHello();
	    } catch (NamingException e) {
	        e.printStackTrace();
	    } catch (RemoteException e) {
	        e.printStackTrace();
	    }
		return null;
    }
}
 