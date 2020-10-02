package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		/*
		 //sempre que for uma operacao que nao seja consulta precisa transaction///excluir
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		*/
		
		System.out.println(p);
		em.close();
		emf.close();

	}

}
