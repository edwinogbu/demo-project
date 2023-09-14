package com.example.demoproject.service;

import com.example.demoproject.model.Blog;

import java.util.List;

public interface BlogService {

    Blog createBlog(Blog blog);

    Blog getBlogById(Long blogId);

    List<Blog> getAllBlogs();

    List<Blog> getBlogsByCategory(String category);

    Blog updateBlog(Long blogId, Blog updatedBlog);

    void deleteBlog(Long blogId);
}



//
//import com.example.demoproject.model.Blog;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//public interface BlogService {
//    Blog createBlog(Blog blog, MultipartFile imageFile) throws IOException;
//
//    Blog updateBlog(Long id, Blog updatedBlog);
//
//    List<Blog> getAllBlogs();
//
//    Blog getBlogById(Long id);
//
//    void deleteBlog(Long id);
//
//    void deleteImage(String imageFileName);
//}
//
//


//import com.example.demoproject.model.Blog;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//public interface BlogService {
//    Blog createBlog(Blog blog, MultipartFile imageFile) throws IOException;
//
//    Blog updateBlog(Long id, Blog updatedBlog);
//
//    List<Blog> getAllBlogs();
//
//    Blog getBlogById(Long id);
//
//    void deleteBlog(Long id);
//}
