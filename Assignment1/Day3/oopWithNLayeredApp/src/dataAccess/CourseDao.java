package dataAccess;

import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.List;

public interface CourseDao {
    void get(Course course);
    void getAllCourses();
    void add(Course course);
    void delete(Course course);
    Course getByCourseName(String name);
}
