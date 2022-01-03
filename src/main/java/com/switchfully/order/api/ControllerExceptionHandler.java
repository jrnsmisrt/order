package com.switchfully.order.api;

import com.switchfully.order.security.exceptions.CustomerDoesNotExistException;
import com.switchfully.order.security.exceptions.ItemBasketIsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerDoesNotExistException.class)
    protected void CustomerDoesNotExist(CustomerDoesNotExistException ex,
                                        HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
    @ExceptionHandler({ItemBasketIsEmptyException.class})
    protected void itemBasketIsEmptyException(Exception exception, HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

}