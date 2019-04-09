package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BlockCRUD {
	
	private DBConnection db;
	
	public BlockCRUD(DBConnection db){
		this.db = db;
	}
	
	public void insert(String topic, String description, String date, String timeZone) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Block" + " values( " + "?,?,?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        	
        	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	  
	        try {
	        	java.sql.Date date1 = new java.sql.Date( dateformat.parse(date).getTime());

				
				pstmt.setObject(1, topic);
	            pstmt.setObject(2, description);
	            pstmt.setObject(3, date1);
	            pstmt.setObject(4, timeZone);

	            pstmt.execute();
	            
			} catch (ParseException e) {
				e.printStackTrace();
			}
	            
            
        }
        con.close();
    }
	
	public void insertBlockActivity(String activityName,String topic) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Block_Activity" + " values( " + "?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, topic);
	            pstmt.setObject(2, activityName);

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void delete(String topic) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "delete from " + "Block" + " where Topic = "+"'"+topic+"'"+"";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void deleteBlockActivity(String topic, String activityName) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "delete from " + "Block_Activity" + " where Topic = "+"'"+topic+"'"+"and ActivityName = "+"'"+activityName+"'"+"";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.execute();	                                 
        }
        con.close();
    }
}
