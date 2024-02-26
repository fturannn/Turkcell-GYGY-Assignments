package business;

import core.Logger;
import dataAccess.CategoryDao;
import entities.Category;

import java.util.List;

public class CategoryManager {

    private CategoryDao categoryDao;
    private Logger[] loggers;

    public CategoryManager(CategoryDao categoryDao, Logger[] loggers) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
    }

    public void add(Category category) {
        if(categoryDao.getByCategoryName(category.getCategoryName()) != null) {
            System.out.println("Aynı isimde kategori mevcut!");
        } else {
            categoryDao.add(category);
            for(Logger logger : loggers) {
                logger.log(category.getCategoryName());
            }
        }
    }

    public void get(Category category) {
        categoryDao.get(category);
    }

    public void getAllCategories() {
        categoryDao.getAllCategories();
    }

    public void delete(Category category) {
        categoryDao.delete(category);
    }
}
