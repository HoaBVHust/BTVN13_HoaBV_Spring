package com.topica.itlab.artandculture.dao;

import com.topica.itlab.artandculture.model.Category;
import com.topica.itlab.artandculture.model.Post;

import java.util.*;

public class PostDAO {
    private static final Map<String, Post> postMap = new HashMap<>();
    private static final Map<String ,Category> categoryMap = new HashMap<>();
    static {initPost();}
    static {initCategory();}
    private static void initPost(){
        Post post0 = new Post("0","images/thumbs/post/lamp-400.jpg","Design","3 Benefits of Minimalism In Interior Design.","June 15, 2018");
        Post post1 = new Post("1","images/thumbs/post/tulips-400.jpg","Health","10 Interesting Facts About Caffeine.","June 14, 2018");
        Post post2 = new Post("2","images/thumbs/post/music-400.jpg","Health","The Power of Music to Reduce Stress.","June 14, 2018");
        Post post3 = new Post("3","images/thumbs/post/watch-400.jpg","Management","The Pomodoro Technique Really Works.","June 12, 2018");
        Post post4 = new Post("4","images/thumbs/post/wheel-400.jpg","Lifestyle","Visiting Theme Parks Improves Your Health.","June 12, 2017");
        Post post5 = new Post("5","images/thumbs/post/guitarist-400.jpg","Music","What Your Music Preference Says About You and Your Personality.","June 02, 2018");
        Post post6 = new Post("6","images/thumbs/post/jump-400.jpg","Relationships","Create Meaningful Family Moments.","June 02, 2018");
        Post post7 = new Post("7","images/thumbs/post/flowers-400.jpg","Lifestyle","Gardening: The Secret to Happiness.","June 01, 2018");
        Post post8 = new Post("8","images/thumbs/post/woodcraft-400.jpg","Creativity","An Examination of Minimalistic Design.","May 30, 2018");
        Post post9 = new Post("9","images/thumbs/post/fuji-400.jpg","Creativity","What Skills Are Required For a Photographer?","May 30, 2018");
        Post post10 = new Post("10","images/thumbs/post/beetle-400.jpg","Lifestyle","Throwback To The Good Old Days.","May 28, 2018");
        Post post11 = new Post("11","images/thumbs/post/sydney-400.jpg","Travel","Planning Your First Trip To Sydney.","May 28, 2018");
        postMap.put(post0.getId(),post0);
        postMap.put(post1.getId(),post1);
        postMap.put(post2.getId(),post2);
        postMap.put(post3.getId(),post3);
        postMap.put(post4.getId(),post4);
        postMap.put(post5.getId(),post5);
        postMap.put(post6.getId(),post6);
        postMap.put(post7.getId(),post7);
        postMap.put(post8.getId(),post8);
        postMap.put(post9.getId(),post9);
        postMap.put(post10.getId(),post10);
        postMap.put(post11.getId(),post11);

    }
    private static void initCategory(){
        Category category0 = new Category("Lifestyle","Dolor similique vitae. Exercitationem quidem occaecati iusto. Id non vitae enim quas error dolor maiores ut. Exercitationem earum ut repudiandae optio veritatis animi nulla qui dolores.");
        Category category1 = new Category("Health","THis is description of Health" );
        Category category2 = new Category("Family","THis is description of Family" );
        Category category3 = new Category("Management","THis is description of Management" );
        Category category4 = new Category("Travel","THis is description of Travel" );
        Category category5 = new Category("Work","THis is description of Work" );
        categoryMap.put(category0.getName(),category0);
        categoryMap.put(category1.getName(),category1);
        categoryMap.put(category2.getName(),category2);
        categoryMap.put(category3.getName(),category3);
        categoryMap.put(category4.getName(),category4);
        categoryMap.put(category5.getName(),category5);
    }
    public Post getPost(String key){
        return postMap.get(key);
    }
    public Category getCategory(String key){
        return categoryMap.get(key);
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
