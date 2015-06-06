package ua.anakin.model_02_compound_key;

public class MainFor02 {

/*    public static void main(String[] args) {

        Passport passport = new Passport();
        passport.setPassportSeries("AA");
        passport.setPassportNumber(1000);

        Address address = new Address();
        address.setCity("Kiev");
        address.setStreet("Avenue");

        Job job1 = new Job();
        job1.setCompany("Best work");
        job1.setVacancy("Uber Manager");
        Job job2 = new Job();
        job2.setCompany("Mega Job");
        job2.setVacancy("Manager of the Hell");

        Person person = new Person();
        person.setPassport(passport);
        person.setFirstName("Alex");
        person.setLastName("Red");
        person.setAddress(address);
        person.getJobs().add(job1);
        person.getJobs().add(job2);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

        person = null;

        session = factory.openSession();
        session.beginTransaction();
        person = (Person) session.get(Person.class, passport);
        System.out.println(person);

        factory.close();
    }*/
}
