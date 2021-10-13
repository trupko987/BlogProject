package blog.main.dao;

import java.util.List;

import blog.main.entity.Message;

public interface MessageDAO {
	
	public List<Message> getAllMessages();
	public void saveMessage(Message message);
	public void markAsSeen(int id);
	public long getUnreadMessagesCount();
	public Message getMessageById(int id);
}
