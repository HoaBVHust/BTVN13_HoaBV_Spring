package com.topica.itlab.artandculture.controller;

import com.topica.itlab.artandculture.dao.PostDAO;
import com.topica.itlab.artandculture.model.Category;
import com.topica.itlab.artandculture.model.Post;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostRestController {
    private PostDAO postDAO = new PostDAO();
    @RequestMapping(value = "/posts",
        method = RequestMethod.GET,
        produces = {MediaType.APPLICATION_JSON_VALUE
             //   , MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public List<Post> getPosts() {
        List<Post> list = postDAO.getAllPosts();
        return list;
    }

    @RequestMapping(value = "/{category}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE
                    //   , MediaType.APPLICATION_XML_VALUE
            })
    @ResponseBody
    public List<Post> getPostCategory(@PathVariable("category") String category) {
        List<Post> list = new ArrayList<>();
        for (Post post: postDAO.getAllPosts()
             ) {
            if(post.getCategory().equals(category)){
                list.add(post);
            }
        }
        return list;
    }

    @RequestMapping(value = "/post/{key}",
    method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE
         //   , MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public Post getPost(@PathVariable("key") String key) {

        return postDAO.getPost(key);
    }
    @RequestMapping(value = "/category/{key}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE
                    //   , MediaType.APPLICATION_XML_VALUE
            })
    @ResponseBody
    public Category getCategory(@PathVariable("key") String key) {

        return postDAO.getCategory(key);
    }

    @RequestMapping(value = "/post",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE
                   // , MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public Post addPost(@RequestBody Post post) {

        System.out.println("(Service Side) Creating employee: " + post.getId());

        return postDAO.addPost(post);
    }

    @RequestMapping(value = "/post", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE
             //       , MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public Post updatePost(@RequestBody Post post) {

        System.out.println("(Service Side) Editing employee: " + post.getId());

        return postDAO.updatePost(post);
    }

    @RequestMapping(value = "/post/{key}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE
              //      , MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public void deletePost(@PathVariable("key") String key) {

        System.out.println("(Service Side) Deleting post: " + key);

        postDAO.deletePost(key);
    }
}
