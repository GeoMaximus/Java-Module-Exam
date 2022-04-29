package com.example.demo.exam.config;

import com.example.demo.exam.config.exceptions.ClientAlreadyExistsException;
import com.example.demo.exam.config.exceptions.InvalidClientException;
import com.example.demo.exam.config.exceptions.NoClientsFoundException;
import com.example.demo.exam.config.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity<?> handleClientAlreadyExists(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({InvalidClientException.class})
    public ResponseEntity<?> handleInvalidClientException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({NoClientsFoundException.class})
    public ResponseEntity<?> handleNoClientsFound(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
