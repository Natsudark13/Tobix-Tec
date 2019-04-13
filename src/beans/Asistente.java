package beans;

public class Asistente extends Usuario{
	private String contrasenaAsistente;
	private String entidadProcedencia;
	
	
	public Asistente (String pCedula, String pNombre, String pPrimerApellido, String pSegundoApellido, String pSexo, String pCorreo, String pContrasenaAsistente, String pEntidadProcedencia){
		super (pCedula, pNombre, pPrimerApellido, pSegundoApellido, pSexo, pCorreo);
		setContrasenaAsistente(pContrasenaAsistente);
		setEntidadProcedencia(pEntidadProcedencia);
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
}
