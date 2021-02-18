import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Usuario extends Publico{
	private int edad;
	private HashSet<String> generosFavoritos;
	public Usuario(String nombre, int edad) {
		super(nombre);
		this.edad = edad;
		this.generosFavoritos = new HashSet<String>();
		
	}

	@Override
	public HashSet<String> getGenerosPreferidos() {
		return (HashSet<String>) generosFavoritos.clone();
	}
	public void addGenero(String g) {
		generosFavoritos.add(g);
	}
	@Override
	public String toString() {
		return  "Usuario "+nombre;
	}

	@Override
	public boolean tienePublico(Publico p) {		
		return this.equals(p);
	}



	
}
