import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Publico {
	protected String nombre;
	public Publico(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public boolean equals(Object obj) {
		Publico u = (Publico)obj;
		try {
			return u.getNombre().equals(nombre);
		}catch(Exception e) {
			return false;
		}
	}
	public abstract HashSet<String>getGenerosPreferidos();
	public abstract boolean tienePublico(Publico p);
	public void verPelicula(Pelicula peli, int puntaje) {
		peli.addPuntaje(this, puntaje);
	}
	

}
