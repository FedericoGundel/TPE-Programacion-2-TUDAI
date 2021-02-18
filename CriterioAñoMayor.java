
public class CriterioAñoMayor implements Criterio{
	private int año;

	public CriterioAñoMayor(int año) {	
		this.año = año;
	}

	@Override
	public boolean cumple(Pelicula p) {		
		return p.getAñoEstreno()>año;
	}
	public String toString() {
		return "Estrenada a partir del año " + año;
	}
	
	
}
