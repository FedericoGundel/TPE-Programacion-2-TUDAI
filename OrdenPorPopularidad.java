import java.util.Comparator;

public class OrdenPorPopularidad implements Comparator<Pelicula>{
	@Override
	public int compare(Pelicula o1, Pelicula o2) {	
		return o2.getCantPuntajes()-o1.getCantPuntajes();
	}
	@Override
	public String toString() {
		return "mas populares";
	}
}
