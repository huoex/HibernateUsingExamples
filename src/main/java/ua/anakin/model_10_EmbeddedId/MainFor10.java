package ua.anakin.model_10_EmbeddedId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainFor10 {

    public static void main(String[] args) {

    	EmbeddedIdExampleDepartment embeddedIdExampleDepartment = new EmbeddedIdExampleDepartment();
    	embeddedIdExampleDepartment.setDepartmentId(3L);
    	embeddedIdExampleDepartment.setName("san.bu");
    	
    	EmbeddedIdExampleEmployeePK embeddedIdExampleEmployeePK = new EmbeddedIdExampleEmployeePK(20070591L,3L);

    	EmbeddedIdExampleEmployee embeddedIdExampleEmployee = new EmbeddedIdExampleEmployee();
    	embeddedIdExampleEmployee.setEmployeePk(embeddedIdExampleEmployeePK);
    	embeddedIdExampleEmployee.setDepartment(embeddedIdExampleDepartment);
    	
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(embeddedIdExampleEmployee);

        // Hibernate by default implement Single Table Inheritance Strategy
        // That's mean all rows of subclasses will be in one common table
        // with name of parent class

        session.getTransaction().commit();
        session.close();

        factory.close();
    }
}