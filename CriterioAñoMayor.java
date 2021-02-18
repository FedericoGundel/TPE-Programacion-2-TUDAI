
public class CriterioA�oMayor implements Criterio{
	private int a�o;

	public CriterioA�oMayor(int a�o) {	
		this.a�o = a�o;
	}

	@Override
	public boolean cumple(Pelicula p) {		
		return p.getA�oEstreno()>a�o;
	}
	public String toString() {
		return "Estrenada a partir del a�o " + a�o;
	}
	
	
}
