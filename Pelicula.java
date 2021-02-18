import java.util.ArrayList;
import java.util.HashSet;

public class Pelicula {
	private String titulo;
	private int añoEstreno;
	private String sinopsis;
	private int duracion;
	private ArrayList<String> actores;
	private ArrayList<String> directores;
	private HashSet<String> categorias;
	private HashSet<Puntaje> puntajes;
	public Pelicula(String titulo, int añoEstreno) {
		this.titulo = titulo;
		this.añoEstreno = añoEstreno;
		this.actores = new ArrayList<String>();
		this.directores = new ArrayList<String>();
		this.categorias = new HashSet<String>();
		this.puntajes = new HashSet<Puntaje>();
	}
	public boolean laVio(Publico u) {
		for(Puntaje p:puntajes) {
			if(p.getEspectador().tienePublico(u)) {
				return true;
			}
		}
		return false;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public void addDirector(String d) {
		directores.add(d);
	}
	public void addActor(String a) {
		actores.add(a);
	}

	public void addPuntaje(Publico pub,int pun) {
		if((pun>0)&&(pun<=5)) {
			puntajes.add(new Puntaje(pub,pun));
		}
	}
	public int getCantPuntajes() {
		return puntajes.size();
	}
	public Comparable getPuntajePromedio() {
		int cant = puntajes.size();
		int suma = 0;
		if(cant!=0) {
			for(Puntaje p:puntajes) {
				suma+=p.getPuntaje();
			}
			return suma/cant;
		}
		else return 0;		
	}
	public String getTitulo() {
		return titulo;
	}
	public boolean actua(String a) {
		return actores.contains(a);
	}
	
	public int getAñoEstreno() {
		return añoEstreno;
	}
	public boolean dirige(String d) {
		return directores.contains(d);
	}
	public boolean tieneGenero(String g) {
		return categorias.contains(g);
	}
	public boolean tieneGeneros(HashSet<String> g) {
		return categorias.containsAll(g);
	}
	public void addGenero(String g) {
		categorias.add(g);
	}
	@Override
	public String toString() {
		return  titulo+":\r\n"
				//+sinopsis+"\r\n"
				+"Vistas:"+this.getCantPuntajes()+"\r\n"
				+"Puntaje Promedio: "+this.getPuntajePromedio();//+"\r\n"
				//+"Directores: "+directores+"\r\n"
				//+"Año: "+añoEstreno+"\r\n"
				//+"Actores: "+actores+"\r\n"
				//+"Generos: "+categorias;
	}
	@Override
	public boolean equals(Object obj) {
		Pelicula peli = (Pelicula)obj;
		try {
			return peli.getTitulo().equals(titulo);
		}catch(Exception e) {
			return false;
		}
	}
	
}
