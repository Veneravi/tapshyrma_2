package org.example.appMucic;
import org.example.entity.MusicInstrument;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AppMusicsInstrument {

    public static int create (MusicInstrument musicInstrument){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(musicInstrument);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно"+musicInstrument);
        return musicInstrument.getId();
    }
    public static List<MusicInstrument> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<MusicInstrument> musicInstrumentList = session.createQuery("FROM MusicInstrument ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + musicInstrumentList.size() + " musicInstrument ");
        return musicInstrumentList;
    }
    public static MusicInstrument getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        MusicInstrument musicInstrument=session.get(MusicInstrument.class,id);
        session.getTransaction().commit();
        session.close();
        return musicInstrument;

    }
    public static void update(int id,String instrument,int howMuch){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        MusicInstrument musicInstrument=session.get(MusicInstrument.class,id);
        musicInstrument.setInstrument(instrument);
        musicInstrument.setHowMuch(howMuch);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        MusicInstrument musicInstrument=session.get(MusicInstrument.class,id);
        session.delete(musicInstrument);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + musicInstrument);
    }


}
