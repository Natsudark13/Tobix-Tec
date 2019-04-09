package conexion;

import java.sql.SQLException;

public class Main {

	public static void main(String [ ] args)
	{
		DBConnection db = new DBConnection();
		CRUD x = new CRUD(db);
		try {
			x.deleteActivity("Activida Informativa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
