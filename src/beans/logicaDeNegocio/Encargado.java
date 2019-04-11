package beans.logicaDeNegocio;

public class Encargado extends Usuario {
	private int experiencia;
	private String institucionProcedencia;
	
	
	public Encargado (String pCedula, String pNombre, String pPrimerApellido, String pSegundoApellido, String pSexo, String pCorreo, int pExperiencia, String pInstitucionProcedencia){
		super (pCedula, pNombre, pPrimerApellido, pSegundoApellido, pSexo, pCorreo);
		setExperiencia(pExperiencia);
		setInstitucionProcedencia(pInstitucionProcedencia);
	}


	public int getExperiencia() {
		return experiencia;
	}


	public void setExperiencia(int pExperiencia) {
		this.experiencia = pExperiencia;
	}


	public String getInstitucionProcedencia() {
		return institucionProcedencia;
	}


	public void setInstitucionProcedencia(String pInstitucionProcedencia) {
		this.institucionProcedencia = pInstitucionProcedencia;
	}
}
