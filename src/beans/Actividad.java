package beans;

import java.util.ArrayList;
import java.util.Date;

public class Actividad {
	private String nombreActividad;
	private String tipoActividad;
	private Date fechaActividad;
	private String horaInicio;
	private String horaFinal;
	private String descripcionActividad;
	private ArrayList <Comentario> comentarios;
	private ArrayList <Usuario> encargados;
	
	public Actividad(String pNombreActividad, String pTipoActividad, Date pFechaActividad, String pHoraInicio, String pHoraFinal, String pDescripcionActividad){
		setNombreActividad(pNombreActividad);
		setTipoActividad(pTipoActividad);
		setFechaActividad(pFechaActividad);
		setHoraInicio(pHoraInicio);
		setHoraFinal(pHoraFinal);
		setDescripcionActividad(pDescripcionActividad);
		comentarios = new ArrayList<Comentario>();
	}
	
	public String registrarComentario(String pDescripcionComentario){
		Comentario comentario = new Comentario(pDescripcionComentario);
		comentarios.add(comentario);
		return "Comentario registrado";
	}
	
	public String registrarEncargado(Usuario pEncargado){
		encargados.add(pEncargado);
		return "Encargado registrado";
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
	public Date getFechaActividad() {
		return fechaActividad;
	}
	public void setFechaActividad(Date pFechaActividad) {
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
	
	
}
