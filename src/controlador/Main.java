package controlador;

import java.sql.SQLException;

import beans.Actividad;

import conexion.CRUD;

public class Main {

	public static void main(String [ ] args)
	{
	
		CRUD x = new CRUD();
		try {
			/*x.insertActivity("Informativa", "IBM", "20/2/2019", "20:00", "21:00", "DB2 vs SQL server");
			x.insertActivity("Interactiva", "IBM-Watson", "20/2/2019", "19:00", "20:00", "IBM Watson what it is and how it works");
			x.insertActivity("Interactiva", "IBM-DB2", "20/2/2019", "18:00", "19:00", "What is db2 and how it works");
			x.insertSupervisor(2017238881, "Hombre", "alejandro.r.13@hotmail.com", "Alejandro", "Rodriguez", "San Lee", 21, "Tecnologico de Costa Rica");
			x.insertSupervisorActivity(2017238881, "IBM");
			x.insertSupervisorActivity(2017238881, "IBM-Watson");
			x.insertSupervisorActivity(2017238881, "IBM-DB2");
			x.insertBlock("IBM-Block", "Diferentes charlas sobre ibm", "15/6/2019", "Pacific time");
			x.insertBlockActivity("IBM", "IBM-Block");
			x.insertBlockActivity("IBM-Watson", "IBM-Block");
			x.insertBlockActivity("IBM-DB2", "IBM-Block");
			x.insertUser(2015238884, "Hombre", "Natsudark13@gmail.com", "Natsu", "Dragneel", "Fiore", "1234", "Estudiante");
			x.insertUser(201799852, "Mujer", "ejemplo@gmail.com", "Lucy", "Hearthfilia", "Fiore", "1234", "Estudiante");
			x.insertUser(2015002456, "Hombre", "ejemplo2@gmail.com", "Roy", "Mustang", "FM", "1234", "Profesor");
			x.insertComments(2015238884, "IBM", "Me encanto toda la actividad eso fue increible");
			x.insertComments(2015238884, "IBM-Watson", "No entendi mucho, pero no estuvo mal la verdad");
			x.insertComments(201799852, "IBM-Watson", "No entendi nada, los tutoriales se ven faciles, pero a mi no me sirve, odio a watson");
			x.insertComments(2015238884, "IBM-DB2", "Wow no sabia que DB2 era tan util,lo voy empezar a usar a partir de ahora");
			x.insertComments(201799852, "IBM-DB2", "No me gusto DB2, talvez porque soy muy pro SQL server");
			x.insertComments(2015002456, "IBM-DB2", "Me gusto DB2, lo voy a utilizar en las clases a partir de ahora");
			x.insertUserActivity(2015238884, "IBM");
			x.insertUserActivity(2015238884, "IBM-Watson");
			x.insertUserActivity(201799852, "IBM-Watson");
			x.insertUserActivity(2015238884, "IBM-DB2");
			x.insertUserActivity(201799852, "IBM-DB2");
			x.insertUserActivity(2015002456, "IBM-DB2");
			System.out.println(x.select_ExisteUsuario("Natsudark13@gmail.com", "1234"));
			System.out.println(xx.listaActividadesPorComentarios().get(0));
			System.out.println(xx.listaActividadesPorUsuarios().get(0));*/
			System.out.println(x.select_Actividades_Asistente(201799852).get(1));
			Actividad z = new Actividad();
			System.out.println(z.listaActividadesPorUsuarios().size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
