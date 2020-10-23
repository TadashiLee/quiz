package controller;

import dto.Error;
import exception.ProductExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlers {
    @ExceptionHandler(Exception.class)
    ResponseEntity<Error> handleException(Exception exception) {
        if (exception instanceof ProductExistException) {
            ProductExistException productExistException = (ProductExistException) exception;

            return ResponseEntity
                    .status(400)
                    .body(new Error(productExistException.getErrorMessage()));
        }

        return ResponseEntity
                .status(500)
                .body(new Error(exception.getMessage()));
    }
}
