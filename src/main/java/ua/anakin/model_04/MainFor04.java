package ua.anakin.model_04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainFor04 {

    public static void main(String[] args) {

        Job job1 = new Job();
        job1.setCompany("Best work");
        job1.setVacancy("Super Manager");
        Job job2 = new Job();
        job2.setCompany("Mega Job");
        job2.setVacancy("Manager of the Hell");

        PersonAccount personAccount = new PersonAccount();
        personAccount.setFirstName("Alex");
        personAccount.setLastName("Red");
        personAccount.getJobs().add(job1);
        personAccount.getJobs().add(job2);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(personAccount);
        session.getTransaction().commit();
        session.close();

        personAccount = null;

        session = factory.openSession();
        session.beginTransaction();
        personAccount = (PersonAccount) session.get(PersonAccount.class, 1);
        session.close();
        // because load of Collection is not lazy we can get all it's properties
        System.out.println(personAccount.getJobs().size());

        factory.close();
    }
}
