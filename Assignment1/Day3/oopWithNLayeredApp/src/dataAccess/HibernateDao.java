package dataAccess;

import entities.Category;
import entities.Course;
import entities.Instructor;

public class HibernateDao implements CourseDao, CategoryDao, InstructorDao {
    Database database;

    public HibernateDao(Database database) {
        this.database = database;
    }

    @Override
    public void get(Category category) {
        System.out.println(category.getCategoryName() + " isimli kategori Hibernate ile getirildi");
    }

    @Override
    public void getAllCategories() {
        System.out.println("Tüm kategoriler Hibernate ile getirildi: ");

        for(Category category : database.categories) {
            System.out.println(category.getCategoryName());
        }
    }

    @Override
    public void add(Category category) {
        database.categories.add(category);
        System.out.println(category.getCategoryName() + " isimli kategori Hibernate ile database'e eklendi");
    }

    @Override
    public void delete(Category category) {
        database.categories.remove(category);
        System.out.println(category.getCategoryName() + " isimli kategori Hibernate ile database'den silindi");
    }

    public Category getByCategoryName(String name) {
        return database.categories.
                stream().
                filter(category -> category.getCategoryName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void get(Course course) {
        System.out.println(course.getCourseName() + " isimli kurs Hibernate ile getirildi");
    }

    @Override
    public void getAllCourses() {
        System.out.println("Tüm kurslar Hibernate ile getirildi: ");

        for(Course course : database.courses) {
            System.out.println(course.getCourseName());
        }
    }

    @Override
    public void add(Course course) {
        database.courses.add(course);
        System.out.println(course.getCourseName() + " isimli kurs Hibernate ile database'e eklendi");
    }

    @Override
    public void delete(Course course) {
        database.courses.remove(course);
        System.out.println(course.getCourseName() + " isimli kurs Hibernate ile database'den silindi");
    }

    public Course getByCourseName(String name) {
        return database.courses.
                stream().
                filter(course -> course.getCourseName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void get(Instructor instructor) {
        System.out.println(instructor.getName() + " " + instructor.getSurname() + " isimli eğitmen Hibernate ile getirildi");
    }

    @Override
    public void getAllInstructors() {
        System.out.println("Tüm eğitmenler Hibernate ile getirildi: ");

        for(Instructor instructor : database.instructors) {
            System.out.println(instructor.getName() + " " + instructor.getSurname());
        }
    }

    @Override
    public void add(Instructor instructor) {
        database.instructors.add(instructor);
        System.out.println(instructor.getName() + " " + instructor.getSurname() + " isimli eğitmen Hibernate ile database'e eklendi");
    }

    @Override
    public void delete(Instructor instructor) {
        database.instructors.remove(instructor);
        System.out.println(instructor.getName() + " " + instructor.getSurname() + " isimli eğitmen Hibernate ile database'den silindi");
    }
}
