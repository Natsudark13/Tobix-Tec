package conexion;

import java.sql.SQLException;

public class Main {

	public static void main(String [ ] args)
	{
		DB2 db = new DB2();
		CRUD x = new CRUD(db);
		try {
			x.insertActivity("Informativa", "IBM", "20/2/2019", "22:00", "23:00", "IBM DB2 vs SQL server");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
