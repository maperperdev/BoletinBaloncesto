package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Jugador;

/**
 * Session Bean implementation class JugadoresFacadeImpl
 */
@Stateless
public class JugadoresFacadeImpl extends AbstractFacadeJPAImpl<Jugador> implements JugadoresFacade {

	@PersistenceContext(unitName = "Persistencia")
	private EntityManager em;

    public JugadoresFacadeImpl() {
    	super(Jugador.class);
    }

    @Override
    public List<Jugador> findAll() {
		TypedQuery<Jugador> q=getEm().createQuery("select j from Jugador j", Jugador.class);
		List<Jugador> lista=q.getResultList();
		return lista;
    }

	@Override
	protected EntityManager getEm() {
		return em;
	}

}
