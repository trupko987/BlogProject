package blog.main.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import blog.main.entity.Blog;

@Component //@repostitory
class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Blog> getBlogList() {

		Session session= sessionFactory.getCurrentSession();
		List<Blog> blogList = session.createQuery("from Blog", Blog.class).getResultList();

		return blogList;
	}

	@Transactional
	@Override
	public void saveBlog(Blog blog) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
	}

	@Transactional
	@Override
	public void deleteBlog(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Blog where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Transactional
	@Override
	public Blog getBlogById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Blog blog = session.get(Blog.class, id);
		return blog;
	}

	@Transactional
	@Override
	public List<Blog> getBlogImportant() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Blog> blogImportant = session.createQuery("from Blog b where b.homepage = 1", Blog.class).getResultList();
		
		return blogImportant;
	}

	@Transactional
	@Override
	public List<Blog> getLatestBlogs() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Blog> latestBlogs = session.createQuery("from Blog b order by b.date desc", Blog.class).setMaxResults(12).getResultList();

		return latestBlogs;
	}
	
	@Transactional
	@Override
	public List<Blog> getLastThreeBlogs() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Blog> lastThreeBlogs = session.createQuery("from Blog b order by b.date desc", Blog.class).setMaxResults(3).getResultList();

		return lastThreeBlogs;
	}

	@Transactional
	@Override
	public List<Blog> getFilterBlogs(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Blog b where b.blog.name = :name");
		query.setParameter("name", name);
		
		return query.getResultList();
	}

	@Transactional
	@Override
	public List<Blog> getBlogsByCategory(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Blog b where b.category.id = :ID");
		query.setParameter("ID", id);
		
		return query.getResultList();
	}

	@Transactional
	@Override
	public List<Blog> getBlogsByTag(Integer[] tags) {
		
		Session session = sessionFactory.getCurrentSession();
		
//		Query query = session.createQuery("from Blog t where t.tags = :ID");
//		query.setParameter("ID", id);
		
		String queryString = "";
		
		if(tags != null) {
			queryString = "select distinct t from Blog t left join t.tags g ";
		}
		else {
			queryString = "from Blog b ";
			
		}
			
			if (tags != null && tags.length > 0) {

				if (!queryString.contains("where")) {
					queryString = queryString + " where ";
				}
				else {
					queryString = queryString + " and ";
				}

				queryString = queryString + " t.id in (:tags)";
			}

			Query query = session.createQuery(queryString);

			if (tags != null && tags.length > 0) {
				query.setParameter("tags", tags);
			}

			List<Blog> blogs = query.getResultList();
			
			for (Blog b : blogs) {
				Hibernate.initialize(b.getTags());
			}

			return blogs;
	}

	@Transactional
	@Override
	public List<Blog> getBlogsByAuthor(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Blog a where a.authors.id = :ID");
		query.setParameter("ID", id);
		
		return query.getResultList();
	}

	@Transactional
	@Override
	public List<Blog> getBlogsSearch(String search) {
		
		Session session = sessionFactory.getCurrentSession();
		String stringQuery = "from Blog b where b.title like :search";
		
		Query query = session.createQuery(stringQuery);
		query.setParameter("search", "%"+search+"%");
		
		return query.getResultList();
	}

}
