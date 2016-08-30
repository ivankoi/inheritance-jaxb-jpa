package com.ivankoi;

import com.ivankoi.domain.Organisation;
import com.ivankoi.domain.Person;
import com.ivankoi.domain.ResearchForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ivankoi on 8/30/16.
 */
public class JpaInheritanceTester {

    static EntityManagerFactory emf;
    EntityManager em;

    @BeforeClass
    public static void beforeClass() {
        emf = Persistence.createEntityManagerFactory("inheritance-test");
    }

    @Before
    public void before() {
        em = emf.createEntityManager();
    }

    @Test
    public void testEntityManagerCreation() {
        assertNotNull(em);

        em.createQuery("select p from Person p").getResultList();
    }

    @Test
    public void testPolimorfism() {
        em.getTransaction().begin();

        ResearchForm researchForm = new ResearchForm();
        researchForm.setAuthorisingParty(new Person("ivan", "ivankovic", "ivankoi@gmail.com"));
        em.persist(researchForm);

        researchForm = new ResearchForm();
        researchForm.setAuthorisingParty(new Organisation("Very good organisation", "ivankoi@gmail.com"));
        em.persist(researchForm);

        em.createQuery("select p from Party p").getResultList();

        em.getTransaction().commit();

    }
}
