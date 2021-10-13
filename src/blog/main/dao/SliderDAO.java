package blog.main.dao;

import java.util.List;

import blog.main.entity.Slider;

public interface SliderDAO {
	
	public List<Slider> getSliderList();
	public void saveSlider(Slider slider);
	public Slider getSliderById(int id);
	public void deleteSlider(int id);
	public List<Slider> getOrderSliderList();

}
