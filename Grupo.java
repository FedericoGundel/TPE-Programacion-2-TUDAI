import java.util.ArrayList;
import java.util.HashSet;

public class Grupo extends Publico{
	private ArrayList<Publico>integrantes;

	public Grupo(String nombre) {
		super(nombre);
		this.integrantes = new ArrayList<Publico>();
	}
	
	public void addIntegrante(Publico p) {
		integrantes.add(p);
	}

	@Override
	public HashSet<String> getGenerosPreferidos() {
		HashSet<String>favoritos = new HashSet<String>();
		for(Publico p:integrantes) {
			favoritos.addAll(p.getGenerosPreferidos());
		}
		return favoritos;
	}
	@Override
	public String toString() {
		return  "Grupo "+nombre;
	}


	@Override
	public boolean tienePublico(Publico p) {
		if(this.equals(p))return true;
		for(Publico i:integrantes) {
			if(i.tienePublico(p))return true;
		}
		return false;
	}
	
}
