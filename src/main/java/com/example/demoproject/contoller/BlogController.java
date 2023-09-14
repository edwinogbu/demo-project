package com.example.demoproject.contoller;


import com.example.demoproject.model.Blog;
import com.example.demoproject.model.ImageModel;
import com.example.demoproject.repository.BlogRepository;
import com.example.demoproject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("blogs")
@CrossOrigin("http://localhost:3000")
public class BlogController {


    @Autowired
    private final BlogService blogService;

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping(value = {"/create"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Blog createBlog(@RequestPart("blog") Blog blog, @RequestPart("imageFile") MultipartFile[] file){

        try {
                Set<ImageModel> images = uploadImage(file);
                blog.setBlogImages(images);
                return blogService.createBlog(blog);
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }
    }


    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();

        for (MultipartFile file: multipartFiles){;
          ImageModel imageModel = new ImageModel(
                  file.getOriginalFilename(),
                  file.getContentType(),
                  file.getBytes()
          );
           imageModels.add(imageModel);
        }

         return imageModels;
    }


//    @PostMapping("/create")
//    public ResponseEntity<?> createBlog(
//            @ModelAttribute BlogRequest blogRequest,
//            @RequestParam(name = "imageFile", required = false) MultipartFile imageFile) {
//
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createBlog(
//            @ModelAttribute BlogRequest blogRequest,
//            @RequestParam(name = "imageFile", required = false) MultipartFile imageFile) {
//        try {
//            Blog blog = new Blog();
//            blog.setTitle(blogRequest.getTitle());
//            blog.setContent(blogRequest.getContent());
//            blog.setCategory(blogRequest.getCategory());
//            blog.setAuthor(blogRequest.getAuthor());
//
//            Blog createdBlog = blogService.createBlog(blog, imageFile);
//            return ResponseEntity.ok(createdBlog);
//        } catch (IOException e) {
//            return ResponseEntity.badRequest().body("Failed to upload the image.");
//        }
//    }



//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBlog(@PathVariable Long id, @ModelAttribute BlogRequest blogRequest) {
//        // Find the existing blog by ID
//        Blog existingBlog = blogService.getBlogById(id);
//
//        if (existingBlog == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        // Validate and update the blog fields
//        if (!StringUtils.isEmpty(blogRequest.getTitle())) {
//            existingBlog.setTitle(blogRequest.getTitle());
//        }
//
//        if (!StringUtils.isEmpty(blogRequest.getContent())) {
//            existingBlog.setContent(blogRequest.getContent());
//        }
//
//        if (!StringUtils.isEmpty(blogRequest.getCategory())) {
//            existingBlog.setCategory(blogRequest.getCategory());
//        }
//
//        // Update the blog in the database
//        Blog updatedBlog = blogService.updateBlog(id, existingBlog);
//
//        return ResponseEntity.ok(updatedBlog);
//    }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateBlog(@PathVariable Long id, @ModelAttribute BlogRequest blogRequest) {
//        // Find the existing blog by ID
//        Blog existingBlog = blogService.getBlogById(id);
//
//        if (existingBlog == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        // Validate and update the blog fields
//        if (!StringUtils.isEmpty(blogRequest.getTitle())) {
//            existingBlog.setTitle(blogRequest.getTitle());
//        }
//
//        if (!StringUtils.isEmpty(blogRequest.getContent())) {
//            existingBlog.setContent(blogRequest.getContent());
//        }
//
//        if (!StringUtils.isEmpty(blogRequest.getCategory())) {
//            existingBlog.setCategory(blogRequest.getCategory());
//        }
//
//        // Update the blog in the database
//        Blog updatedBlog = blogService.updateBlog(id, existingBlog);
//
//        if (updatedBlog != null) {
//            return ResponseEntity.ok(updatedBlog);
//        } else {
//            return ResponseEntity.badRequest().body("Failed to update the blog.");
//        }
//    }
//
//
//    @GetMapping("/view")
//    public ResponseEntity<List<Blog>> getAllBlogs() {
//        List<Blog> blogs = blogService.getAllBlogs();
//        return ResponseEntity.ok(blogs);
//    }
//
//        @GetMapping("/view")
//    public List<Blog> getAllBlogs() {
//        return blogRepository.findAll();
//    }

//    @GetMapping("/view/{id}")
//    public ResponseEntity<?> getBlogById(@PathVariable Long id) {
//        Blog blog = blogService.getBlogById(id);
//
//        if (blog == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(blog);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteBlog(@PathVariable Long id) {
//        Blog blog = blogService.getBlogById(id);
//
//        if (blog == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        // Delete the image file associated with the blog
//        blogService.deleteImage(blog.getImage());
//
//        // Delete the blog from the database
//        blogService.deleteBlog(id);
//
//        return ResponseEntity.ok("Blog deleted successfully.");
//    }
}


//
//import com.example.demoproject.model.Blog;
//import com.example.demoproject.request.BlogRequest;
//import com.example.demoproject.service.BlogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/blogs")
//public class BlogController {
//
//    @Autowired
//    private final BlogService blogService;
//
//    @Autowired
//    public BlogController(BlogService blogService) {
//        this.blogService = blogService;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Blog> createBlog(@ModelAttribute BlogRequest blogRequest) {
//        try {
//            MultipartFile imageFile = blogRequest.getImageFile();
//            if (imageFile != null && !imageFile.isEmpty()) {
//                // Check if the file is an image
//                if (!StringUtils.hasText(imageFile.getContentType()) || !imageFile.getContentType().startsWith("image")) {
//                    return ResponseEntity.badRequest().body(null);
//                }
//            }
//
//            Blog blog = blogService.createBlog(blogRequest.toBlog(), imageFile);
//            return ResponseEntity.status(HttpStatus.CREATED).body(blog);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @ModelAttribute BlogRequest blogRequest) {
//        Blog updatedBlog = blogRequest.toBlog();
//        updatedBlog.setId(id);
//        Blog blog = blogService.updateBlog(id, updatedBlog);
//
//        if (blog == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(blog);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<List<Blog>> getAllBlogs() {
//        List<Blog> blogs = blogService.getAllBlogs();
//        return ResponseEntity.ok(blogs);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
//        Blog blog = blogService.getBlogById(id);
//
//        if (blog == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(blog);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
//        Blog blog = blogService.getBlogById(id);
//
//        if (blog == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        blogService.deleteBlog(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//
