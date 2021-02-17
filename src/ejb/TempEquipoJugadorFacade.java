package ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TempEquipoJugadorFacade {
	public List<Object[]> buscarEquipoSalario(String codjugador, String codtemp);
	public List<String> buscarJugadorCambioEquipo(String codtemp);
}
