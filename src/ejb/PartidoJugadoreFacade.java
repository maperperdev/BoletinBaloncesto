package ejb;

import java.util.List;

import javax.ejb.Local;

import modelo.PartidosJugadore;

@Local
public interface PartidoJugadoreFacade extends AbstractFacadeJPA<PartidosJugadore> {
	public List<PartidosJugadore> findAll();
	public List<PartidosJugadore> jugadorTemporadaPartido(String codJugador, String codTemporada, String codPartido);
}
