package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActivityCrud {

	private DBConnection db;
	
	public ActivityCrud(DBConnection db){
		this.db = db;
	}
	
	public void insert(String type, String name, String date, String sTime, String fTime, String description) throws SQLException {
		 	Connection con = db.openConnection();
	        String sql = "insert into " + "Activity" + " values( " + "?,?,?,?,?,?" + ")";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        	
	        	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		  
		        try {
		        	java.sql.Date date1 = new java.sql.Date( dateformat.parse(date).getTime());

					
					pstmt.setObject(1, type);
		            pstmt.setObject(2, name);
		            pstmt.setObject(3, date1);
		            pstmt.setObject(4, sTime);
		            pstmt.setObject(5, fTime);
		            pstmt.setObject(6, description);

		            pstmt.execute();
		            
				} catch (ParseException e) {
					e.printStackTrace();
				}
		            
	            
	        }
	        con.close();
	    }
	
	public void insertSupervisorActivity(int id,String name) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Activity_Supervisor" + " values( " + "?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, id);
	            pstmt.setObject(2, name);

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void delete(String name) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "delete from " + "Activity" + " where ActivityName = "+"'"+name+"'"+"";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void deleteSupervisorActivity(String name,int id) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "delete from " + "Activity_Supervisor" + " where ActivityName = "+"'"+name+"'"+"and SupervisorID =+"+id+"+";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.execute();	                                 
        }
        con.close();
    }
}
