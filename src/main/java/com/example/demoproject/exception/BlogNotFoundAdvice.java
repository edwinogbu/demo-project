package com.example.demoproject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BlogNotFoundAdvice {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<Object> handleBlogNotFoundException(BlogNotFoundException ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}


//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class BlogNotFoundAdvice {
//
//    @ResponseBody
//    @ExceptionHandler(BlogNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Map<String, String> exceptionHandler(BlogNotFoundException exception){
//        Map<String, String> errorMap=new HashMap<>();
//        errorMap.put("errorMessage",exception.getMessage());
//
//        return  errorMap;
//    }
//
//}
