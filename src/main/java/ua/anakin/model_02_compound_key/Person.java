package ua.anakin.model_02_compound_key;

import ua.anakin.model_01_example.Address;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @EmbeddedId
    private Passport passport;
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
    @ElementCollection
    @JoinTable(name = "jobs")
    private Set<Job> jobs = new HashSet<Job>();

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "passport=" + passport +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", jobs=" + jobs +
                '}';
    }
}
