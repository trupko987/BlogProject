package blog.main.dao;

import java.util.List;

import blog.main.entity.Blog;

public interface BlogDAO {
	
	public List<Blog> getBlogList();
	public void saveBlog(Blog blog);
	public void deleteBlog(int id);
	public Blog getBlogById(int id);
	public List<Blog> getBlogImportant();
	public List<Blog> getLatestBlogs();
	public List<Blog> getLastThreeBlogs();
	public List<Blog> getFilterBlogs(String name);
	public List<Blog> getBlogsByCategory(int id);
	public List<Blog> getBlogsByAuthor(int id);
	public List<Blog> getBlogsSearch(String search);
	List<Blog> getBlogsByTag(Integer[] tags);
	
}
