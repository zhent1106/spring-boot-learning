package com.soft1851.springboot.verification.handler;

import com.soft1851.springboot.verification.controller.PersonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExceptionHandler
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/30
 **/
@ControllerAdvice(assignableTypes = {PersonController.class})
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=((FieldError) error).getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstrainViolationException(ConstraintViolationException e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}