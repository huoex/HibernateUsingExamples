package ua.anakin.model_09_SampleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainFor09 {

    public static void main(String[] args) {

    	SampleEntity sampleEntity = new SampleEntity("zhang","san");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(sampleEntity);

        // Hibernate by default implement Single Table Inheritance Strategy
        // That's mean all rows of subclasses will be in one common table
        // with name of parent class

        session.getTransaction().commit();
        session.close();

        factory.close();
    }
}