package com.example.demoproject.service;


import com.example.demoproject.exception.BlogNotFoundException;
import com.example.demoproject.model.Blog;
import com.example.demoproject.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(Long blogId) {
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog with id: " +blogId + "Found"));
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> getBlogsByCategory(String category) {
        return blogRepository.findByCategory(category);
    }

    @Override
    public Blog updateBlog(Long blogId, Blog updatedBlog) {
        Blog existingBlog = getBlogById(blogId);
        // Update the existing blog with data from updatedBlog
        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setContent(updatedBlog.getContent());
        existingBlog.setCategory(updatedBlog.getCategory());
        existingBlog.setAuthor(updatedBlog.getAuthor());
        existingBlog.setBlogImages(updatedBlog.getBlogImages());

        return blogRepository.save(existingBlog);
    }

    @Override
    public void deleteBlog(Long blogId) {
        Blog blogToDelete = getBlogById(blogId);
        blogRepository.delete(blogToDelete);
    }
}


//
//import com.example.demoproject.exception.BlogNotFoundException;
//import com.example.demoproject.model.Blog;
//import com.example.demoproject.repository.BlogRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BlogServiceImpl implements BlogService {
//
//    @Autowired
//    private final BlogRepository blogRepository;
//    private static final String IMAGE_UPLOAD_DIR = "images/";
//
//    @Autowired
//    public BlogServiceImpl(BlogRepository blogRepository) {
//        this.blogRepository = blogRepository;
//    }
//
//    @Override
//    public Blog createBlog(Blog blog, MultipartFile imageFile) throws IOException {
//        if (imageFile != null && !imageFile.isEmpty()) {
//            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
//
//            // Create the image upload directory if it doesn't exist
//            Path uploadPath = Path.of(IMAGE_UPLOAD_DIR);
//
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            try {
//                Path filePath = uploadPath.resolve(fileName);
//                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//                blog.setImage(fileName);
//            } catch (IOException ex) {
//                throw new IOException("Could not save image: " + fileName, ex);
//            }
//        }
//
//        return blogRepository.save(blog);
//    }
//
//    @Override
//    public Blog updateBlog(Long id, Blog updatedBlog) {
//        Optional<Blog> existingBlogOptional = blogRepository.findById(id);
//
//        if (existingBlogOptional.isPresent()) {
//            Blog existingBlog = existingBlogOptional.get();
//
//            // Update the fields of the existing blog
//            existingBlog.setTitle(updatedBlog.getTitle());
//            existingBlog.setContent(updatedBlog.getContent());
//            existingBlog.setCategory(updatedBlog.getCategory());
//            existingBlog.setAuthor(updatedBlog.getAuthor());
//
//            return blogRepository.save(existingBlog);
//        } else {
//            throw new BlogNotFoundException(id);
//        }
//    }
//
//    @Override
//    public List<Blog> getAllBlogs() {
//
//        return blogRepository.findAll();
//    }
//
//    @Override
//    public Blog getBlogById(Long id) {
//        return blogRepository.findById(id)
//                .orElseThrow(() -> new BlogNotFoundException(id));
//    }
//
//    @Override
//    public void deleteBlog(Long id) {
//        Blog blog = getBlogById(id);
//        deleteImage(blog.getImage());
//        blogRepository.deleteById(id);
//    }
//
//    @Override
//    public void deleteImage(String imageFileName) {
//        if (imageFileName != null) {
//            try {
//                Path imagePath = Path.of(IMAGE_UPLOAD_DIR).resolve(imageFileName);
//                Files.deleteIfExists(imagePath);
//            } catch (IOException e) {
//                // Handle the exception as needed
//            }
//        }
//    }
//}
//


//import com.example.demoproject.model.Blog;
//import com.example.demoproject.repository.BlogRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.util.StringUtils;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BlogServiceImpl implements BlogService {
//    private final BlogRepository blogRepository;
//
//    @Autowired
//    public BlogServiceImpl(BlogRepository blogRepository) {
//        this.blogRepository = blogRepository;
//    }
//
//    @Override
//    public Blog createBlog(Blog blog, MultipartFile imageFile) throws IOException {
//        if (imageFile != null && !imageFile.isEmpty()) {
//            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
//            String uploadDir = "images/";
//
//            Path uploadPath = Path.of(uploadDir);
//
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            try {
//                Path filePath = uploadPath.resolve(fileName);
//                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//                blog.setImage(fileName);
//            } catch (IOException ex) {
//                throw new IOException("Could not save image: " + fileName, ex);
//            }
//        }
//
//        return blogRepository.save(blog);
//    }
//
//    @Override
//    public Blog updateBlog(Long id, Blog updatedBlog) {
//        Optional<Blog> optionalBlog = blogRepository.findById(id);
//
//        if (optionalBlog.isPresent()) {
//            Blog existingBlog = optionalBlog.get();
//
//            // Update the fields you want to change
//            if (updatedBlog.getTitle() != null) {
//                existingBlog.setTitle(updatedBlog.getTitle());
//            }
//
//            if (updatedBlog.getContent() != null) {
//                existingBlog.setContent(updatedBlog.getContent());
//            }
//
//            if (updatedBlog.getCategory() != null) {
//                existingBlog.setCategory(updatedBlog.getCategory());
//            }
//
//            // Save the updated blog
//            return blogRepository.save(existingBlog);
//        } else {
//            // Blog not found
//            return null;
//        }
//    }
//
//    @Override
//    public List<Blog> getAllBlogs() {
//        return blogRepository.findAll();
//    }
//
//    @Override
//    public Blog getBlogById(Long id) {
//        return blogRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void deleteBlog(Long id) {
//        blogRepository.deleteById(id);
//    }
//}


//
//import com.example.demoproject.exception.BlogNotFoundException;
//import com.example.demoproject.model.Blog;
//import com.example.demoproject.repository.BlogRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.util.StringUtils;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//
//@Service
//public class BlogServiceImpl implements BlogService {
//    private final BlogRepository blogRepository;
//
//    @Autowired
//    public BlogServiceImpl(BlogRepository blogRepository) {
//        this.blogRepository = blogRepository;
//    }
//
//    @Override
//    public Blog createBlog(Blog blog, MultipartFile imageFile) throws IOException {
//        if (imageFile != null && !imageFile.isEmpty()) {
//            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
//            String uploadDir = "images/";
//
//            Path uploadPath = Path.of(uploadDir);
//
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            try {
//                Path filePath = uploadPath.resolve(fileName);
//                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//                blog.setImage(fileName);
//            } catch (IOException ex) {
//                throw new IOException("Could not save image: " + fileName, ex);
//            }
//        }
//
//        return blogRepository.save(blog);
//    }
//
//
//
//    @Override
//    public Blog updateBlog(Long id, Blog updatedBlog) {
//        // Check if the blog entry with the given ID exists
//        Blog existingBlog = blogRepository.findById(id)
//                .orElseThrow(() -> new BlogNotFoundException(id));
//
//        // Update the existing blog entry with the values from updatedBlog
//        existingBlog.setTitle(updatedBlog.getTitle());
//        existingBlog.setContent(updatedBlog.getContent());
//
//        // Save the updated blog entry
//        return blogRepository.save(existingBlog);
//    }
//
//    @Override
//    public List<Blog> getAllBlogs() {
//        return blogRepository.findAll();
//    }
//
//    @Override
//    public Blog getBlogById(Long id) {
//        // Retrieve a blog entry by ID from the repository
//        return blogRepository.findById(id)
//                .orElseThrow(() -> new BlogNotFoundException(id));
//    }
//
//    @Override
//    public void deleteBlog(Long id) {
//        // Check if the blog entry with the given ID exists
//        Blog existingBlog = blogRepository.findById(id)
//                .orElseThrow(() -> new BlogNotFoundException(id));
//
//        // Delete the blog entry
//        blogRepository.delete(existingBlog);
//    }
//
//
//
//}
