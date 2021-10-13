package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int usage;
	
	public Tag() {
		
	}
	
	public Tag(String id) {
		this.id = Integer.valueOf(id);
	}

	public Tag(int id, String name, int usage) {
		super();
		this.id = id;
		this.name = name;
		this.usage = usage;
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

	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	@Override
	public String toString() {
		return name+" - "+id;
	}
	

}
