package app;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Pelicula;


public class JPATest01 {

	public static void main(String[] args) {
		// Creamos el objeto Entidad
		Pelicula p = new Pelicula();
		p.setCodigo(3);
		p.setNompeli("El Conejo Sin Suerte");
		p.setGenero("Tragedia");
		p.setFestreno("2001/02/08");
		p.setSinopsis("Un conejo come una zanahoria radioctiva pero las cosas no saldran como él esperaba.");
		p.setActores("Pablo Panduro, Pedro Puente, Juan Jara");
		
		// Creamos el em
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("DAWI_CL1_CHAMORRO_VALDERRAMA_PIERO_ALEXIS");
		EntityManager em = fabrica.createEntityManager();
				
		// empiezo una transacción
		em.getTransaction().begin();
		//se encarga de grabar
		em.merge(p);
		// confirmo
		em.getTransaction().commit();
		
		/*
		// PREGUNTA 3
		TypedQuery<Pelicula>  listarActoresPorNombreDePelicula = em.createNamedQuery("findxNpeli", Pelicula.class); 
		 listarActoresPorNombreDePelicula.setParameter("xnomp", "Súper Cat");
		List<Pelicula> lista =  listarActoresPorNombreDePelicula.getResultList();
		
		for (Pelicula p : lista) {
			System.out.println("-------------------------------");
			System.out.println("PREGUNTA 3");
			System.out.println("-------------------------------");
			System.out.println("PELICULA: " + p.getNompeli());
			System.out.println("ACTORES: " +p.getActores() + ".");
		}
		*/
	}

}
