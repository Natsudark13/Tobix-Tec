package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CRUD {

private DBConnection db;
	
	public CRUD(DBConnection db){
		this.db = db;
	}
	
	public void insertActivity(String type, String name, String date, String sTime, String fTime, String description) throws SQLException {
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
	
	public void deleteActivity(String name) throws SQLException {
	 	Connection con = db.openConnection();
	    String sql = "delete from " + "Activity" + " where ActivityName = "+"'"+name+"'"+"";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	
	            pstmt.execute();	                                 
	    }
	    con.close();
	}
	
	public void insertBlock(String topic, String description, String date, String timeZone) throws SQLException {
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
	
	public void insertSupervisor(int id, String sex, String email, String name, String lastN, String lastN2, int exp, String organization) throws SQLException {
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
	
	public void insertUser(int id, String sex, String email, String name, String lastN, String lastN2, String password, String identityP) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "User" + " values( " + "?,?,?,?,?,?,?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, id);
	            pstmt.setObject(2, sex);
	            pstmt.setObject(3, email);
	            pstmt.setObject(4, name);
	            pstmt.setObject(5, lastN);
	            pstmt.setObject(6, lastN2);
	            pstmt.setObject(7, password);
	            pstmt.setObject(8, identityP);

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void insertComments(String id,String name, String description) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Comments" + " values( " + "?,?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, id);
	            pstmt.setObject(2, name);
	            pstmt.setObject(3, description);

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
	
	public void deleteBlock(String topic) throws SQLException {
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
	
	public void deleteSupervisor(int id) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "delete from " + "Supervisor" + " where SupervisorID = "+id+"";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void deleteUser(int id) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "delete from " + "User" + " where UserID = "+id+"";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void deleteComment(String id,String activityName) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "delete from " + "Comments" + " where UserID = "+id+"and ActivityName = "+"'"+activityName+"'"+"";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.execute();	                                 
        }
        con.close();
    }
}
