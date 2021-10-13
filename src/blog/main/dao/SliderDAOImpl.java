package blog.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import blog.main.entity.Slider;

@Component
public class SliderDAOImpl implements SliderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Slider> getSliderList() {

		Session session = sessionFactory.getCurrentSession();
		List<Slider> sliders = session.createQuery("from Slider", Slider.class).getResultList();

		return sliders;
	}

	@Transactional
	@Override
	public void saveSlider(Slider slider) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(slider);
	}

	@Transactional
	@Override
	public Slider getSliderById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Slider slider = session.get(Slider.class, id);
		return slider;
	}

	@Transactional
	@Override
	public void deleteSlider(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Slider s where s.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	@Transactional
	@Override
	public List<Slider> getOrderSliderList() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Slider> orderSliders = session.createQuery("from Slider s order by s.ordering asc", Slider.class).setMaxResults(5).getResultList();
		
		return orderSliders;
	}

}
