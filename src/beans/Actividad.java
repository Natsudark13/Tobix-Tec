package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

import conexion.CRUD;
import conexion.DB2;

public class Actividad implements Ordenamiento{

	private String nombreActivad;
	private String tipoActividad;
	private Date fechaActividad;
	private String horaInicio;
	private String horaFinal;
	private String descripcionActividad;
	
	public Actividad(){
		
	}

	@Override
	public boolean menorQue(Object pComparable) {
		
		return false;
	}
	
	public ArrayList<String> listaActividadesPorComentarios(){
		DB2 db = new DB2();
		CRUD x = new CRUD(db);
		int contador = 0;
		ArrayList<String> listaOrdenada = new ArrayList<>();
		try {
			ArrayList<String> listaP = x.select_Name_Actividades();
			while(contador != listaP.size()){
				//System.out.println(listaP.get(contador));
				
				if( listaOrdenada.isEmpty()){
					listaOrdenada.add(0, listaP.get(contador));
				}
				if(x.select_Comments_Actividad(listaP.get(contador)).size() > x.select_Comments_Actividad(listaOrdenada.get(0)).size()){
					listaOrdenada.add(0, listaP.get(contador));
				}
				else{
					listaOrdenada.add(listaP.get(contador));
				}
				contador++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Collections.reverse(listaOrdenada);
		return listaOrdenada;
		
	}
	
	public ArrayList<String> listaActividadesPorUsuarios(){
		DB2 db = new DB2();
		CRUD x = new CRUD(db);
		int contador = 0;
		ArrayList<String> listaOrdenada = new ArrayList<>();
		try {
			ArrayList<String> listaP = x.select_Name_Actividades();
			while(contador != listaP.size()){
				//System.out.println(listaP.get(contador));
				
				if( listaOrdenada.isEmpty()){
					listaOrdenada.add(0, listaP.get(contador));
				}
				if(x.select_IDUsuarios_Actividad(listaP.get(contador)).size() > x.select_IDUsuarios_Actividad(listaOrdenada.get(0)).size()){
					listaOrdenada.add(0, listaP.get(contador));
				}
				else{
					listaOrdenada.add(listaP.get(contador));
				}
				contador++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Collections.reverse(listaOrdenada);
		return listaOrdenada;
		
	}
}
