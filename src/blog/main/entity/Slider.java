package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sliders")
public class Slider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String image;
	@Column
	private String title;
	@Column
	private String url;
	@Column(name = "button_title")
	private String buttonTitle;
	@Column
	private int ordering;
	
	public Slider() {
		
	}

	public Slider(int id, String image, String title, String url, String buttonTitle, int ordering) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.url = url;
		this.buttonTitle = buttonTitle;
		this.ordering = ordering;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getButtonTitle() {
		return buttonTitle;
	}

	public void setButtonTitle(String buttonTitle) {
		this.buttonTitle = buttonTitle;
	}
	
	
	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int ordering) {
		this.ordering = ordering;
	}

	@Override
	public String toString() {
		
		return title+" - "+id;
	}

}
