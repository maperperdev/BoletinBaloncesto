package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.PartidosJugadore;


@Stateless
public class PartidosJugadoreFacadeImpl extends AbstractFacadeJPAImpl<PartidosJugadore> implements PartidoJugadoreFacade {

	@PersistenceContext(unitName = "Persistencia")
	private EntityManager em;
	
	public PartidosJugadoreFacadeImpl() {
		super(PartidosJugadore.class);
	}

	public List<PartidosJugadore> findAll() {
		TypedQuery<PartidosJugadore> query = em.createQuery("select pj from PartidoJugadore pj", PartidosJugadore.class);
		return query.getResultList();
	}

	@Override
	protected EntityManager getEm() {
		return em;
	}
	@Override
	public List<PartidosJugadore> jugadorTemporadaPartido(String codJugador, String codTemporada, String codPartido) {
		TypedQuery<PartidosJugadore> query = this.getEm().createQuery("select pj from PartidosJugadore pj where pj.jugadore.codjugador = "
				+ codJugador + " and pj.partido.temporadaBean.codtemp = " + codTemporada
				+ " and pj.partido.codpartido = " + codPartido, PartidosJugadore.class);
		return query.getResultList();
	}
	

}
