package dataAccess;

import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.List;

public class JdbcDao implements InstructorDao, CategoryDao, CourseDao {

    Database database;

    public JdbcDao(Database database) {
        this.database = database;
    }

    @Override
    public void get(Category category) {
        System.out.println(category.getCategoryName() + " isimli kategori JDBC ile getirildi");
    }

    @Override
    public void getAllCategories() {
        System.out.println("Tüm kategoriler JDBC ile getirildi: ");

        for(Category category : database.categories) {
            System.out.println(category);
        }
    }

    @Override
    public void add(Category category) {
        database.categories.add(category);
        System.out.println(category.getCategoryName() + " isimli kategori JDBC ile database'e eklendi");
    }

    @Override
    public void delete(Category category) {
        database.categories.remove(category);
        System.out.println(category.getCategoryName() + " isimli kategori JDBC ile database'den silindi");
    }

    public Category getByCategoryName(String name) {
        return database.categories.
                stream().
                filter(category -> category.getCategoryName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void get(Course course) {
        System.out.println(course.getCourseName() + " isimli kurs JDBC ile getirildi");
    }

    @Override
    public void getAllCourses() {
        System.out.println("Tüm kurslar JDBC ile getirildi: ");

        for(Course course : database.courses) {
            System.out.println(course);
        }
    }

    @Override
    public void add(Course course) {
        database.courses.add(course);
        System.out.println(course.getCourseName() + " isimli kurs JDBC ile database'e eklendi");
    }

    @Override
    public void delete(Course course) {
        database.courses.remove(course);
        System.out.println(course.getCourseName() + " isimli kurs JDBC ile database'den silindi");
    }

    public Course getByCourseName(String name) {
        return database.courses.
                stream().
                filter(course -> course.getCourseName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void get(Instructor instructor) {
        System.out.println(instructor.getName() + " " + instructor.getSurname() + " isimli eğitmen JDBC ile getirildi");
    }

    @Override
    public void getAllInstructors() {
        System.out.println("Tüm eğitmenler JDBC ile getirildi: ");

        for(Instructor instructor : database.instructors) {
            System.out.println(instructor);
        }
    }

    @Override
    public void add(Instructor instructor) {
        database.instructors.add(instructor);
        System.out.println(instructor.getName() + " " + instructor.getSurname() + " isimli eğitmen JDBC ile database'e eklendi");
    }

    @Override
    public void delete(Instructor instructor) {
        database.instructors.remove(instructor);
        System.out.println(instructor.getName() + " " + instructor.getSurname() + " isimli eğitmen JDBC ile database'den silindi");
    }
}
