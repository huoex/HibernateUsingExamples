package ua.anakin.model_06_mapped_by;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainFor06 {

    public static void main(String[] args) {

        Person person = new Person();
        person.setFirstName("Alex");
        person.setLastName("Red");

        PersonDetails details = new PersonDetails();
        details.setAge(28);
        details.setSex("male");

        person.setDetails(details);

        Vehicle ford = new Vehicle();
        ford.setVehicleName("Ford");
        Vehicle jeep = new Vehicle();
        jeep.setVehicleName("Jeep");

        person.getVehicle().add(ford);
        person.getVehicle().add(jeep);

        ford.setPerson(person);
        jeep.setPerson(person);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(person);
        session.save(details);
        session.save(ford);
        session.save(jeep);
        session.getTransaction().commit();
        session.close();

        factory.close();
    }
}
