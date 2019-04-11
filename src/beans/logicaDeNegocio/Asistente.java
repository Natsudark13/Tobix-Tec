package beans.logicaDeNegocio;

import javax.faces.bean.*;
@ManagedBean 
public class Asistente extends Usuario{
	private String contrasenaAsistente;
	private String entidadProcedencia;
	private String confirmacion;
	
	
	/*public Asistente (String pCedula, String pNombre, String pPrimerApellido, String pSegundoApellido, String pSexo, String pCorreo, String pContrasenaAsistente, String pEntidadProcedencia){
		//super (pCedula, pNombre, pPrimerApellido, pSegundoApellido, pSexo, pCorreo);
		super();
		setContrasenaAsistente(pContrasenaAsistente);
		setEntidadProcedencia(pEntidadProcedencia);
	}*/
	
	public Asistente(){
		super();
	}


	public String getContrasena() {
		return contrasenaAsistente;
	}


	public void setContrasenaAsistente(String pContrasenaAsistente) {
		this.contrasenaAsistente = pContrasenaAsistente;
	}


	public String getEntidadProcedencia() {
		return entidadProcedencia;
	}


	public void setEntidadProcedencia(String pEntidadProcedencia) {
		this.entidadProcedencia = pEntidadProcedencia;
	}
	
	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String pConfirmacion) {
		this.contrasenaAsistente = pConfirmacion;
	}
	
	public String ProcedenciaSeleccionada(){
		String seleccion="";
		switch(entidadProcedencia){
		
		case "Opcion1": seleccion="Académica";break;
		case "Opcion2": seleccion="Empresarial";break;
		case "Opcion3": seleccion="Participación personal";break;
		}
		return seleccion;
	}
	
	public void saludarUsuario(){
		String  saludoUsuario="Hola, " +nombre+"su usuario se ha registrado exitosamente";
		setConfirmacion(saludoUsuario);
	}
}
