package controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.JugadoreFacade;
import ejb.TempEquipoJugadorFacade;
import ejb.TemporadaFacade;
import modelo.Jugadore;
import modelo.PartidosJugadore;
import modelo.Temporada;

@Named
@ViewScoped
public class Ejercicio1Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private JugadoreFacade jugadoreFacade;
	
	@EJB
	private TemporadaFacade temporadaFacade;
	
	@EJB
	private TempEquipoJugadorFacade tempEquipoJugadorFacade;
	
	private String codTemp;
	private String codTemp2;
	private String codJugador;
	
	
	private List<Jugadore> listaJugadores;
	private List<Temporada> listaTemporadas;
	
	
	
	@PostConstruct
	public void init() {
		listaJugadores = jugadoreFacade.findAll();
		listaTemporadas = temporadaFacade.findAll();
	}

	public JugadoreFacade getJugadoreFacade() {
		return jugadoreFacade;
	}

	public void setJugadoreFacade(JugadoreFacade jugadoreFacade) {
		this.jugadoreFacade = jugadoreFacade;
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


	public void buscarEquipoSalario() {
		List<Object[]> resultados = tempEquipoJugadorFacade.buscarEquipoSalario(codJugador, codTemp);
		if (resultados.size() > 0) {
			System.out.println("Jugador encontrado");
			for (Object[] resultado : resultados) {
				System.out.println("Nombre de equipo: " + resultado[0] + ", Salario: " + resultado[1]);
			}
		} else {
			System.out.println("Jugador no encontrado");
		}
	}

	public void buscarJugadoresCambioEquipo() {
		List<String> resultados = tempEquipoJugadorFacade.buscarJugadorCambioEquipo(codTemp2);
		if (resultados.size() > 0) {
			System.out.println("Jugador encontrado");
			for (String resultado : resultados) {
				System.out.println("Nombre del jugador chaquetero: " + resultado);
			}
		} else {
			System.out.println("Jugador no encontrado");
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

	public String getCodTemp2() {
		return codTemp2;
	}

	public void setCodTemp2(String codTemp2) {
		this.codTemp2 = codTemp2;
	}
	
	
	
}
