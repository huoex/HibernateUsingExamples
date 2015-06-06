package ua.anakin.model_07_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainFor07 {

    public static void main(String[] args) {

        Student alex = new Student();
        alex.setStudentName("Alex");

        Student vano = new Student();
        vano.setStudentName("Vano");

        Course java = new Course();
        java.setCourseName("Java");

        Course spring = new Course();
        spring.setCourseName("Spring");

        Course sql = new Course();
        sql.setCourseName("SQL");

        alex.getCourses().add(java);
        alex.getCourses().add(spring);
        alex.getCourses().add(sql);
        vano.getCourses().add(java);
        vano.getCourses().add(spring);

        java.getStudents().add(alex);
        java.getStudents().add(vano);

        spring.getStudents().add(alex);
        spring.getStudents().add(vano);

        sql.getStudents().add(alex);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(alex);
        session.save(vano);
        session.save(java);
        session.save(spring);
        session.save(sql);
        session.getTransaction().commit();
        session.close();

        factory.close();
    }
}
