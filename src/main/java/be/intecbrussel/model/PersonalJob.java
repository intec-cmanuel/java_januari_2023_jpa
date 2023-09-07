package be.intecbrussel.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class PersonalJob {
    @EmbeddedId
    private PersonJobId id;

    @ManyToOne (cascade = CascadeType.MERGE)
    @MapsId("jobId")
    private Job job;

    @ManyToOne (cascade = CascadeType.MERGE)
    @MapsId("personId")
    private Person person;

    private double salary;

    public PersonalJob (Job job, Person person, double salary) {
        this.id = new PersonJobId(job.getId(), person.getId());
        this.job = job;
        this.person = person;
        this.salary = salary;
    }

    protected PersonalJob(){}

    public Job getJob() {
        return job;
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

    @Embeddable
    private static class PersonJobId  {
        private long jobId;
        private long personId;

        public PersonJobId(long jobId, long personId){
            this.jobId = jobId;
            this.personId = personId;
        }

        public PersonJobId(){}
    }
}
