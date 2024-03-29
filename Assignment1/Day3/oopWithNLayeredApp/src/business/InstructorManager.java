package business;

import core.Logger;
import dataAccess.InstructorDao;
import entities.Instructor;

import java.util.List;

public class InstructorManager {

    private InstructorDao instructorDao;
    private Logger[] loggers;

    public InstructorManager(InstructorDao instructorDao, Logger[] loggers) {
        this.instructorDao = instructorDao;
        this.loggers = loggers;
    }

    public void add(Instructor instructor) {
        instructorDao.add(instructor);
        for(Logger logger : loggers) {
            logger.log((instructor.getName() + " " + instructor.getSurname()));
        }
    }

    public void get(Instructor instructor) {
        instructorDao.get(instructor);
    }

    public void getAllInstructors() {
        instructorDao.getAllInstructors();
    }

    public void delete(Instructor instructor) {
        instructorDao.delete(instructor);
    }
}
