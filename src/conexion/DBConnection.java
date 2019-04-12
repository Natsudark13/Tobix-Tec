package conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {
	private String hostName ;
	private String dbName ;
	private String user ;
	private String password ;
	private String url;
	private Connection connection;
	
	public DBConnection (){
		hostName = "dbtob.database.windows.net"; 
        dbName = "Tobix"; // update me
        user = "SDadmin"; // update me
        password = "Root12345"; // update me
        url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        connection = null;

	}
	
	public Connection openConnection(){
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
}