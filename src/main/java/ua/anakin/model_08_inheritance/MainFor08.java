package ua.anakin.model_08_inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainFor08 {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Transport");

        Motorbike motorbike = new Motorbike();
        motorbike.setVehicleName("Honda");
        motorbike.setBikeType("Race");

        Car car = new Car();
        car.setVehicleName("Explorer");
        car.setSeaterNumber(8);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(vehicle);
        session.save(motorbike);
        session.save(car);

        // Hibernate by default implement Single Table Inheritance Strategy
        // That's mean all rows of subclasses will be in one common table
        // with name of parent class

        session.getTransaction().commit();
        session.close();

        factory.close();
    }
}
