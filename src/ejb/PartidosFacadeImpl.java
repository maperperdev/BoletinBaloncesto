package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Partido;


@Stateless
public class PartidosFacadeImpl extends AbstractFacadeJPAImpl<Partido> implements PartidoFacade {

	@PersistenceContext(unitName = "Persistencia")
	private EntityManager em;
	
	public PartidosFacadeImpl() {
		super(Partido.class);
	}

	public List<Partido> findAll() {
		TypedQuery<Partido> query = em.createQuery("select p from Partido p", Partido.class);
		return query.getResultList();
	}

	@Override
	protected EntityManager getEm() {
		return em;
	}

}
