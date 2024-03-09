package com.example.user.CustomException;
import com.example.user.Response.ApiResponse;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalException {
        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<Object> handleNotFound() {
            ApiResponse<Object> apiResponse = new ApiResponse<>("Bad Request: The requested URL does not exists",400,true,null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }
        @ExceptionHandler(ConfigDataResourceNotFoundException.class)
        public ResponseEntity<Object> handleNotFounds() {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: The requested URL does not exist");
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleOtherExceptions(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + ex.getMessage());
        }
    }

