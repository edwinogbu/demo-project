package com.example.demoproject.request;

import org.springframework.web.multipart.MultipartFile;

public class BlogRequest {
    private String title;
    private String content;
    private MultipartFile imageFile; // Use a MultipartFile for image upload
    private String category;
    private String author;

    // Getters and setters for the fields

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}



//
//import com.example.demoproject.model.Blog;
//import org.springframework.web.multipart.MultipartFile;
//
//import org.springframework.web.multipart.MultipartFile;
//
//public class BlogRequest {
//    private String title;
//    private String content;
//    private MultipartFile imageFile;
//    private String category;
//    private String author;
//
//    // Constructors, getters, and setters
//
//    public Blog toBlog() {
//        Blog blog = new Blog();
//        blog.setTitle(title);
//        blog.setContent(content);
//        blog.setCategory(category);
//        blog.setAuthor(author);
//        return blog;
//    }
//
//    // Getters and setters for other fields
//
//    public MultipartFile getImageFile() {
//        return imageFile;
//    }
//
//    public void setImageFile(MultipartFile imageFile) {
//        this.imageFile = imageFile;
//    }
//
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//}
