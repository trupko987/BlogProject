package blog.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.main.dao.BlogDAO;
import blog.main.dao.CategoryDAO;
import blog.main.dao.MessageDAO;
import blog.main.dao.SliderDAO;
import blog.main.dao.TagDAO;
import blog.main.entity.Blog;
import blog.main.entity.Category;
import blog.main.entity.Message;
import blog.main.entity.Slider;
import blog.main.entity.Tag;

@Controller
public class FrontController {
	
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private BlogDAO blogDAO;
	@Autowired
	private SliderDAO sliderDAO;
	@Autowired
	private TagDAO tagDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	
//	---------------------------------- FRONT HOMEPAGE ------------------------------------		
	
	@RequestMapping(value = "homepage")
	public String getHomepage(Model model) {
		
		List<Blog> blogsImportant = blogDAO.getBlogImportant();
		List<Blog> latestBlogs = blogDAO.getLatestBlogs();
		List<Slider> sliders = sliderDAO.getSliderList();
		List<Slider> orderSliders = sliderDAO.getOrderSliderList();
		List<Blog> lastThreeBlogs = blogDAO.getLastThreeBlogs();
		
		model.addAttribute("blogsImportant", blogsImportant);
		model.addAttribute("latestBlogs", latestBlogs);
		model.addAttribute("sliders", sliders);
		model.addAttribute("orderSliders", orderSliders);
		model.addAttribute("lastThreeBlogs", lastThreeBlogs);
	
		return "front-homepage";
	}
	
	
//	---------------------------------- CONTACT PAGE --------------------------------------		
	
	@RequestMapping(value = "/contact")
	public String getContactPage(Model model) {
		
		model.addAttribute("message", new Message());
		
		List<Blog> lastThreeBlogs = blogDAO.getLastThreeBlogs();
		
		model.addAttribute("lastThreeBlogs", lastThreeBlogs);
		
		return "front-contact-form";
	}
	
	@RequestMapping(value = "/contact-save")
	public String getContactSavePage(@ModelAttribute Message message) {
		
		messageDAO.saveMessage(message);
		
		return "redirect: contact";
	}
	
//	---------------------------------- BLOG ---------------------------------------------	
	
	@RequestMapping(value = "/blogs")
	public String getBlogListPage(Model model) {
		
		List<Blog> blogs = blogDAO.getBlogList();
		List<Blog> lastThreeBlogs = blogDAO.getLastThreeBlogs();
		List<Tag> tagsAside = tagDAO.getMostUsageTags();
		List<Category> categoriesOrder = categoryDAO.getCategoryOrderList();
		
		model.addAttribute("blog", blogs);
		model.addAttribute("lastThreeBlogs", lastThreeBlogs);
		model.addAttribute("tagsAside", tagsAside);
		model.addAttribute("categoriesOrder", categoriesOrder);

		return "front-blog-list";
	}
	
	@RequestMapping(value = "/blog-post")
	public String getBlogAdminDetail(@RequestParam int id, Model model) {
		
		Blog blog = blogDAO.getBlogById(id);
		List<Blog> lastThreeBlogs = blogDAO.getLastThreeBlogs();
		List<Tag> tagsAside = tagDAO.getMostUsageTags();
		List<Category> categoriesOrder = categoryDAO.getCategoryOrderList();
		
		model.addAttribute("blog", blog);
		model.addAttribute("lastThreeBlogs", lastThreeBlogs);
		model.addAttribute("tagsAside", tagsAside);
		model.addAttribute("categoriesOrder", categoriesOrder);
		
		return "front-blog-post";
	}
	
	@RequestMapping(value = "/blog-category")
	public String getCategoryListPage(@RequestParam int id, Model model) {
		
		List<Blog> categoryBlogs = blogDAO.getBlogsByCategory(id);
		List<Blog> lastThreeBlogs = blogDAO.getLastThreeBlogs();
		List<Tag> tagsAside = tagDAO.getMostUsageTags();
		List<Category> categoriesOrder = categoryDAO.getCategoryOrderList();
		
		model.addAttribute("categoryBlogs", categoryBlogs);
		model.addAttribute("lastThreeBlogs", lastThreeBlogs);
		model.addAttribute("tagsAside", tagsAside);
		model.addAttribute("categoriesOrder", categoriesOrder);
		
		model.addAttribute("name", blogDAO.getBlogById(id).getCategory().getName());
		
		return "blog-category";
		
	}
	
	@RequestMapping(value = "/blog-tag")
	public String getTagListPage(@RequestParam(required = false, value = "tags") Integer[] tagsArray, Model model) {
		
		List<Blog> tagBlogs = blogDAO.getBlogsByTag(tagsArray);
		List<Blog> lastThreeBlogs = blogDAO.getLastThreeBlogs();
		List<Tag> tagsAside = tagDAO.getMostUsageTags();
		List<Category> categoriesOrder = categoryDAO.getCategoryOrderList();
		
		model.addAttribute("tagBlogs", tagBlogs);
		model.addAttribute("lastThreeBlogs", lastThreeBlogs);
		model.addAttribute("tagsAside", tagsAside);
		model.addAttribute("categoriesOrder", categoriesOrder);
		
		if (tagsArray != null) {
			model.addAttribute("tagsSelected", Arrays.asList(tagsArray));
		}
		
		return "blog-tag";
		
	}
	
	@RequestMapping(value = "/blog-author")
	public String getAuthorListPage(@RequestParam int id, Model model) {
		
		List<Blog> authorBlogs = blogDAO.getBlogsByAuthor(id);
		List<Blog> lastThreeBlogs = blogDAO.getLastThreeBlogs();
		List<Tag> tagsAside = tagDAO.getMostUsageTags();
		List<Category> categoriesOrder = categoryDAO.getCategoryOrderList();
		
		model.addAttribute("authorBlogs", authorBlogs);
		model.addAttribute("lastThreeBlogs", lastThreeBlogs);
		model.addAttribute("tagsAside", tagsAside);
		model.addAttribute("categoriesOrder", categoriesOrder);
		
		model.addAttribute("name", blogDAO.getBlogById(id).getAuthor().getName());
		model.addAttribute("surname", blogDAO.getBlogById(id).getAuthor().getSurname());
		
		return "blog-author";
		
	}
	
	@RequestMapping(value = "/blog-search")
	public String getBlogSearchPage(@RequestParam String search, Model model) {
		
		List<Blog> blogSearch = blogDAO.getBlogsSearch(search);
		List<Blog> lastThreeBlogs = blogDAO.getLastThreeBlogs();
		List<Tag> tagsAside = tagDAO.getMostUsageTags();
		List<Category> categoriesOrder = categoryDAO.getCategoryOrderList();
		
		model.addAttribute("blogSearch", blogSearch);
		model.addAttribute("lastThreeBlogs", lastThreeBlogs);
		model.addAttribute("tagsAside", tagsAside);
		model.addAttribute("categoriesOrder", categoriesOrder);
				
		return "blog-search";
	}
	
}
