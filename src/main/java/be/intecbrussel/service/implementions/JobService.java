package be.intecbrussel.service.implementions;

import be.intecbrussel.model.Job;
import be.intecbrussel.model.Person;
import be.intecbrussel.repository.entities.IJobRepository;
import be.intecbrussel.repository.implementations.JobRepository;
import be.intecbrussel.service.entities.IJobService;
import be.intecbrussel.service.entities.IPersonService;

import java.util.List;

public class JobService implements IJobService {
    private IJobRepository jobRepository = new JobRepository();
    protected IPersonService personService = Service.getPersonService();

    @Override
    public void add(Job job) {
        if (job.getId() != 0) {
            update(job);
        }

        for (Person employee : job.getEmployees()) {
            if (employee.getId() == 0) {
                personService.add(employee);
            } else {
                personService.update(employee);
            }
        }

        jobRepository.create(job);
    }

    @Override
    public Job get(Long id) {
        return jobRepository.read(Job.class, id);
    }

    @Override
    public void update(Job job) {
        for (Person employee : job.getEmployees()) {
            if (employee.getId() == 0) {
                personService.add(employee);
            }
        }

        jobRepository.update(job);
    }

    @Override
    public void delete(Long id) {
        jobRepository.delete(Job.class, id);
    }

    @Override
    public void deletePersonFromJob(Person person) {
        List<Job> jobs = jobRepository.readJobs(person);

        for (Job job : jobs) {
            job.getEmployees().remove(person);
            update(job);
        }
    }
}
