package beans;
//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;


//@SuppressWarnings("deprecation")
@ManagedBean 
public class Usuario {
	protected int cedula;
	protected String nombre;
	protected String primerApellido;
	protected String segundoApellido;
	protected String sexo;
	protected String correo;

	public Usuario() {
		
	}
	
	public int getCedula() {
		return cedula;
	}

	public void setCedula(int pCedula) {
		this.cedula = pCedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String pPrimerApellido) {
		this.primerApellido = pPrimerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String pSegundoApellido) {
		this.segundoApellido = pSegundoApellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String pSexo) {
		this.sexo = pSexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String pCorreo) {
		this.correo = pCorreo;
	}
}
