package blog.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.main.dao.AuthorDAO;
import blog.main.dao.BlogDAO;
import blog.main.dao.CategoryDAO;
import blog.main.dao.MessageDAO;
import blog.main.dao.SliderDAO;
import blog.main.dao.TagDAO;
import blog.main.entity.Author;
import blog.main.entity.Blog;
import blog.main.entity.Category;
import blog.main.entity.Message;
import blog.main.entity.Slider;
import blog.main.entity.Tag;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private TagDAO tagDAO;
	@Autowired
	private BlogDAO blogDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private SliderDAO sliderDAO;
	@Autowired
	private AuthorDAO authorDAO;
	
//	---------------------------------- ADMIN HOMEPAGE ------------------------------------	
	
	@RequestMapping(value = "/")
	public String getAdminHomepage(Model model) {
		
		long unreadMessagesCounter = messageDAO.getUnreadMessagesCount();
		
		model.addAttribute("unreadMessagesCounter", unreadMessagesCounter);
		
		return "admin-homepage";
	}
	
//	---------------------------------- CATEGORY ------------------------------------------
	
	@RequestMapping(value = "category-list")
	public String getCategoryList(@RequestParam int id, Model model) {
		
		List<Category> list = categoryDAO.getCategoryList();
		model.addAttribute("categories", list);
		
		int numberOfBlogs = categoryDAO.getNumberOfBlogsForCategory(id);
		model.addAttribute("numberOfBlogs", numberOfBlogs);
		
		return "category-list";
	}
	
	@RequestMapping(value = "category-form")
	public String getCategoryForm(Model model) {
		
		model.addAttribute("category", new Category());
		
		return "category-form";
	}
	
	@RequestMapping(value = "category-save")
	public String getCategorySave(@ModelAttribute Category category) {
		
		categoryDAO.saveCategory(category);
		
		return "redirect: category-list";
	}
	
	@RequestMapping(value = "category-update")
	public String getCategoryUpdate(@RequestParam int id, Model model) {
		
		Category category = categoryDAO.getCategoryById(id);
		model.addAttribute("category", category);
		
		return "category-form";
	}
	
	@RequestMapping(value = "category-delete")
	public String getCategoryDelete(@RequestParam int id) {
		
		categoryDAO.deleteCategory(id);
		
		return "redirect: category-list";
	}
	
	@RequestMapping( value = "category-enabled")
	public String getCategoryEnabled(@RequestParam int id) {
		
		Category category = categoryDAO.getCategoryById(id);
		category.setEnabled(!category.getEnabled());
		categoryDAO.saveCategory(category);
		
		return "redirect: category-list";
	}
	
//	@RequestMapping(value = "category-number-blogs")
//	public String getNumberOfBlogs(@RequestParam int id, Model model) {
//		
//		int numberOfBlogs = categoryDAO.getNumberOfBlogsForCategory(id);
//		
//		model.addAttribute("numberOfBlogs", numberOfBlogs);
//		
//		return "redirect: category-list";
//	}
	
//	---------------------------------- TAG -----------------------------------------------
		
	@RequestMapping(value = "tag-list")
	public String getTagList(Model model) {
		
		List<Tag> tags = tagDAO.getTagList();
		model.addAttribute("tags", tags);
		
		return "tag-list";
	}
	
	@RequestMapping(value = "tag-form")
	public String getTagForm(Model model) {
		
		model.addAttribute("tag", new Tag());
		
		return "tag-form";
	}
	
	@RequestMapping(value = "tag-save")
	public String getTagSave(@ModelAttribute Tag tag) {
		
		tagDAO.saveTag(tag);
		
		return "redirect: tag-list";
	}
	
	@RequestMapping(value = "tag-update")
	public String getTagUpdate(@RequestParam int id, Model model) {
		
		Tag tag = tagDAO.getTagById(id);
		model.addAttribute("tag", tag);
		
		return "tag-form";
	}
	
	@RequestMapping(value = "tag-delete")
	public String getTagDelete(@RequestParam int id) {
		
		tagDAO.deleteTag(id);
		
		return "redirect: tag-list";
	}
	
//	---------------------------------- BLOG ----------------------------------------------
	
	@RequestMapping(value = "blog-list")
	public String getBlogList(Model model) {
		
		List<Blog> blog = blogDAO.getBlogList();
		model.addAttribute("blogs", blog);
		
//		List<Category> categoryFilter = categoryDAO.getCategoryList();
//		model.addAttribute("categoryFilter", categoryFilter);

		return "blog-list";
	}
	
	@RequestMapping(value = "blog-form")
	public String getBlogForm(Model model) {
		
		List<Category> categories = categoryDAO.getCategoryList();
		List<Tag> tags = tagDAO.getTagList();
		model.addAttribute("blog", new Blog());
		model.addAttribute("categories", categories);
		model.addAttribute("tags", tags);
		
		return "blog-form";
	}
	
	@RequestMapping(value = "blog-save")
	public String getBlogSave(@ModelAttribute Blog blog) {
		
		Category category = categoryDAO.getCategoryById(blog.getCategory().getId());
		List<Tag> tags = new ArrayList<Tag>();
		
		for(Tag tag : blog.getTags()) {
			Tag tempTag = tagDAO.getTagById(tag.getId());
			tags.add(tempTag);
		}
		
		blog.setCategory(category);
		blog.setTags(tags);
		blogDAO.saveBlog(blog);
		
		return "redirect: blog-list";
	}
	
	@RequestMapping(value = "blog-update")
	public String getBlogUpdate(@RequestParam int id, Model model) {
		
		Blog blog = blogDAO.getBlogById(id);
		List<Category> categories = categoryDAO.getCategoryList();
		List<Tag> tags = tagDAO.getTagList();
		model.addAttribute("blog", blog);
		model.addAttribute("categories", categories);
		model.addAttribute("tags", tags);
		
		return "blog-form";
	}
	
	@RequestMapping(value = "blog-delete")
	public String getBlogDelete(@RequestParam int id) {
		
		blogDAO.deleteBlog(id);
		
		return "redirect: blog-list";
	}
	
	@RequestMapping(value = "blog-admin-detail")
	public String getBlogAdminDetail(@RequestParam int id, Model model) {
		
		Blog blog = blogDAO.getBlogById(id);
		model.addAttribute("blog", blog);
		
		return "blog-admin-detail";
	}
	
	@RequestMapping( value = "blog-enabled")
	public String getBlogEnabled(@RequestParam int id) {
		
		Blog blog = blogDAO.getBlogById(id);
		blog.setEnabled(!blog.getEnabled());
		blogDAO.saveBlog(blog);
		
		return "redirect: blog-list";
	}
	
//	---------------------------------- MESSAGES ------------------------------------------	

	@RequestMapping(value = "message-list")
	public String getMessageList(Model model) {
		
		List<Message> messages = messageDAO.getAllMessages();
		model.addAttribute("messages", messages);
		
		return "message-list";
	}
	
	@RequestMapping(value = "message-seen")
	public String getMessagenSeenPage(@RequestParam int id) {
		
		Message message = messageDAO.getMessageById(id);
		message.setIsSeen(true);
		messageDAO.saveMessage(message);
		
		return "redirect: message-list";
	}
	

//	---------------------------------- SLIDERS -------------------------------------------	
	
	@RequestMapping(value = "slider-list")
	public String getSliderList(Model model) {
		
		List<Slider> sliders = sliderDAO.getSliderList();
		model.addAttribute("sliders", sliders);
		return "slider-list";
	}
	
	@RequestMapping(value = "slider-form")
	public String getSliderFormPage(Model model) {
		
		model.addAttribute("slider", new Slider());
		return "slider-form";
	}
	
	@RequestMapping(value = "slider-save")
	public String getSliderSave(@ModelAttribute Slider slider) {
		
		sliderDAO.saveSlider(slider);
		return "redirect: slider-list";
	}
	
	@RequestMapping(value = "slider-update")
	public String getSliderUpdate(@RequestParam int id, Model model) {
		
		Slider slider = sliderDAO.getSliderById(id);
		model.addAttribute("slider", slider);
		
		return "slider-form";
	}
	
	@RequestMapping(value = "slider-delete")
	public String getDeleteSlider(@RequestParam int id) {
		
		sliderDAO.deleteSlider(id);
		return "redirect: slider-list";
	}
	
//	---------------------------------- AUTHORS -------------------------------------------	
	
	@RequestMapping(value = "author-list")
	public String getAuthorList(Model model) {
		
		List<Author> authors = authorDAO.getAuthorList();
		model.addAttribute("author", authors);
		return "author-list";
	}
	
	@RequestMapping(value = "author-save")
	public String getAuthorSave(@ModelAttribute Author author) {
		
		authorDAO.saveAuthor(author);
		
		return "redirect: author-list";
	}
	
	@RequestMapping(value = "author-form")
	public String getAuthorForm(Model model) {
		
		model.addAttribute("author", new Author());
		
		return "author-form";
	}
	
	@RequestMapping(value = "author-update")
	public String getAuthorUpdate(@RequestParam int id, Model model) {
		
		Author author = authorDAO.getAuthorById(id);
		model.addAttribute("author", author);
		
		return "author-form";
	}
	
	@RequestMapping(value = "author-delete")
	public String getAuthorDelete(@RequestParam int id) {
		
		authorDAO.deleteAuthor(id);
		
		return "redirect: author-list";
	}
	
	@RequestMapping( value = "author-enabled")
	public String getAuthorEnabled(@RequestParam int id) {
		
		Author author = authorDAO.getAuthorById(id);
		author.setEnabled(!author.getEnabled());
		authorDAO.saveAuthor(author);
		
		return "redirect: author-list";
	}
	
}
