package be.intecbrussel.repository.entities;

import be.intecbrussel.model.Job;
import be.intecbrussel.model.Person;
import be.intecbrussel.repository.IEntityRepository;

import java.util.List;

public interface IJobRepository extends IEntityRepository<Job> {

    List<Job> readJobs(Person person);
}
