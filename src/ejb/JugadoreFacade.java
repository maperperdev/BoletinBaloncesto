package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.Jugadore;

@Local
public interface JugadoreFacade extends AbstractFacadeJPA<Jugadore> {
	public List<Jugadore> findAll();
}
