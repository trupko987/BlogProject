package blog.main.dao;

import java.util.List;

public interface CommentDAO {
	
	public List<CommentDAO> getCommentListForBlog(int id);

}
