package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class CRUD {

	private DB2 db;
	
	public CRUD(){
		this.db = new DB2();
	}
	
	
	// Inserts to the database
	
	
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
        String sql = "insert into " + "TOBIX_USER" + " values( " + "?,?,?,?,?,?,?,?" + ")";
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
	
	public void insertUserActivity(int id, String name) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "ACTIVITY_USER" + " values( " + "?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, id);
	            pstmt.setObject(2, name);
	           

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void insertComments(String name, String description) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "COMMENTS" + " values( " + "?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.setObject(1, name);
	            pstmt.setObject(2, description);

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	
	// Selects to the data bases.
	
	public ArrayList<String> select_ALL_Actividades() throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select * from activity";
        ArrayList<String> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 	while ( rs.next() ) {

	 		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 		list.add(rs.getString("TYPE"));
	 		list.add(rs.getString("NAME"));
	 		list.add(dateFormat.format(rs.getDate("ACTIVITYDATE")));
	 		list.add(rs.getString("STARTTIME"));
	 		list.add(rs.getString("FINALTIME"));
	 		list.add(rs.getString("DESCRIPTION"));
	 		
        }
	 	}
        con.close();
        return list;
   
    }
	
	
	public ArrayList<String> select_Actividades(String nameActivity) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select * from activity where NAME = "+"'"+nameActivity+"'"+"";
        ArrayList<String> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
	 		
	 		rs.next();
	 		
	 		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 		list.add(rs.getString("TYPE"));
	 		list.add(rs.getString("NAME"));
	 		list.add(dateFormat.format(rs.getDate("ACTIVITYDATE")));
	 		list.add(rs.getString("STARTTIME"));
	 		list.add(rs.getString("FINALTIME"));
	 		list.add(rs.getString("DESCRIPTION"));
	 	}
        con.close();
        return list;
   
    }
	
	public ArrayList<Integer> select_ID_Encargados() throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select SUPERVISORID from SUPERVISOR";
        ArrayList<Integer> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 	while ( rs.next() ) {
	 		
	 		list.add(rs.getInt("SUPERVISORID"));
           
        }
	 	}
        con.close();
        return list;
    }
	
	public ArrayList<String> select_Name_Actividades() throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select NAME from activity";
        ArrayList<String> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 	while ( rs.next() ) {
	 		
	 		list.add(rs.getString("NAME"));
           
        }
	 	}
        con.close();
        return list;
    }
	
	
	public String select_Description_Actividades(String nameActivity) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select description from activity where name = "+"'"+nameActivity+"'"+"";
        String description;
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 		rs.next();
            description = rs.getString("description");
            
	 	}
        con.close();
        return description;
    }
	
	public String select_correo(int id) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select email from TOBIX_USER where USERID = "+id+"";
        String email;
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 		rs.next();
	 		email = rs.getString("email");
            
	 	}
        con.close();
        return email;
    }
	
	public ArrayList<Integer> select_IDUsuarios_Actividad(String nameActivity) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select USER_ID from ACTIVITY_USER where ACTIVITY_NAME = "+"'"+nameActivity+"'"+"";
        ArrayList<Integer> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 		while ( rs.next() ) {
	 		
	 		list.add(rs.getInt("USER_ID"));

	 		}
	 	}
        con.close();
        return list;
   
    }
	
	
	public ArrayList<String> select_Comments_Actividad(String nameActivity) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select DESCRIPTION from COMMENTS where ACTIVITYNAME = "+"'"+nameActivity+"'"+"";
        ArrayList<String> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 		while ( rs.next() ) {
	 		
	 		list.add(rs.getString("DESCRIPTION"));

	 		}
	 	}
        con.close();
        return list;
   
    }
	
	public int select_ExisteUsuario(String email, String password) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select USERID from TOBIX_USER where PASSWORD = "+"'"+password+"'"+" and EMAIL = "+"'"+email+"'"+"";
        int description;
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
	 		rs.next();
	 		if(rs.isClosed() != true){
	 			
	 			
	            description = rs.getInt("USERID");
	 		}
	 		else{
	 			description = 0; 
	 		}
            
	 	}
        con.close();
        return description;
    }
	
	
	public int select_ExisteAdmin(String email, String password) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select ID from ADMINISTRADOR where PASSWORD = "+"'"+password+"'"+" and EMAIL = "+"'"+email+"'"+"";
        int description;
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
	 		rs.next();
	 		if(rs.isClosed() != true){
	 			
	 			
	            description = rs.getInt("ID");
	 		}
	 		else{
	 			description = 0; 
	 		}
            
	 	}
        con.close();
        return description;
    }
	
	
	public ArrayList<String> select_Tipo_Bloque() throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select TOPIC from BLOCK";
        ArrayList<String> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 		while ( rs.next() ) {
	 		
	 		list.add(rs.getString("TOPIC"));

	 		}
	 	}
        con.close();
        return list;
   
    }
	
	public ArrayList<String> select_Actividades_Asistente(int id) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select NAME from activity join ACTIVITY_USER on activity.NAME = ACTIVITY_USER.ACTIVITY_NAME where ACTIVITY_USER.USER_ID = "+id+"";
        ArrayList<String> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 		while ( rs.next() ) {
	 		
	 		list.add(rs.getString("NAME"));

	 		}
	 	}
        con.close();
        return list;
   
    }
	
	public ArrayList<String> select_Bloque_actividad(String topic) throws SQLException {
	 	Connection con = db.openConnection();
	 	Statement stmt = con.createStatement();
        String sql = "Select NAME from ACTIVITY join BLOCK_ACTIVITY on activity.name = BLOCK_ACTIVITY.ACTIVITYNAME where TOPIC ="+"'"+topic+"'"+"";
        ArrayList<String> list = new ArrayList<>();
	 	try(ResultSet rs = stmt.executeQuery(sql)) {
        
	 		while ( rs.next() ) {
	 		
	 		list.add(rs.getString("NAME"));

	 		}
	 	}
        con.close();
        return list;
   
    }
	
	
	
	
	//Delete to the database

	public void deleteActivity(String name) throws SQLException {
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
