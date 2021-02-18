import java.util.ArrayList;
import java.util.Collections;

public class AlgoritmoAlgunGenero implements AlgoritmoRecomendacion{

	@Override
	public ArrayList<Pelicula> getPosibles(Publico publico, ArrayList<Pelicula> pelis) {
		ArrayList<Pelicula>posibles= new ArrayList<Pelicula>();
		for(Pelicula peli:pelis) {
			for(String genero:publico.getGenerosPreferidos()) {
				if(peli.tieneGenero(genero)) {
					posibles.add(peli);
					break;
				}
			}
		}
		
		return posibles;
	}

	@Override
	public String toString() {
		return "que coincidan en algun genero";
	}
	
	
}
