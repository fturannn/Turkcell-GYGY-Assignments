package dataAccess;

import entities.Category;
import entities.Instructor;

import java.util.List;

public interface InstructorDao {
    void get(Instructor instructor);
    void getAllInstructors();
    void add(Instructor instructor);
    void delete(Instructor instructor);
}
