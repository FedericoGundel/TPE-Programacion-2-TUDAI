import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Sistema {
	private ArrayList<Pelicula> peliculas;
	private AlgoritmoRecomendacion algoritmo;
	private Comparator<Pelicula> formaOrdenamiento;
	public Sistema(AlgoritmoRecomendacion a, Comparator<Pelicula> c) {
		formaOrdenamiento = c;
		algoritmo = a;
		peliculas = new ArrayList<Pelicula>();
	}
	public ArrayList<Pelicula> buscarPelis(Criterio c){
		ArrayList<Pelicula> resultado = new ArrayList<Pelicula>();
		for(Pelicula p:peliculas) {
			if(c.cumple(p)) {
				resultado.add(p);
			}
		}
		return resultado;
	}
	
	public void setAlgoritmo(AlgoritmoRecomendacion algoritmo) {
		this.algoritmo = algoritmo;
	}

	public void setFormaOrdenamiento(Comparator<Pelicula> formaOrdenamiento) {
		this.formaOrdenamiento = formaOrdenamiento;
	}

	public void addPelicula(Pelicula p) {
		if(!peliculas.contains(p)) {
			peliculas.add(p);
		}	
	}
	public ArrayList<Pelicula>recomendar(Publico p,int k){
		ArrayList<Pelicula>noVio= new ArrayList<Pelicula>();
		for(Pelicula peli:peliculas) {
			if(!peli.laVio(p)) {
				noVio.add(peli);
			}
		}
		ArrayList<Pelicula>posibles = algoritmo.getPosibles(p, noVio);
		Collections.sort(posibles, formaOrdenamiento);
		ArrayList<Pelicula>recomendaciones = new ArrayList<Pelicula>();
		int aux = 0;
		for(Pelicula x:posibles) {
			if(aux==k) {
				break;
			}
			recomendaciones.add(x);
			aux++;		
		}
		return recomendaciones;
	}
	
	//estos metodos son para comprobar el funcionamiento en tiempo de ejecucion
	public void printRecomendados(Publico p,int k) {
		System.out.println("Pelis "+formaOrdenamiento+" "+algoritmo+" recomendadas para "+p);
		for(Pelicula peli:this.recomendar(p,k)) {
			System.out.println(peli);
		}
	}
	public void printBusqueda(Criterio c) {
		System.out.println("Pelis que coinciden con el criterio de busqueda: "+c);
		for(Pelicula peli:this.buscarPelis(c)) {
			System.out.println(peli);
		}
	}
	public void printPelisPorPublico(Publico p) {
		System.out.println("Peliculas que vio "+p);
		ListaPelisPorUsuario pelis = new ListaPelisPorUsuario(peliculas,p);
        while(pelis.hasNext())
            System.out.println(pelis.next());
	}
	
	public static void main(String[] args) {
		Usuario lisa = new Usuario("Lisa",12);
		lisa.addGenero("Romantico");
		lisa.addGenero("Musical");
		lisa.addGenero("Infantil");
		lisa.addGenero("Aventura");
		Usuario bart = new Usuario("Bart",13);
		bart.addGenero("Accion");
		bart.addGenero("Musical");
		bart.addGenero("Infantil");
		bart.addGenero("Aventura");
		Usuario maggie = new Usuario("Maggie",5);
		maggie.addGenero("Musical");
		maggie.addGenero("Infantil");
		maggie.addGenero("Aventura");
		Usuario marge = new Usuario("Marge",39);
		marge.addGenero("Romantico");
		marge.addGenero("Musical");
		marge.addGenero("Infantil");
		marge.addGenero("Aventura");
		Usuario homero = new Usuario("Homero",43);
		homero.addGenero("Accion");
		homero.addGenero("Musical");
		homero.addGenero("Infantil");
		Grupo hombres = new Grupo("Hombres Simpson");
		hombres.addIntegrante(bart);
		hombres.addIntegrante(homero);
		Grupo hermanos = new Grupo("Hermanos Simpson");
		hermanos.addIntegrante(bart);
		hermanos.addIntegrante(lisa);
		hermanos.addIntegrante(maggie);
		Grupo familia = new Grupo("Familia Simpson");
		familia.addIntegrante(homero);
		familia.addIntegrante(marge);
		familia.addIntegrante(hermanos);
		Pelicula up = new Pelicula("Up: una aventura de altura",2009);
		up.setSinopsis("Carl Fredricksen es un vendedor de globos de 78 años de edad dispuesto a cumplir su\r\n"
				+ "sueño: atar miles de globos a su casa y volar a Sudamérica. Sin embargo, descubre\r\n"
				+ "demasiado tarde a un joven e inesperado polizón. Lo que en principio será recelo,\r\n"
				+ "acabará por tornarse simpatía hacia el muchacho mientras juntos pasan fascinantes\r\n"
				+ "aventuras en exóticos lugares");
		up.addDirector("Pete Docter");
		up.addDirector("Bob Peterson");
		up.addActor("Pete Docter");
		up.addActor("Ed Asner");
		up.addActor("Bob Peterson");
		up.addActor("Jordan Nagai");
		up.addGenero("Infantil");
		up.addGenero("Accion");
		up.addGenero("Drama");
		
		Pelicula simpson = new Pelicula("Los Simpson: la película",2007);
		simpson.setSinopsis("La combinación de Homero (Dan Castellaneta), su nuevo puerco mascota, y un silo\r\n"
				+ "lleno de excremento podrían provocar un desastre que amenace no sólo a Springfield,\r\n"
				+ "sino al mundo entero. Una muchedumbre enojada llega a la casa de los Simpson,\r\n"
				+ "dividiendo a la familia. Con el destino de la Tierra en equilibrio, Homero se prepara\r\n"
				+ "para intentar redimirse con la intención de salvar al mundo y ganarse el perdón de\r\n"
				+ "Marge (Julie Kavner).");
		simpson.addDirector("David Silverman");
		simpson.addActor("Dan Castellaneta");
		simpson.addActor("Harry Shearer");
		simpson.addActor("Julie Kavner");
		simpson.addGenero("Romantico");
		simpson.addGenero("Musical");
		simpson.addGenero("Infantil");
		simpson.addGenero("Aventura");
		simpson.addGenero("Comedia");
		
		Pelicula increibles = new Pelicula("Los Increibles",2004);
		increibles.setSinopsis("Un súper héroe retirado lucha contra el aburrimiento en un suburbio y junto con su\r\n"
				+ "familia tiene la oportunidad de salvar al mundo.");
		increibles.addDirector("Brad Bird");
		increibles.addActor("Brad Bird");
		increibles.addActor("Craig T. Nelson");
		increibles.addActor("Holly Hunter");
		increibles.addGenero("Musical");
		increibles.addGenero("Infantil");
		increibles.addGenero("Aventura");
		increibles.addGenero("Accion");
		
		Pelicula increibles2 = new Pelicula("Los Increibles 2",2018);
		increibles2.setSinopsis("Helen entra en acción y debe luchar contra un cibercriminal que planea hipnotizar el\r\n"
				+ "mundo a través de las pantallas de las computadoras. Eso deja al Sr. Increíble con uno\r\n"
				+ "de sus mayores desafíos: quedarse en casa y cuidar de tres niños traviesos.");
		increibles2.addDirector("Brad Bird");
		increibles2.addActor("Brad Bird");
		increibles2.addActor("Craig T. Nelson");
		increibles2.addActor("Holly Hunter");
		increibles2.addGenero("Musical");
		increibles2.addGenero("Infantil");
		increibles2.addGenero("Aventura");
		increibles2.addGenero("Accion");
		
		Pelicula toyStory = new Pelicula("Toy Story",1995);
		toyStory.setSinopsis("Lo mejor de la animación computarizada produce esta historia sobre juguetes que\r\n"
				+ "cobran vida cuando su dueño se ausenta.");
		toyStory.addDirector("John Lasseter");
		toyStory.addActor("Tim Allen");
		toyStory.addActor("Tom Hanks");
		toyStory.addActor("Don Rickles");
		toyStory.addActor("Wallace Shawn");
		toyStory.addGenero("Infantil");
		toyStory.addGenero("Aventura");
		toyStory.addGenero("Accion");
		
		Pelicula montersInc = new Pelicula("Monsters Inc.",2001);
		montersInc.setSinopsis("Monsters, Incorporated es la fábrica de sustos más grande en el mundo de los\r\n"
				+ "monstruos y James P. Sullivan (John Goodman) es uno de sus mejores asustadores.\r\n"
				+ "Sullivan es un monstruo grande e intimidante de piel azul, grandes manchas color\r\n"
				+ "púrpura y cuernos. Su asistente, mejor amigo y compañero de cuarto es Mike\r\n"
				+ "Wazowski (Billy Crystal), un pequeño y alegre monstruo verde con un solo ojo. Boo\r\n"
				+ "(Mary Gibbs), una niña pequeña visita lugares en donde nunca antes había estado un\r\n"
				+ "ser humano");
		montersInc.addDirector("Pete Docter");
		montersInc.addActor("John Goodman");
		montersInc.addActor("Billy Crystal");
		montersInc.addActor("John Ratzenberger");
		montersInc.addGenero("Musical");
		montersInc.addGenero("Infantil");
		montersInc.addGenero("Aventura");
		montersInc.addGenero("Accion");
		
		Sistema s = new Sistema(new AlgoritmoTodosLosGeneros(),new OrdenPorPopularidad());
		s.addPelicula(up);
		s.addPelicula(simpson);
		s.addPelicula(increibles);
		s.addPelicula(montersInc);
		s.addPelicula(increibles2);
		s.addPelicula(toyStory);
		lisa.verPelicula(increibles, 5);
		bart.verPelicula(increibles, 2);
		homero.verPelicula(increibles, 4);
		marge.verPelicula(increibles, 2);
		marge.verPelicula(increibles2, 5);
		maggie.verPelicula(toyStory, 1);
		s.printPelisPorPublico(marge);
		s.printPelisPorPublico(bart);
		s.printRecomendados(lisa,2);
		s.printRecomendados(bart,2);
		s.printRecomendados(homero,2);
		s.printRecomendados(marge,2);
		s.printRecomendados(maggie,2);
		s.printRecomendados(hombres,2);
		s.printRecomendados(hermanos,2);
		s.printRecomendados(familia,2);
		s.setAlgoritmo(new AlgoritmoAlgunGenero());
		s.setFormaOrdenamiento(new OrdenPorPuntaje());
		s.printRecomendados(lisa,5);
		s.printRecomendados(bart,5);
		s.printRecomendados(homero,5);
		s.printRecomendados(marge,5);
		s.printRecomendados(maggie,5);
		s.printRecomendados(hombres,5);
		s.printRecomendados(hermanos,5);
		s.printRecomendados(familia,5);
		hermanos.verPelicula(up, 4);
		s.printPelisPorPublico(bart);
		s.setAlgoritmo(new AlgoritmoTodosLosGeneros());
		s.setFormaOrdenamiento(new OrdenPorPopularidad());
		s.printPelisPorPublico(marge);
		s.printPelisPorPublico(bart);
		s.printRecomendados(lisa,2);
		s.printRecomendados(bart,2);
		s.printRecomendados(homero,2);
		s.printRecomendados(marge,2);
		s.printRecomendados(maggie,2);
		s.printRecomendados(hombres,2);
		s.printRecomendados(hermanos,2);
		s.printRecomendados(familia,2);
		s.setAlgoritmo(new AlgoritmoAlgunGenero());
		s.setFormaOrdenamiento(new OrdenPorPuntaje());
		s.printRecomendados(lisa,5);
		s.printRecomendados(bart,5);
		s.printRecomendados(homero,5);
		s.printRecomendados(marge,5);
		s.printRecomendados(maggie,5);
		s.printRecomendados(hombres,5);
		s.printRecomendados(hermanos,5);
		s.printRecomendados(familia,5);
		s.printBusqueda(new CriterioAnd(new CriterioActor("Pete Docter"),new CriterioDirector("Pete Docter")));
		s.printBusqueda(new CriterioActor("Tom Hanks"));
		s.printBusqueda(new CriterioAñoMayor(2000));
		s.printBusqueda(new CriterioOr(new CriterioOr(new CriterioGenero("Romantico"),new CriterioGenero("Comedia")),new CriterioGenero("Drama")));
	

	}

}
