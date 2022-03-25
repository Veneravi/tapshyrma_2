package org.example;
import org.example.appAnimals.AppAnimals;
import org.example.appCar.AppCar;
import org.example.appCat.AppCat;
import org.example.appCourse.AppCourse;
import org.example.appDog.AppDog;
import org.example.appMouse.AppMouse;
import org.example.appMucic.AppMusicsInstrument;
import org.example.appPerson.AppPerson;
import org.example.appteacher.AppTeachers;
import org.example.entity.*;
import org.example.products.util.AppProducts;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
public class MainClass {
    public static void main(String[] args) {

        HibernateUtil.getSessionFactory();
        System.out.println("Таблица номер-1");
        Course course=new Course("Java",5,"Zamir");
        Course course2=new Course("English",6,"Neska");
        AppCourse.create(course);
        AppCourse.create(course2);

        AppCourse.read();
        List<Course> courses = AppCourse.read();
        for ( Course c :courses) {
            System.out.println(c);
        }
        AppCourse.getById(1);
        AppCourse.update(1,"Sport",3,"Manas");
        AppCourse.delete(2);
        System.out.println("--------------------------------------------------------------------------------------------");
        HibernateUtil.getSessionFactory();
        System.out.println("Таблица номер-2");
        MusicInstrument musicInstrument=new MusicInstrument("пионино",3);
        MusicInstrument musicInstrument2=new MusicInstrument("dizy",6);
        AppMusicsInstrument.create(musicInstrument);
        AppMusicsInstrument.create(musicInstrument2);
        AppMusicsInstrument.read();
        List<MusicInstrument> musicInstrumentList = AppMusicsInstrument.read();
        for ( MusicInstrument m :musicInstrumentList) {
            System.out.println(m);
        }
        AppMusicsInstrument.getById(1);
        AppMusicsInstrument.update(2,"Fleita",2);
        AppMusicsInstrument.delete(1);
        System.out.println("-----------------------------------------------------------------------------------------------");

        HibernateUtil.getSessionFactory();
        System.out.println("Таблица-3");
        Animals animals=new Animals("Bagira",6);
        Animals animals2=new Animals("Diego",9);
        AppAnimals.create(animals);
        AppAnimals.create(animals2);
        AppAnimals.read();
        List<Animals> animalsList = AppAnimals.read();
        for ( Animals a :animalsList) {
            System.out.println(a);
        }
        AppAnimals.getById(1);
        AppAnimals.update(1,"Sonia",3);
        AppAnimals.delete(2);
        System.out.println("----------------------------------------------------------------------------------------------");

        HibernateUtil.getSessionFactory();
        System.out.println("Таблица-4");
        Car car=new Car("BMV","red");
        AppCar.create(car);
        AppCar.read();
        List<Car> cars = AppCar.read();
        for ( Car r :cars) {
            System.out.println(r);
        }
        AppCar.getById(1);
        AppCar.update(1,"Honda","blue");
        AppCar.delete(1);
        System.out.println("----------------------------------------------------------------------------------------------");
        HibernateUtil.getSessionFactory();
        System.out.println("Таблица-5");
        Cat cat =new Cat("Soska",5,"svetskyi");
        Cat cat2=new Cat("Svich",8,"svichi");
        AppCat.create(cat);
        AppCat.create(cat2);
        AppCat.read();
        List<Cat> cats = AppCat.read();
        for ( Cat t :cats) {
            System.out.println(t);
        }
        AppCat.getById(2);
        AppCat.update(1,"kiska",2,"ala");
        AppCat.delete(2);
        System.out.println("------------------------------------------------------------------------------------------------");
        HibernateUtil.getSessionFactory();
        System.out.println("Таблица-6");
        Mouse mouse=new Mouse("jery",3);
        Mouse mouse2=new Mouse("tom",7);
        AppMouse.create(mouse);
        AppMouse.create(mouse2);
        AppMouse.read();
        List<Mouse> mouseList = AppMouse.read();
        for ( Mouse s:mouseList) {
            System.out.println(s);
        }
        AppMouse.getById(1);
        AppMouse.update(1,"Djery",5);
        AppMouse.delete(1);
        System.out.println("--------------------------------------------------------------------------------------------------");

         HibernateUtil.getSessionFactory();
        System.out.println("Таблица-7");
        Person person=new Person("Zamira Keldibaeva",25);
        Person person2=new Person("Nurlan Mamatkasym uulu",26);
        Person person3=new Person("Baha Surantaev",27);
        AppPerson.create(person);
        AppPerson.create(person2);
        AppPerson.create(person3);
        AppPerson.read();
        List<Person> personList = AppPerson.read();
        for ( Person p :personList) {
            System.out.println(p);
        }
        AppPerson.getById(1);
        AppPerson.update(2,"Daniel Karimov",20);
        AppPerson.delete(3);
        System.out.println("---------------------------------------------------------------------------------------------------");
        HibernateUtil.getSessionFactory();
        System.out.println("Таблица-8");
        Products products=new Products("Apple",85);
        Products products2=new Products("Kivi",90);
        AppProducts.create(products);
        AppProducts.create(products2);
        AppProducts.read();
        List<Products> productsList = AppProducts.read();
        for ( Products d :productsList) {
            System.out.println(d);
        }
        AppProducts.getById(1);
        AppProducts.update(1,"mandarin",230);
        AppProducts.delete(2);
        System.out.println("---------------------------------------------------------------------------------------------------");
         HibernateUtil.getSessionFactory();
        System.out.println("Таблица-9");
        Teacher teacher=new Teacher("Muhammed Alanov","Java");
        Teacher teacher2=new Teacher("Elnura Tajibaeva","JavaScript");
        AppTeachers.create(teacher);
        AppTeachers.create(teacher2);
        AppTeachers.read();
        List<Teacher> teachers = AppTeachers.read();
        for ( Teacher e :teachers) {
            System.out.println(e);
        }
        AppTeachers.getById(1);
        AppTeachers.update(1,"Zamir Sabyrjanov","Java");
        AppTeachers.delete(2);
        System.out.println("-----------------------------------------------------------------------------------------------");
        HibernateUtil.getSessionFactory();
        System.out.println("final Tablisa");
        Dog dog=new Dog("Bobik",2,"kok");
        AppDog.create(dog);
        AppCar.read();
        List<Dog> dogs = AppDog.read();
        for ( Dog d :dogs) {
            System.out.println(d);
        }
        AppDog.getById(1);
        AppDog.update(1,"Aktosh",2,"ak");
        AppDog.delete(1);




    }

}
