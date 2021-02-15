package controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Inject;

import ejb.JugadoresFacade;
import modelo.Jugador;

public class Ejercicio2Controller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Jugador jugador;
	
	@EJB
	private JugadoresFacade jugadorEJB;

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public JugadoresFacade getJugadorEJB() {
		return jugadorEJB;
	}
	
	public void setJugadorEJB(JugadoresFacade jugadorEJB) {
		this.jugadorEJB = jugadorEJB;
	}
	

}
