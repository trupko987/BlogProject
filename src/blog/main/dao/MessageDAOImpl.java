package blog.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import blog.main.entity.Message;

@Component
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Message> getAllMessages() {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Message> messages = session.createQuery("from Message", Message.class).getResultList();
		
		return messages;
	}

	@Transactional
	@Override
	public void saveMessage(Message message) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(message);
	}
	
	@Transactional
	@Override
	public void markAsSeen(int id) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public long getUnreadMessagesCount() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select count(*) from Message m where m.isSeen = 0");
		
		return (long) query.uniqueResult();
	}
	
	@Transactional
	@Override
	public Message getMessageById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Message message = session.get(Message.class, id);
		
		return message;
	}

}
