package ua.anakin.model_04;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class PersonAccount {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    @ElementCollection(fetch = FetchType.EAGER) // it makes Hib load collection NOT Lazy
    @JoinTable(name = "jobs",
        joinColumns = @JoinColumn(name = "person_id")
    )
    private Collection<Job> jobs = new ArrayList<Job>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Collection<Job> jobs) {
        this.jobs = jobs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonAccount{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobs=" + jobs +
                '}';
    }
}
