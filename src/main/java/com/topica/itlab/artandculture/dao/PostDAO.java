package com.topica.itlab.artandculture.dao;

import com.topica.itlab.artandculture.model.Post;

import java.util.*;

public class PostDAO {
    private static final Map<String, Post> postMap = new HashMap<>();
    static {initPost();}
    private static void initPost(){
        Post post1 = new Post("1","images/thumbs/post/lamp-400.jpg","Design","3 Benefits of Minimalism In Interior Design.","June 15, 2018");
        Post post2 = new Post("2","images/thumbs/post/tulips-400.jpg","Health","10 Interesting Facts About Caffeine.","June 14, 2018");

        postMap.put(post1.getId(),post1);
        postMap.put(post2.getId(),post2);
    }
    public Post getPost(String key){
        return postMap.get(key);
    }
    public Post addPost(Post post) {
        postMap.put(post.getId(), post);
        return post;
    }

    public Post updatePost(Post post) {
        postMap.put(post.getId(),post);
        return post;
    }

    public void deletePost(String key) {
        postMap.remove(key);
    }

    public List<Post> getAllPosts() {
        Collection<Post> c = postMap.values();
        List<Post> list = new ArrayList<Post>();
        list.addAll(c);
        return list;
    }
}
