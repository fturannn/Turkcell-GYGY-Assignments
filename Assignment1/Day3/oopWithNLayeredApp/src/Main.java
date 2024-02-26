import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.DatabaseLogger;
import core.FileLogger;
import core.Logger;
import core.MailLogger;
import dataAccess.Database;
import dataAccess.HibernateDao;
import dataAccess.JdbcDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

public class Main {
    public static void main(String[] args) {
        Category category = new Category(1, "Programlama");
        Instructor instructor1 = new Instructor(1, "Engin", "Demiroğ");
        Instructor instructor2 = new Instructor(2, "Halit Enes", "Kalaycı");
        Course course1 = new Course(1, "Senior Yazılım Geliştirici Yetiştirme Kampı (.NET)", instructor1, category, 2500);
        Course course2 = new Course(2, "2024 - Yazılım Geliştirici Yetiştirme Kampı C#", instructor1, category, 2500);
        Course course3 = new Course(3, "(2023) Yazılım Geliştirici Yetiştirme Kampı (Python & Selenium)", instructor2, category, 2500);
        Course course4 = new Course(4, "(2022) Yazılım Geliştirici Yetiştirme Kampı - JAVA", instructor1, category, 2500);
        Course course5 = new Course(5, "Yazılım Geliştirici Yetiştirme Kampı (JavaScript)", instructor1, category, 2500);
        Course course6 = new Course(6, "Yazılım Geliştirici Yetiştirme Kampı (JAVA & REACT)", instructor1, category, 2500);
        Course course7 = new Course(7, "Yazılım Geliştirici Yetiştirme Kampı", instructor1, category, 2500);
        Course course8 = new Course(8, "Programlamaya Giriş İçin Temel Kurs", instructor1, category, 2500);

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};

        CategoryManager categoryManager = new CategoryManager(new JdbcDao(new Database()), loggers);
        categoryManager.add(category);

        CourseManager courseManager = new CourseManager(new HibernateDao(new Database()), loggers);
        courseManager.add(course1);

        InstructorManager instructorManager = new InstructorManager(new HibernateDao(new Database()), loggers);
        instructorManager.add(instructor1);
        instructorManager.add(instructor2);
    }
}