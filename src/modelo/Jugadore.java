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
@NamedQuery(name="Jugadore.findAll", query="SELECT j FROM Jugadore j")
public class Jugadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODJUGADOR")
	private String codjugador;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHANAC")
	private Date fechanac;

	@Column(name="NOMBREJUGADOR")
	private String nombrejugador;

	//bi-directional many-to-one association to PartidosJugadore
	@OneToMany(mappedBy="jugadore")
	private List<PartidosJugadore> partidosJugadores;

	//bi-directional many-to-one association to TempEquipoJugador
	@OneToMany(mappedBy="jugadore")
	private List<TempEquipoJugador> tempEquipoJugadors;

	public Jugadore() {
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

	public List<PartidosJugadore> getPartidosJugadores() {
		return this.partidosJugadores;
	}

	public void setPartidosJugadores(List<PartidosJugadore> partidosJugadores) {
		this.partidosJugadores = partidosJugadores;
	}

	public PartidosJugadore addPartidosJugadore(PartidosJugadore partidosJugadore) {
		getPartidosJugadores().add(partidosJugadore);
		partidosJugadore.setJugadore(this);

		return partidosJugadore;
	}

	public PartidosJugadore removePartidosJugadore(PartidosJugadore partidosJugadore) {
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