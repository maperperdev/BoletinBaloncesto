package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PARTIDOS_JUGADORES database table.
 * 
 */
@Entity
@Table(name="PARTIDOS_JUGADORES")
@NamedQuery(name="PartidosJugadores.findAll", query="SELECT p FROM PartidosJugadores p")
public class PartidosJugadores implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartidosJugadoresPK id;

	@Column(name="ASISTENCIAS")
	private int asistencias;

	@Column(name="CANASTAS")
	private int canastas;

	@Column(name="REBOTES")
	private int rebotes;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	@JoinColumn(name="CODJUGADOR")
	private Jugador jugadore;

	//bi-directional many-to-one association to Partido
	@ManyToOne
	@JoinColumn(name="CODPARTIDO")
	private Partido partido;

	public PartidosJugadores() {
	}

	public PartidosJugadoresPK getId() {
		return this.id;
	}

	public void setId(PartidosJugadoresPK id) {
		this.id = id;
	}

	public int getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getCanastas() {
		return this.canastas;
	}

	public void setCanastas(int canastas) {
		this.canastas = canastas;
	}

	public int getRebotes() {
		return this.rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	public Jugador getJugadore() {
		return this.jugadore;
	}

	public void setJugadore(Jugador jugadore) {
		this.jugadore = jugadore;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}