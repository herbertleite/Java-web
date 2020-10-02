package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import dominio.department;

public class Programa2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		department d = em.find(department.class, 2);
	System.out.println(d);
		
		/*
		 //sempre que for uma operacao que nao seja consulta precisa transaction///excluir
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		*/
		
		em.close();
		emf.close();

	}

}
