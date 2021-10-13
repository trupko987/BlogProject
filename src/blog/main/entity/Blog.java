package blog.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "blogs")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String image;
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "category_id")
	private Category category;
	@Column
	private boolean homepage;
	@Column(name = "date_created")
	private String date;
	@Column
	private int counter;
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name = "blogs_tags", joinColumns = @JoinColumn(name="blog_id"), inverseJoinColumns = @JoinColumn(name="tag_id"))
	private List<Tag> tags;
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "author")
	private Author authors;
	@Column
	private String content;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "comment_id")
	private List<Comment> comment;
	@Column
	private boolean enabled;
	
	public Blog() {
	}

	public Blog(int id, String title, String image, String description, Category category, boolean homepage, String date, int counter, String content, List<Comment> comment, boolean enabled) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.category = category;
		this.homepage = homepage;
		this.date = date;
		this.counter = counter;
		this.content = content;
		this.comment = comment;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean getHomepage() {
		return homepage;
	}
	public void setHomepage(boolean homepage) {
		this.homepage = homepage;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public Author getAuthor() {
		return authors;
	}
	public void setAuthor(Author authors) {
		this.authors = authors;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Author getAuthors() {
		return authors;
	}

	public void setAuthors(Author authors) {
		this.authors = authors;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return title+" - "+id;
	}
	
	public String getFormattedDate() {
		
		return "";
	}
	
	
}
