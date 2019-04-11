package beans.logicaDeNegocio;

public class Comentario {
	private String descripcionComentario;
	
	public Comentario(String pDescripcionComentario){
		setDescripcionComentario(pDescripcionComentario);
	}

	public String getDescripcionComentario() {
		return descripcionComentario;
	}

	public void setDescripcionComentario(String pDescripcionComentario) {
		this.descripcionComentario = pDescripcionComentario;
	}
}
