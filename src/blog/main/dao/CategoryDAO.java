package blog.main.dao;

import java.util.List;

import blog.main.entity.Category;

public interface CategoryDAO {
	
	public List<Category> getCategoryList();
	public void saveCategory(Category category);
	public Category getCategoryById(int id);
	public void deleteCategory(int id);
	public List<Category> getCategoryOrderList();
	public int getNumberOfBlogsForCategory(int id);
}
