
public class CriterioDirector implements Criterio{
	private String director;

	public CriterioDirector(String director) {
		this.director = director;
	}

	@Override
	public boolean cumple(Pelicula p) {
		return p.dirige(director);
	}
	public String toString() {
		return "Dirigida por " + director;
	}
	

}