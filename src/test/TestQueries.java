package test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestQueries {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emfactory.createEntityManager();

//		TypedQuery<Object[]> query = emanager
//				.createQuery("select t.equipo.nombrequipo, t.tempEquipoJugadors.salario "
//						+ "from Equipo e, TempEquipoJugador t "
//						+ "where t.jugadore.codjugador = 'j1' "
//						+ "and t.temporada.codtemp = ''t1", Object[].class);
//		List<Object[]> resultados = query.getResultList();
		
		TypedQuery<Object[]> query = emanager
		.createQuery("select t "
				+ "from TempEquipoJugador t ", Object[].class);
		List<Object[]> resultados = query.getResultList();
		
		for (Object[] resultado : resultados) {
			System.out.println(Arrays.toString(resultado));
		}
	}
}