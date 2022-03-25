package org.example.appteacher;
import org.example.entity.Teacher;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AppTeachers {


    public static int create (Teacher teacher){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно"+teacher);
        return teacher.getId();
    }
    public static List<Teacher> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Teacher> teacher = session.createQuery("FROM Teacher ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + teacher.size() + " teacher ");
        return teacher;
    }
    public static Teacher getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,id);
        session.getTransaction().commit();
        session.close();
        return teacher;

    }
    public static void update(int id,String name,String lesson){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,id);
        teacher.setName(name);
        teacher.setLesson(lesson);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,id);
        session.delete(teacher);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + teacher);
    }

}
