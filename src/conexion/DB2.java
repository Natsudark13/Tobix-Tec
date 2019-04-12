package conexion;
import java.sql.*;  

public class DB2 {
	
	//private String hostName ;
	//private String dbName ;
	//private String user ;
	private String password ;
	private String url;
	private Connection con;
	
	public DB2() {
		//hostName = "dbtob.database.windows.net"; 
        //dbName = "Tobix"; // update me
        //user = "cgd80377"; // update me
        password = "zl5d9@dw01f1j1bd"; // update me
        url = String.format("jdbc:db2://dashdb-txn-sbox-yp-dal09-03.services.dal.bluemix.net:50000/BLUDB:user=cgd80377;password="+password+";");
        con = null;
	}
	
	public Connection openConnection(){
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
