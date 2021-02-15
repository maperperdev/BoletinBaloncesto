package controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.JugadoresFacade;
import modelo.Jugador;

@Named
@ViewScoped
public class Ejercicio2Controller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Jugador jugador;
	
	@EJB
	private JugadoresFacade jugadorEJB;
	
	private List<Jugador> listaJugadores;
	
	@PostConstruct
	public void init() {
		this.listaJugadores = jugadorEJB.findAll();		
	}

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
	
	
	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	

}
