package org.example.products.util;
import org.example.entity.Products;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AppProducts {

    public static int create (Products products){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(products);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно"+products);
        return products.getId();
    }
    public static List<Products> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Products> products = session.createQuery("FROM Products ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + products.size() + " products ");
        return products;
    }
    public static Products getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Products products=session.get(Products.class,id);
        session.getTransaction().commit();
        session.close();
        return products;

    }
    public static void update(int id,String productName,int price){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Products products=session.get(Products.class,id);
        products.setProductName(productName);
        products.setPrice(price);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update successfully");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Products products=session.get(Products.class,id);
        session.delete(products);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully" + products);
    }

}
