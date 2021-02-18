import java.util.ArrayList;
import java.util.Collections;

public class AlgoritmoTodosLosGeneros implements AlgoritmoRecomendacion{
	@Override
	public ArrayList<Pelicula> getPosibles(Publico publico, ArrayList<Pelicula> pelis) {
		ArrayList<Pelicula>posibles= new ArrayList<Pelicula>();
		for(Pelicula peli:pelis) {	
			if (peli.tieneGeneros(publico.getGenerosPreferidos())) {
				posibles.add(peli);
			}		
		}		
		return posibles;
	}
	
	public String toString() {
		return "que coincidan en todos los generos";
	}
}
