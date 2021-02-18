import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaPelisPorUsuario implements Iterator<Pelicula>{
	private Publico p;
	private ArrayList<Pelicula> pelis;
	private int pos = 0;
	public ListaPelisPorUsuario(ArrayList<Pelicula> pelis, Publico p) {
		this.p = p;
		this.pelis = pelis;
	}
	@Override
	public boolean hasNext() {
        while(pos < pelis.size()){
            if (pelis.get(pos).laVio(p))
                return true;
            pos++;
        }
		return false;
	}
	@Override
	public Pelicula next() {
        if (hasNext())
            return pelis.get(pos++);
        throw new NoSuchElementException();
	}
	
}
