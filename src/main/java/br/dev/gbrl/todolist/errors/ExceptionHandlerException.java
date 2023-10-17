package br.dev.gbrl.todolist.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerException {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadbleException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMostSpecificCause().getMessage());
    }
}
