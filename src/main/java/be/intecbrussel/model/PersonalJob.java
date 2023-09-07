package be.intecbrussel.model;

import jakarta.persistence.*;

@Entity
public class PersonalJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne (cascade = CascadeType.MERGE)
    private Job job;

    @ManyToOne (cascade = CascadeType.MERGE)
    private Person person;

    private double salary;

    public PersonalJob (Job job, Person person, double salary) {
        this.job = job;
        this.person = person;
        this.salary = salary;
    }

    protected PersonalJob(){}

    public Job getJob() {
        return job;
    }

    public long getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Person getPerson() {
        return person;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PersonalJob{" +
                "id=" + id +
//                ", job=" + job +
                ", person=" + person +
                ", salary=" + salary +
                '}';
    }
}
