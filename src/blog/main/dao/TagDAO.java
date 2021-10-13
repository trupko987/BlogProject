package blog.main.dao;

import java.util.List;

import blog.main.entity.Tag;

public interface TagDAO {
	
	public List<Tag> getTagList();
	public void saveTag(Tag tag);
	public Tag getTagById(int id);
	public void deleteTag(int id);
	public List<Tag> getMostUsageTags();
}
