
public class CriterioActor implements Criterio{
	private String actor;
	
	public CriterioActor(String actor) {
		this.actor = actor;
	}
	@Override
	public boolean cumple(Pelicula p) {
		return p.actua(actor);
	}
	@Override
	public String toString() {
		return "Que halla actuado " + actor;
	}

	

}
