package com.n1nt3nd0.demonew.servlet.database;

import com.n1nt3nd0.demonew.servlet.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DataBaseRepository {

    public List<Person>getPersonList(){
        SessionFactory sessionFactory;
        // configures settings from hibernate.cfg.xml
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            List<Person> list = session.createQuery("from Person", Person.class).list();
            list.stream().forEach(person-> System.out.println(person));
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            // handle the exception
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while fetch list person");
        }
    }

}
