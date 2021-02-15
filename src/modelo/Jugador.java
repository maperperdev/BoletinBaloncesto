package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the JUGADORES database table.
 * 
 */
@Entity
@Table(name="JUGADORES")
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODJUGADOR")
	private String codjugador;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHANAC")
	private Date fechanac;

	@Column(name="NOMBREJUGADOR")
	private String nombrejugador;

	//bi-directional many-to-one association to PartidosJugadores
	@OneToMany(mappedBy="jugadore")
	private List<PartidosJugadores> partidosJugadores;

	//bi-directional many-to-one association to TempEquipoJugador
	@OneToMany(mappedBy="jugadore")
	private List<TempEquipoJugador> tempEquipoJugadors;

	public Jugador() {
	}

	public String getCodjugador() {
		return this.codjugador;
	}

	public void setCodjugador(String codjugador) {
		this.codjugador = codjugador;
	}

	public Date getFechanac() {
		return this.fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getNombrejugador() {
		return this.nombrejugador;
	}

	public void setNombrejugador(String nombrejugador) {
		this.nombrejugador = nombrejugador;
	}

	public List<PartidosJugadores> getPartidosJugadores() {
		return this.partidosJugadores;
	}

	public void setPartidosJugadores(List<PartidosJugadores> partidosJugadores) {
		this.partidosJugadores = partidosJugadores;
	}

	public PartidosJugadores addPartidosJugadore(PartidosJugadores partidosJugadore) {
		getPartidosJugadores().add(partidosJugadore);
		partidosJugadore.setJugadore(this);

		return partidosJugadore;
	}

	public PartidosJugadores removePartidosJugadore(PartidosJugadores partidosJugadore) {
		getPartidosJugadores().remove(partidosJugadore);
		partidosJugadore.setJugadore(null);

		return partidosJugadore;
	}

	public List<TempEquipoJugador> getTempEquipoJugadors() {
		return this.tempEquipoJugadors;
	}

	public void setTempEquipoJugadors(List<TempEquipoJugador> tempEquipoJugadors) {
		this.tempEquipoJugadors = tempEquipoJugadors;
	}

	public TempEquipoJugador addTempEquipoJugador(TempEquipoJugador tempEquipoJugador) {
		getTempEquipoJugadors().add(tempEquipoJugador);
		tempEquipoJugador.setJugadore(this);

		return tempEquipoJugador;
	}

	public TempEquipoJugador removeTempEquipoJugador(TempEquipoJugador tempEquipoJugador) {
		getTempEquipoJugadors().remove(tempEquipoJugador);
		tempEquipoJugador.setJugadore(null);

		return tempEquipoJugador;
	}

}