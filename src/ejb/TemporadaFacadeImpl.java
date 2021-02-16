package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.Temporada;


@Stateless
public class TemporadaFacadeImpl extends AbstractFacadeJPAImpl<Temporada> implements TemporadaFacade {

	@PersistenceContext(unitName = "Persistencia")
	private EntityManager em;
	
	public TemporadaFacadeImpl() {
		super(Temporada.class);
	}

	public List<Temporada> findAll() {
		TypedQuery<Temporada> query = em.createQuery("select t from Temporada t", Temporada.class);
		return query.getResultList();
	}

	@Override
	protected EntityManager getEm() {
		return em;
	}

}
