package ua.anakin.model_07_many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int studentId;
    private String StudentName;
    @ManyToMany
    (cascade = CascadeType.ALL)
    private Collection<Course> courses = new ArrayList<Course>();

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }
}
