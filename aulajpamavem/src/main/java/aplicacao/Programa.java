package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		//tem que colocar o id nulo pq o proprio bdd vai implementar pra elas
		Pessoa p1 = new Pessoa(null,"Carlos da Silva","Carlos@gmail.com");
		Pessoa p2 = new Pessoa(null,"Ana maria","Ana@gmail.com");
		Pessoa p3 = new Pessoa(null,"Jose Carlos","Jose@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto");
		em.close();
		emf.close();

	}

}
