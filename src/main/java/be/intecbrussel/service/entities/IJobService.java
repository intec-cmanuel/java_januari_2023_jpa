package be.intecbrussel.service.entities;

import be.intecbrussel.model.Job;
import be.intecbrussel.model.Person;
import be.intecbrussel.service.IEntityService;

public interface IJobService extends IEntityService<Job, Long> {
    void deletePersonFromJob(Person person);
}
