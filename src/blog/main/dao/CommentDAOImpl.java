package blog.main.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommentDAOImpl implements CommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<CommentDAO> getCommentListForBlog(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Comment c where c.id = :ID");
		query.setParameter("ID", id);
		
		return query.getResultList();
	}

}
