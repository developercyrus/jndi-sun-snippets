package javase.jndi.sun.example2;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class Client {

    public static void main(String args[]) throws RemoteException, NamingException, SQLException {
        System.out.println(getValue());       
    }
    
    public static String getValue() {
    	Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        properties.put(Context.PROVIDER_URL, "rmi://localhost:1069");
        
        try {  
	        InitialContext context = new InitialContext(properties);
	        ConnectionPoolDataSource ds = (MysqlConnectionPoolDataSource) context.lookup("jdbc/Mysql");
	        PooledConnection pConn = ds.getPooledConnection();
	        Connection conn = pConn.getConnection();        
	        Statement stmt = conn.createStatement();        
	        ResultSet rs = stmt.executeQuery("select symbol from language where id = 1");
	        if (rs.next()) {
	            return rs.getString("symbol");
	        }
	    } catch (NamingException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;       
    }
}