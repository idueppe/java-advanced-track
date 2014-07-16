package io.crowdcode.ejb.jpa;

import io.crowdcode.scrumr.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class SimpleJpaTest {

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		for (int i = 1; i < 11; i++) {
			em.persist(new Project().withTitle("project no " + i));
		}
		em.getTransaction().commit();
	}

}
