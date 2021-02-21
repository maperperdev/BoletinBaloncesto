package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Jugadore;
import modelo.TempEquipoJugador;


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

	@Override
	public boolean existeJugadorTemporada(String codJugador, String codTemporada) {
		String queryStr = "select t from TempEquipoJugador t where t.jugadore.codjugador = '"
					+ codJugador + "' and t.temporada.codtemp = '" + codTemporada + "'";
		TypedQuery<TempEquipoJugador> query = this.getEm().createQuery(queryStr, TempEquipoJugador.class);
		return query.getResultList().size() > 0;
	}

	@Override
	public Jugadore findJugador(String codJugador) {
		TypedQuery<Jugadore> query = getEm().createQuery("select j from Jugadore j where j.codjugador = '" + codJugador + "'", Jugadore.class);
		List<Jugadore> resultados = query.getResultList();
		Jugadore jugador = null;
		jugador = resultados.get(0);
		return jugador;
	}

}
