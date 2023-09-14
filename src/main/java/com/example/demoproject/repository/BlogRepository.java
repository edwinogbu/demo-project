package com.example.demoproject.repository;

import com.example.demoproject.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    // Custom query method to find blogs by category
    List<Blog> findByCategory(String category);
}


//
//import com.example.demoproject.model.Blog;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface BlogRepository extends JpaRepository<Blog, Long > {
//    Blog save(Blog blog);
//
//    // Method to retrieve a blog entry by ID
//    Optional<Blog> findById(Long id);
//
//    // Method to delete a blog entry by ID
//    void deleteById(Long id);
//
//}
