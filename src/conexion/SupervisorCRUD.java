package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupervisorCRUD {

	private DBConnection db;
	
	public SupervisorCRUD(DBConnection db){
		this.db = db;
	}
	
	public void insert(int id, String sex, String email, String name, String lastN, String lastN2, int exp, String organization) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Supervisor" + " values( " + "?,?,?,?,?,?,?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, id);
	            pstmt.setObject(2, sex);
	            pstmt.setObject(3, email);
	            pstmt.setObject(4, name);
	            pstmt.setObject(5, lastN);
	            pstmt.setObject(6, lastN2);
	            pstmt.setObject(7, exp);
	            pstmt.setObject(8, organization);

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void delete(int id) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "delete from " + "Supervisor" + " where SupervisorID = "+id+"";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.execute();	                                 
        }
        con.close();
    }
}

