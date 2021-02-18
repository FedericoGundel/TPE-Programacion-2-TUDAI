import java.util.Comparator;

public class OrdenPorPuntaje implements Comparator<Pelicula>{

	@Override
	public int compare(Pelicula o1, Pelicula o2) {	
		return o2.getPuntajePromedio().compareTo(o1.getPuntajePromedio());
	}
	public String toString() {
		return "con mayor puntaje";
	}
}
