package beans;

import java.util.ArrayList;

public class TOB {
	private String edicion;
	private ArrayList <Usuario> usuarios;
	private ArrayList <Bloque> bloques;
	
	public TOB (String pEdicion){
		setEdicion(pEdicion);
	}
	
	public String registrarBloque(Bloque pBloque){
		bloques.add(pBloque);
		return "Bloque registrado";
	}
	
	public String registrarUsuario(Usuario pUsuario){
		usuarios.add(pUsuario);
		return "Usuario registrado";
	}
	
	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String pEdicion) {
		edicion = pEdicion;
	}
}
