package ejb;

import java.util.List;

import modelo.Jugador;

public interface JugadoresFacade extends AbstractFacadeJPA<Jugador> {
	public List<Jugador> findAll();
	public List<String> findAllNames();
}
