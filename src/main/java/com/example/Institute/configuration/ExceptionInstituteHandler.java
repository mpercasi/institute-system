package com.example.Institute.configuration;

import com.example.Institute.exceptions.NoExistentCourse;
import com.example.Institute.exceptions.NonExistentStudentException;
import com.example.Institute.exceptions.StudentDuplicateException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInstituteHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NonExistentStudentException.class, NoExistentCourse.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Item not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({StudentDuplicateException.class})
    protected ResponseEntity<Object> handleDuplicate(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Item duplicated", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


}
