package blog.main.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import blog.main.entity.Blog;
import blog.main.entity.Category;
import blog.main.entity.Tag;
import javassist.expr.Cast;

@Component
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Category> getCategoryList() {

		Session session = sessionFactory.getCurrentSession();
		
		List<Category> categories = session.createQuery("from Category", Category.class).getResultList();
		
		return categories;
	}

	@Transactional
	@Override
	public void saveCategory(Category category) {

		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(category);
	}
	
	@Transactional
	@Override
	public Category getCategoryById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		return category;
	}
	
	@Transactional
	@Override
	public void deleteCategory(int id) {

		Session session = sessionFactory.getCurrentSession();
//		Category category = session.get(Category.class, id);
//		session.delete(category);
		
		Query query = session.createQuery("delete from Category where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Transactional
	@Override
	public List<Category> getCategoryOrderList() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Category> categoriesOrder = session.createQuery("from Category c order by c.ordering asc", Category.class).setMaxResults(5).getResultList();
		
		return categoriesOrder;
	}

	@Transactional
	@Override
	public int getNumberOfBlogsForCategory(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select count(*) from Blog b where b.category.id =: id");
		
		return (int) query;
	}
	




}
