package com.kuimov.pp.task314rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class UserGlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler
    public ResponseEntity<UsersIncorrectData> handleException(ResponseStatusException e) {
        UsersIncorrectData data = new UsersIncorrectData();
        data.setInfo(e.getMessage());
        if (e.getStatus().value() <= 451) {
            return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
        }
        if (e.getStatus().value() > 451) {
            return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(data, HttpStatus.SEE_OTHER);
    }
    @ExceptionHandler
    public ResponseEntity<UsersIncorrectData> handleException(Exception e) {
        UsersIncorrectData data = new UsersIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}

