package javase.jndi.sun.example1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
 
public class JndiServer {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY , "com.sun.jndi.rmi.registry.RegistryContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "rmi://localhost:1059");
            InitialContext ctx = new InitialContext(properties);

            // it must be placed before ctx.rebind
            LocateRegistry.createRegistry(1059);
            RmiSimple server = new RmiSimpleImpl();
            ctx.rebind("RmiSimple", server);

            System.out.println("jndi server started...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
 