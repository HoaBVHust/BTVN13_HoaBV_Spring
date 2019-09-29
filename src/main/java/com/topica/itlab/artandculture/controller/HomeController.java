package com.topica.itlab.artandculture.controller;

import com.topica.itlab.artandculture.dao.PostDAO;
import com.topica.itlab.artandculture.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class HomeController {
	private PostDAO postDAO=new PostDAO();
	private PostRestController postRestController = new PostRestController();

	@RequestMapping(value="/")
	public String home(ModelMap modelMap) {
		modelMap.put("haha","");
		return "index";
	}
	@RequestMapping(value="/styles",method = RequestMethod.GET)
	public String styles(ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView("style-guide");
		modelMap.put("gaga",new Post("1","sfsf","sf","sdfsd","fsd"));
		modelMap.put("haha",postDAO.getPost("1"));
		modelAndView.addObject("ll","sdfsdf");
		return "style-guide";
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView moderAndView = new ModelAndView("page-about");
		return moderAndView;
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView moderAndView = new ModelAndView("page-contact");
		return moderAndView;
	}
	
}
