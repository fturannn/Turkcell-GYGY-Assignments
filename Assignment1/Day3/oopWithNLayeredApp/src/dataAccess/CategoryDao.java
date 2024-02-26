package dataAccess;

import entities.Category;
import entities.Instructor;

public interface CategoryDao {
    void get(Category category);
    void getAllCategories();
    void add(Category category);
    void delete(Category category);
    Category getByCategoryName(String name);
}
