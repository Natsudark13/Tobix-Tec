package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import conexion.CRUD;
@ManagedBean
@ViewScoped
public class Actividad {
	private String nombreActividad;
	private String tipoActividad;
	private String fechaActividad;
	private String horaInicio;
	private String horaFinal;
	private String descripcionActividad;
	private int cantComentarios;
	private ArrayList <Comentario> comentarios;
	private ArrayList <Usuario> encargados;
	private ArrayList <String> nombresA;
	private DataModel<Actividad> nombreActividadesModel;
	
	public Actividad(String pNombreActividad, String pTipoActividad, String pFechaActividad, String pHoraInicio, String pHoraFinal, String pDescripcionActividad, int pCantidadComentarios){
		setNombreActividad(pNombreActividad);
		setTipoActividad(pTipoActividad);
		setFechaActividad(pFechaActividad);
		setHoraInicio(pHoraInicio);
		setHoraFinal(pHoraFinal);
		setDescripcionActividad(pDescripcionActividad);
		setCantidadComentarios(pCantidadComentarios);
		
		//comentarios = new ArrayList<Comentario>();
	}
	
	public Actividad(String pNombreActividad, int pCantComentarios) {
		setNombreActividad(pNombreActividad);
		setCantidadComentarios(pCantComentarios);
	}
	
	public Actividad() {
		CRUD crud = new CRUD();
		try {
			this.nombresA = crud.select_Name_Actividades();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public ArrayList<String> getNombresA() {
		return nombresA;
	}

	public void setNombresA(ArrayList<String> nombresA) {
		this.nombresA = nombresA;
	}

	public void registrarActividad() throws SQLException {
		CRUD crud = new CRUD();
		crud.insertActivity(tipoActividad, nombreActividad, fechaActividad, horaInicio, horaFinal, descripcionActividad);
	}
	
	public void registrarActividad_Bloque(String topic) throws SQLException {
		CRUD crud = new CRUD();
		crud.insertBlockActivity(nombreActividad, topic);
	}
	
	public void registrarActividad_Asistente(int id) throws SQLException {
		CRUD crud = new CRUD();
		crud.insertUserActivity(id,nombreActividad);
	}
	
	public void registrarActividad_Encargado(int id) throws SQLException {
		CRUD crud = new CRUD();
		crud.insertSupervisorActivity(id, nombreActividad);
	}
	
	public void cargarComentarios() throws SQLException{
		Comentario comentario = new Comentario();
		int contador = 0;
		while(comentario.verComentarios(nombreActividad).size() != contador) {
		comentarios.add(new Comentario(comentario.verComentarios(nombreActividad).get(contador)));
		contador++;
		}
	}
	
	public void ContarComentarios()throws SQLException{
		
	}
	
	public ArrayList<String> listaActividadesPorComentarios(){
		CRUD x = new CRUD();
		int contador = 0;
		ArrayList<String> listaOrdenada = new ArrayList<>();
		try {
			ArrayList<String> listaP = x.select_Name_Actividades();
			while(contador != listaP.size()){
				//System.out.println(listaP.get(contador));
				
				if( listaOrdenada.isEmpty()){
					listaOrdenada.add(0, listaP.get(contador));
				}
				else {
					if(x.select_Comments_Actividad(listaP.get(contador)).size() > x.select_Comments_Actividad(listaOrdenada.get(0)).size() ){
						listaOrdenada.add(0, listaP.get(contador));
					}
					else{
						listaOrdenada.add(listaP.get(contador));
					}
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
		CRUD x = new CRUD();
		int contador = 0;
		ArrayList<String> listaOrdenada = new ArrayList<>();
		try {
			ArrayList<String> listaP = x.select_Name_Actividades();
			while(contador != listaP.size()){
				//System.out.println(listaP.get(contador));
				
				if( listaOrdenada.isEmpty()){
					listaOrdenada.add(0, listaP.get(contador));
				}
				else {
				if(x.select_IDUsuarios_Actividad(listaP.get(contador)).size() > x.select_IDUsuarios_Actividad(listaOrdenada.get(0)).size()){
					listaOrdenada.add(0, listaP.get(contador));
				}
				else{
					listaOrdenada.add(listaP.get(contador));
				}
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
	
	public void registrarEncargado(Usuario pEncargado){
		encargados.add(pEncargado);
	}
	
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public ArrayList<Usuario> getEncargados() {
		return encargados;
	}

	public void setEncargados(ArrayList<Usuario> encargados) {
		this.encargados = encargados;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String pNombreActividad) {
		this.nombreActividad = pNombreActividad;
	}
	public String getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(String pTipoActividad) {
		this.tipoActividad = pTipoActividad;
	}
	public String getFechaActividad() {
		return fechaActividad;
	}
	public void setFechaActividad(String pFechaActividad) {
		this.fechaActividad = pFechaActividad;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String pHoraInicio) {
		this.horaInicio = pHoraInicio;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String pHoraFinal) {
		this.horaFinal = pHoraFinal;
	}
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	public void setDescripcionActividad(String pDescripcionActividad) {
		this.descripcionActividad = pDescripcionActividad;
	}
	
	
	public DataModel<Actividad> getNombreActividadesModel() { 
			return nombreActividadesModel; 
	}
	
	public void setNombreActividadesModel(DataModel<Actividad> actividades) { 
		this.nombreActividadesModel = actividades; 
	}
	
	public void setCantidadComentarios(int pCantComentarios) {
		this.cantComentarios = pCantComentarios; 
	}
	
	public int getCantidadComentarios() {
		return this.cantComentarios;
	}
	
}
