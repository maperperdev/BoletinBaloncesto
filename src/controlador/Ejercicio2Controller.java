package controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.JugadoreFacade;
import ejb.PartidoFacade;
import ejb.PartidoJugadoreFacade;
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
	
	private String codTemp;
	private String codJugador;
	private String codPartido;
	private String canastas;
	private String asistencias;
	private String rebotes;
	
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
		List<PartidosJugadore> listaPartidoJugador = partidoJugadoreFacade.jugadorTemporadaPartido(codJugador,
				codTemp, codPartido);
		System.out.println();
		if (listaPartidoJugador.size() > 0) {
			System.out.println("El jugador existe");
			partidoJugador = listaPartidoJugador.get(0);
			partidoJugador.setAsistencias(Integer.parseInt(asistencias));
			partidoJugador.setCanastas(Integer.parseInt(canastas));
			partidoJugador.setRebotes(Integer.parseInt(rebotes));
			partidoJugadoreFacade.update(partidoJugador);
			/*
			 * partidoFacade.update(new PartidosJugadore());
			 */
		} else {
			System.out.println("El jugador no existe");
		}
		
  
	}

	public String getCodTemp() {
		return codTemp;
	}

	public void setCodTemp(String codTemp) {
		this.codTemp = codTemp;
	}

	public String getCodJugador() {
		return codJugador;
	}

	public void setCodJugador(String codJugador) {
		this.codJugador = codJugador;
	}

	public String getCodPartido() {
		return codPartido;
	}

	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}

	public String getCanastas() {
		return canastas;
	}

	public void setCanastas(String canastas) {
		this.canastas = canastas;
	}

	public String getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(String asistencias) {
		this.asistencias = asistencias;
	}

	public String getRebotes() {
		return rebotes;
	}

	public void setRebotes(String rebotes) {
		this.rebotes = rebotes;
	}
	
}
