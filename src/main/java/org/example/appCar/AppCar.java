package org.example.appCar;

import org.example.entity.Car;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class AppCar {
    public static int create (Car car){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно "+ car);
        return car.getId();
    }
    public static List<Car> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Car> car = session.createQuery("FROM Car ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + car.size() + " course ");
        return car;
    }
    public static Car getById(int id){
       Session session=HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
        Car car=session.get(Car.class,id);
       session.getTransaction().commit();
       session.close();
       return car;

    }
    public static void update(int id,String name,String color){
       Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       Car car=session.get(Car.class,id);
        car.setName(name);
        car.setColor(color);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car=session.get(Car.class,id);
        session.delete(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + car);
    }
}
