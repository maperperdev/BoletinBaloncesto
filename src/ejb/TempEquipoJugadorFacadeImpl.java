package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.TempEquipoJugador;


@Stateless
public class TempEquipoJugadorFacadeImpl extends AbstractFacadeJPAImpl<TempEquipoJugador> implements TempEquipoJugadorFacade {

	@PersistenceContext(unitName = "Persistencia")
	private EntityManager em;
	
	public TempEquipoJugadorFacadeImpl() {
		super(TempEquipoJugador.class);
	}

	@Override
	public List<Object[]> buscarEquipoSalario(String codjugador, String codtemp) {
		String query = "select t.equipo.nombrequipo, t.salario "
					+ "from TempEquipoJugador t "
					+ "where t.jugadore.codjugador = '" + codjugador + "' "
					+ "and t.temporada.codtemp = '" + codtemp + "'";
		System.out.println(query);
		TypedQuery<Object[]> listaEquiposSalarios = this.em.createQuery(query, Object[].class);
		return listaEquiposSalarios.getResultList();
	}

	@Override
	protected EntityManager getEm() {
		return em;
	}

	@Override
	public List<String> buscarJugadorCambioEquipo(String codtemp) {
		String query = "select t.jugadore.nombrejugador "
				+ "from TempEquipoJugador t "
				+ "where t.temporada.codtemp = '" + codtemp + "' "
				+ "group by t.jugadore.codjugador "
				+ "having count(t.jugadore.codjugador) > 1";
		System.out.println(query);
		TypedQuery<String> listaJugadoresCambioEquipo = this.em.createQuery(query, String.class);
		return listaJugadoresCambioEquipo.getResultList();
	}
	
}