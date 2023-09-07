package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String jobTitle;
    private String jobDescription;

    @OneToMany(mappedBy = "job", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<PersonalJob> employees = new ArrayList<>();

    protected Job(){}

    public Job(String jobTitle, String jobDescription) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    public long getId() {
        return id;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public List<PersonalJob> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", employees=" + employees +
                '}';
    }
}
