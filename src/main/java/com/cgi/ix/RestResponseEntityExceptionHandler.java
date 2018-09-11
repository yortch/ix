package com.cgi.ix;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    Logger logger = Logger.getLogger(RestResponseEntityExceptionHandler.class.getName());

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        String msg = String.format("Unexpected error: {0}", ex.getMessage());
        logger.log(Level.SEVERE, msg);
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}