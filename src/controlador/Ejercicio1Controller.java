package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ejb.JugadoreFacade;
import ejb.TempEquipoJugadorFacade;
import ejb.TemporadaFacade;
import modelo.Jugadore;
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
	private List<String[]> resultadosArray;
	private List<String> resultadosArray2;
	
	
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


	public String buscarEquipoSalario() {
		String mensajeError = "";
		if (codJugador == null) {
			mensajeError += "No ha seleccionado el nombre del jugador. ";
		}
		if (codTemp == null) {
			mensajeError += "No ha seleccionado el nombre de la temporada.";
		}
		List<Object[]> resultados1 = tempEquipoJugadorFacade.buscarEquipoSalario(codJugador, codTemp);
		if (resultados1.size() > 0) {
			System.out.println("Jugador encontrado");
			resultadosArray = new ArrayList<>();
			for (Object[] resultado : resultados1) {
				String[] array = {resultado[0] + "", resultado[1] + ""};
				resultadosArray.add(array);
				System.out.println("Nombre de equipo: " + resultado[0] + ", Salario: " + resultado[1]);
			}
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("resultadosArray", resultadosArray);
			return "resultado1";
		} else {
			if (mensajeError.length() > 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensajeError, "Info"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Jugador no encontrado en la temporada elegida", "Error"));
			}
			return null;
		}
	}

	public String buscarJugadoresCambioEquipo() {
		String mensajeError = "";
		if (codTemp2 == null) {
			mensajeError += "No ha seleccionado el nombre de la temporada.";
		}
		List<String> resultados = tempEquipoJugadorFacade.buscarJugadorCambioEquipo(codTemp2);
		resultadosArray2 = new ArrayList<>();
		if (resultados.size() > 0) {
			System.out.println("Jugador encontrado");
			for (String resultado : resultados) {
				resultadosArray2.add(resultado);
				System.out.println("Nombre del jugador que cambia de equipo: " + resultado);
			}
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("resultadosArray2", resultadosArray2);
		return "resultado2";
		} else {
			System.out.println("Jugador no encontrado");
			if (mensajeError.length() > 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajeError, "Error"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"El jugador elegido no ha cambiado de equipo en la temporada elegida", "Info"));
			}
		}
		return "ejercicio1";
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

	public List<String[]> getResultadosArray() {
		return resultadosArray;
	}

	public void setResultadosArray(List<String[]> resultadosArray) {
		this.resultadosArray = resultadosArray;
	}
}
