package conexion;

import java.sql.SQLException;

public class Main {

	public static void main(String [ ] args)
	{
		DBConnection db = new DBConnection();
		ActivityCrud x = new ActivityCrud(db);
		try {
			x.delete("Activida Informativa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
