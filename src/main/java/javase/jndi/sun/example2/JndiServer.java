package javase.jndi.sun.example2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JndiServer {

    public static void main(String args[]) {
    	try {
	        Properties properties = new Properties();
	        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
	        properties.put(Context.PROVIDER_URL, "rmi://localhost:1069");
	        InitialContext context = new InitialContext(properties);
	        
	        MysqlDataSource dataSource = new MysqlConnectionPoolDataSource();
	        dataSource.setUser("root");
	        dataSource.setPassword("");
	        dataSource.setServerName("localhost");
	        dataSource.setPort(3306);
	        dataSource.setDatabaseName("javase_jndi_sun_example2");
	
	        LocateRegistry.createRegistry(1069);
	        context.rebind("jdbc/Mysql", dataSource); 
	        
	        System.out.println("RMI registry Stared.");
    	} catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }     
    }
}