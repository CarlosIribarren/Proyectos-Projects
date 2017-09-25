package my.project.database;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//Patrón Factory y Singleton
public class ConnectionFactory {
	private static final String JNDI_NAME = "jdbc/empresaReparto";
	
	private static ConnectionFactory instance = null;
	
	private DataSource dataSource;
	
	private ConnectionFactory() {}
	
    private synchronized static void createInstance() {
        if (instance == null) { 
        	instance = new ConnectionFactory();
        	try {
    			Context initContext = new InitialContext();
    			Context envContext = (Context) initContext.lookup("java:/comp/env");
    			instance.dataSource =  (DataSource) envContext.lookup(JNDI_NAME);
    		} catch (NamingException e) {
    			// Handle error that it's not configured in JNDI.
    			e.printStackTrace();
    		}
        }
    }
	
	public static Connection getConnection() throws SQLException{
        createInstance();
        return instance.dataSource.getConnection();
    }
	
	@Override
    // El método "clone" debe ser sobreescrito para evitar duplicación de objetos
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }

}