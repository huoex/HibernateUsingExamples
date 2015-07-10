package ua.anakin.model_01_example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

public class MainFor01 {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("Alex");

        Student student1 = new Student();
        student1.setName("Alex");
        student1.setSpeciality("Developer");
        student1.setEnteredDate(new Date());

        Address address = new Address();
        address.setCity("Kiev");
        address.setStreet("Avenue");

        Address officeAddress = new Address();
        officeAddress.setCity("Kiev");
        officeAddress.setStreet("Square");

        student1.setAddress(address);
        user.setHomeAddress(address);
        user.setOfficeAddress(officeAddress);

        Student student2 = new Student();
        student2.setName("Vano");
        student2.setSpeciality("Designer");
        student2.setEnteredDate(new Date());
        student2.setAddress(address);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(student1);
        session.save(student2);
        session.getTransaction().commit();
        session.close();

        user = null;

        session = factory.openSession();
        session.beginTransaction();
        user = (User) session.get(User.class, 1);
        System.out.println(user);
    }
}
