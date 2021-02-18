
public class Puntaje {
	private Publico espectador;
	private int puntaje;
	
	public Puntaje(Publico e,int i) {
		espectador = e;
		
		puntaje = i;
	}
	public Publico getEspectador() {
		return espectador;
	}
	public int getPuntaje() {
		return puntaje;
	}

	
}
