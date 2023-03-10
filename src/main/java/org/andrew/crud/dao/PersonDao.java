package org.andrew.crud.dao;

import org.andrew.crud.models.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDao {

    private final EntityManager entityManager;

    @Autowired
    public PersonDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1(){
        Session session = entityManager.unwrap(Session.class);

//        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();
//
//        for (Person person : people){
//            System.out.println("Person " + person.getName() + " has: " + person.getItems());
//        }


//      List<Person> people = session.createQuery("select p from Person p left join fetch p.items").getResultList();
        Set<Person> people1 = new HashSet<>(session.createQuery("select p from Person p left join fetch p.items").
                getResultList());

        for (Person person : people1){
            System.out.println("Person " + person.getName() + " has: " + person.getItems());
        }
    }
}
