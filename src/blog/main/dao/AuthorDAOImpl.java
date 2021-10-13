package blog.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import blog.main.entity.Author;

@Component
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Author> getAuthorList() {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Author> authors = session.createQuery("from Author", Author.class).getResultList();
		
		return authors;
	}

	@Transactional
	@Override
	public void saveAuthor(Author author) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(author);
	}

	@Transactional
	@Override
	public Author getAuthorById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Author author = session.get(Author.class, id);
		
		return author;
	}

	@Transactional
	@Override
	public void deleteAuthor(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Author author = session.get(Author.class, id);
		session.delete(author);
	}

}
