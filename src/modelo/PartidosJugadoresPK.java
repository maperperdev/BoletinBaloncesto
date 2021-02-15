package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PARTIDOS_JUGADORES database table.
 * 
 */
@Embeddable
public class PartidosJugadoresPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODPARTIDO", insertable=false, updatable=false)
	private String codpartido;

	@Column(name="CODJUGADOR", insertable=false, updatable=false)
	private String codjugador;

	public PartidosJugadoresPK() {
	}
	public String getCodpartido() {
		return this.codpartido;
	}
	public void setCodpartido(String codpartido) {
		this.codpartido = codpartido;
	}
	public String getCodjugador() {
		return this.codjugador;
	}
	public void setCodjugador(String codjugador) {
		this.codjugador = codjugador;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PartidosJugadoresPK)) {
			return false;
		}
		PartidosJugadoresPK castOther = (PartidosJugadoresPK)other;
		return 
			this.codpartido.equals(castOther.codpartido)
			&& this.codjugador.equals(castOther.codjugador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codpartido.hashCode();
		hash = hash * prime + this.codjugador.hashCode();
		
		return hash;
	}
}