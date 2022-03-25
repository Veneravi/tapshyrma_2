package org.example.appAnimals;

import org.example.entity.Animals;

import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AppAnimals {


    public static int create (Animals animals){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(animals);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно "+animals);
        return animals.getId();
    }
    public static List<Animals> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Animals> animals = session.createQuery("FROM Animals ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + animals.size() + " animals ");
        return animals;
    }
    public static Animals getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Animals animals=session.get(Animals.class,id);
        session.getTransaction().commit();
        session.close();
        return animals;

    }
    public static void update(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Animals animals=session.get(Animals.class,id);
        animals.setName(name);
        animals.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Animals animals=session.get(Animals.class,id);
        session.delete(animals);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + animals);
    }
}
