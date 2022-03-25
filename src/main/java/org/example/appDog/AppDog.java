package org.example.appDog;
;
import org.example.entity.Dog;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AppDog {


    public static int create (Dog dog){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(dog);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно "+dog);
        return dog.getId();
    }
    public static List<Dog> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Dog> dogs = session.createQuery("FROM Dog ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + dogs.size() + " dog");
        return dogs;
    }
    public static Dog getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog=session.get(Dog.class,id);
        session.getTransaction().commit();
        session.close();
        return dog;

    }
    public static void update(int id,String name,int age,String color){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog=session.get(Dog.class,id);
        dog.setName(name);
        dog.setAge(age);
        dog.setColor(color);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog=session.get(Dog.class,id);
        session.delete(dog);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + dog);
    }
}
