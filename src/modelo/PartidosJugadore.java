package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PARTIDOS_JUGADORES database table.
 * 
 */
@Entity
@Table(name="PARTIDOS_JUGADORES")
@NamedQuery(name="PartidosJugadore.findAll", query="SELECT p FROM PartidosJugadore p")
public class PartidosJugadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartidosJugadorePK id;

	@Column(name="ASISTENCIAS")
	private int asistencias;

	@Column(name="CANASTAS")
	private int canastas;

	@Column(name="REBOTES")
	private int rebotes;

	//bi-directional many-to-one association to Jugadore
	@ManyToOne
	@JoinColumn(name="CODJUGADOR")
	private Jugadore jugadore;

	//bi-directional many-to-one association to Partido
	@ManyToOne
	@JoinColumn(name="CODPARTIDO")
	private Partido partido;

	public PartidosJugadore() {
	}
	
	

	public PartidosJugadore(PartidosJugadorePK id, int asistencias, int canastas, int rebotes, Jugadore jugadore,
			Partido partido) {
		this.id = id;
		this.asistencias = asistencias;
		this.canastas = canastas;
		this.rebotes = rebotes;
		this.jugadore = jugadore;
		this.partido = partido;
	}

	public PartidosJugadore(int asistencias, int canastas, int rebotes, Jugadore jugadore,
			Partido partido) {
		this.asistencias = asistencias;
		this.canastas = canastas;
		this.rebotes = rebotes;
		this.jugadore = jugadore;
		this.partido = partido;
	}


	public PartidosJugadorePK getId() {
		return this.id;
	}

	public void setId(PartidosJugadorePK id) {
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

	public Jugadore getJugadore() {
		return this.jugadore;
	}

	public void setJugadore(Jugadore jugadore) {
		this.jugadore = jugadore;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}