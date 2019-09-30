package com.topica.itlab.artandculture.controller;

import com.google.gson.Gson;
import com.topica.itlab.artandculture.dao.PostDAO;
import com.topica.itlab.artandculture.model.Category;
import com.topica.itlab.artandculture.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

@Controller
public class HomeController {
	private PostDAO postDAO=new PostDAO();
	private PostRestController postRestController = new PostRestController();
	private String url = "http://localhost:8080/";

	@RequestMapping(value="/")
	public String home(ModelMap modelMap) {
		try {
			URL urlObject = new URL(url+"posts");
			InputStream in = urlObject.openStream();
			String json = new String(in.readAllBytes());
			List<Post> list = new Gson().fromJson(json, List.class);
			modelMap.put("list",list);
		}
		catch (Exception e){
			e.printStackTrace();
		}

		return "index";
	}
    @RequestMapping(value="/category"+"{category}")
    public String category(ModelMap modelMap,@PathVariable("category")String category) {
	    try {
            URL urlObject = new URL(url+category);
            InputStream in = urlObject.openStream();
            String json = new String(in.readAllBytes());
            List<Post> list = new Gson().fromJson(json, List.class);
            modelMap.put("list",list);
            in.close();
			URL urlObject2 = new URL(url+"category/"+category);
			InputStream in2 = urlObject2.openStream();
			String json2 = new String(in2.readAllBytes());
			Category cate = new Gson().fromJson(json2, Category.class);
			modelMap.put("cate",cate);
			in.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "category";
    }
	@RequestMapping(value="/styles",method = RequestMethod.GET)
	public String styles() {
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
