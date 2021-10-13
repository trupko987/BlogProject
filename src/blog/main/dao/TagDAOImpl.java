package blog.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import blog.main.entity.Tag;

@Component
public class TagDAOImpl implements TagDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Tag> getTagList() {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Tag> tags = session.createQuery("from Tag", Tag.class).getResultList();
		
		return tags;
	}

	@Transactional
	@Override
	public void saveTag(Tag tag) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tag);
	}

	@Transactional
	@Override
	public Tag getTagById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Tag tag = session.get(Tag.class, id);
		return tag;
	}

	@Transactional
	@Override
	public void deleteTag(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Tag tag = session.get(Tag.class, id);
		session.delete(tag);
	}
	
	@Transactional
	@Override
	public List<Tag> getMostUsageTags() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Tag> tagsAside = session.createQuery("from Tag t order by t.usage desc", Tag.class).setMaxResults(5).getResultList();
		
		return tagsAside;
	}

}
