package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column
	private int id;
	@Column
	private String name;
	@Column(name = "number_of_blogs")
	private int numberOfBlogs;
	@Column
	private int ordering;
	@Column
	private boolean enabled;

	public Category() {
	}

	public Category(int id, String name, int numberOfBlogs, int ordering, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfBlogs = numberOfBlogs;
		this.ordering = ordering;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumberOfBlogs() {
		return numberOfBlogs;
	}

	public void setNumberOfBlogs(int numberOfBlogs) {
		this.numberOfBlogs = numberOfBlogs;
	}

	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int ordering) {
		this.ordering = ordering;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return name+" - "+id;
	}
	
}
