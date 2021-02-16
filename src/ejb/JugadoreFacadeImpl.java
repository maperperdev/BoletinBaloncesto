package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Jugadore;


@Stateless
public class JugadoreFacadeImpl extends AbstractFacadeJPAImpl<Jugadore> implements JugadoreFacade {

	@PersistenceContext(unitName = "Persistencia")
	private EntityManager em;
	
	public JugadoreFacadeImpl() {
		super(Jugadore.class);
	}

	public List<Jugadore> findAll() {
		TypedQuery<Jugadore> query = em.createQuery("select j from Jugadore j", Jugadore.class);
		return query.getResultList();
	}

	@Override
	protected EntityManager getEm() {
		return em;
	}

}
