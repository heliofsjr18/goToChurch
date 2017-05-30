package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteMainClass {

	//public static void main(String[] args) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("goToChurchUnit");
		//EntityManager em = emf.createEntityManager();		
		//em.close();
	//}

}