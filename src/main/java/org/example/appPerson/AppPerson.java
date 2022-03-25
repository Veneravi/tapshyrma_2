package org.example.appPerson;
import org.example.entity.Person;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class AppPerson {


    public static int create (Person person){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно"+person);
        return person.getId();
    }
    public static List<Person> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Person> person = session.createQuery("FROM Person ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + person.size() + " person ");
        return person;
    }
    public static Person getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person=session.get(Person.class,id);
        session.getTransaction().commit();
        session.close();
        return person;

    }
    public static void update(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person=session.get(Person.class,id);
        person.setName(name);
        person.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person=session.get(Person.class,id);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + person);
    }
}
