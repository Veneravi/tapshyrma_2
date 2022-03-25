package org.example.appMouse;
import org.example.entity.Mouse;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AppMouse {


    public static int create (Mouse mouse){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(mouse);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно "+mouse);
        return mouse.getId();
    }
    public static List<Mouse> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Mouse> mouses = session.createQuery("FROM Mouse ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + mouses.size() + " mouses ");
        return mouses;
    }
    public static Mouse getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Mouse mouse=session.get(Mouse.class,id);
        session.getTransaction().commit();
        session.close();
        return mouse;

    }
    public static void update(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Mouse mouse=session.get(Mouse.class,id);
        mouse.setName(name);
        mouse.setAge(age);

        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Mouse mouse=session.get(Mouse.class,id);
        session.delete(mouse);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + mouse);
    }
}
