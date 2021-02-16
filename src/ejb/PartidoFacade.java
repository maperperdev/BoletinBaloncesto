package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.Partido;

@Local
public interface PartidoFacade extends AbstractFacadeJPA<Partido> {
	public List<Partido> findAll();
}
