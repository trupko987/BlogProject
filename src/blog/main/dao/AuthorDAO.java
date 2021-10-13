package blog.main.dao;

import java.util.List;

import blog.main.entity.Author;

public interface AuthorDAO {
	
	public List<Author> getAuthorList();
	public void saveAuthor(Author author);
	public Author getAuthorById(int id);
	public void deleteAuthor(int id);
	

}
