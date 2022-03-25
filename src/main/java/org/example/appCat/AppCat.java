package org.example.appCat;

import org.example.entity.Cat;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AppCat {


    public static int create (Cat cat){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cat);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно "+cat);
        return cat.getId();
    }
    public static List<Cat> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Cat> cats = session.createQuery("FROM Cat ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + cats.size() + " cat ");
        return cats;
    }
    public static Cat getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cat cat=session.get(Cat.class,id);
        session.getTransaction().commit();
        session.close();
        return cat;

    }
    public static void update(int id, String name,int age, String breed){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cat cat=session.get(Cat.class,id);
        cat.setName(name);
        cat.setAge(age);
        cat.setBreed(breed);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cat cat=session.get(Cat.class,id);
        session.delete(cat);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + cat);
    }
}
