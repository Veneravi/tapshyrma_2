package org.example.util;
import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class HibernateUtil {


    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.USER, "postgres");
                properties.put(Environment.PASS, "venera");
                properties.put(Environment.HBM2DDL_AUTO, "create");
                properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                properties.put(Environment.SHOW_SQL, true);
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Products.class);
                configuration.addAnnotatedClass(MusicInstrument.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Animals.class);
                configuration.addAnnotatedClass(Dog.class);
                configuration.addAnnotatedClass(Cat.class);
                configuration.addAnnotatedClass(Mouse.class);
                configuration.addAnnotatedClass(Car.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.getMessage();
            }
        }return sessionFactory;
    }


}
