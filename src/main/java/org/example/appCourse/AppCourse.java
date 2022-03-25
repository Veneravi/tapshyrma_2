package org.example.appCourse;
import org.example.entity.Course;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class AppCourse {


    public static int create (Course course){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно "+course);
        return course.getId();
    }
    public static List<Course> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Course> course = session.createQuery("FROM Course ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + course.size() + " course ");
        return course;
    }
    public static Course getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Course course=session.get(Course.class,id);
        session.getTransaction().commit();
        session.close();
        return course;

    }
    public static void update(int id,String courseName,int duration,String teacherName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Course course=session.get(Course.class,id);
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setTeacherName(teacherName);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Course course=session.get(Course.class,id);
        session.delete(course);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + course);
    }
}
