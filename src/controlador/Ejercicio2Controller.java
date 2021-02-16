package controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import ejb.JugadoreFacade;
import ejb.PartidoFacade;
import ejb.PartidoJugadoreFacade;
import ejb.PartidosFacadeImpl;
import ejb.PartidosJugadoreFacadeImpl;
import ejb.TemporadaFacade;
import modelo.Jugadore;
import modelo.Partido;
import modelo.PartidosJugadore;
import modelo.Temporada;

@Named
@ViewScoped
public class Ejercicio2Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private JugadoreFacade jugadoreFacade;
	
	@EJB
	private TemporadaFacade temporadaFacade;
	
	@EJB
	private PartidoFacade partidoFacade;
	
	@EJB
	private PartidoJugadoreFacade partidoJugadoreFacade;
	
	@Inject
	private Jugadore jugadore;
	
	@Inject
	private Temporada temporada;
	
	@Inject
	private Partido partido;
	
	@Inject
	private PartidosJugadore partidoJugador;
	
	
	private List<Jugadore> listaJugadores;
	private List<Temporada> listaTemporadas;
	private List<Partido> listaPartidos;
	
	
	
	@PostConstruct
	public void init() {
		listaJugadores = jugadoreFacade.findAll();
		listaTemporadas = temporadaFacade.findAll();
		listaPartidos = partidoFacade.findAll();
	}

	public JugadoreFacade getJugadoreFacade() {
		return jugadoreFacade;
	}

	public void setJugadoreFacade(JugadoreFacade jugadoreFacade) {
		this.jugadoreFacade = jugadoreFacade;
	}
	
	public PartidosJugadore getPartidoJugador() {
		return partidoJugador;
	}

	public void setPartidoJugador(PartidosJugadore partidoJugador) {
		this.partidoJugador = partidoJugador;
	}

	public List<Jugadore> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugadore> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public Jugadore getJugadore() {
		return jugadore;
	}

	public void setJugadore(Jugadore jugadore) {
		this.jugadore = jugadore;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public List<Temporada> getListaTemporadas() {
		return listaTemporadas;
	}

	public void setListaTemporadas(List<Temporada> listaTemporadas) {
		this.listaTemporadas = listaTemporadas;
	}

	public List<Partido> getListaPartidos() {
		return listaPartidos;
	}

	public void setListaPartidos(List<Partido> listaPartidos) {
		this.listaPartidos = listaPartidos;
	}

	public void insertaJugador() {
		List<PartidosJugadore> listaPartidoJugador = partidoJugadoreFacade.jugadorTemporadaPartido(jugadore.getCodjugador(),
				temporada.getCodtemp(), partido.getCodpartido());
		
		if (listaPartidoJugador.size() > 0) {
			System.out.println("El jugador existe");
		} else {
			System.out.println("El jugador no existe");
		}
		
		
		
		  
	}
	
}
