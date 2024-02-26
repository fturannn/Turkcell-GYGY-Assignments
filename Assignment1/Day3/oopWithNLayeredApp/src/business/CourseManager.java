package business;

import core.Logger;
import dataAccess.CourseDao;
import entities.Course;

import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private Logger[] loggers;

    public CourseManager(CourseDao courseDao, Logger[] loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
    }

    public void add(Course course) {
        if(courseDao.getByCourseName(course.getCourseName()) != null) {
            System.out.println("Aynı isimde kurs mevcut!");
        } else if(course.getPrice() < 0) {
            System.out.println("Kursun fiyatı sıfırdan küçük olamaz");
        }else {
            courseDao.add(course);
            for(Logger logger : loggers) {
                logger.log(course.getCourseName());
            }
        }
    }

    public void get(Course course) {
        courseDao.get(course);
    }

    public void getAllCourses() {
        courseDao.getAllCourses();
    }

    public void delete(Course course) {
        courseDao.delete(course);
    }
}
