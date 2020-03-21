package com.mounesh.root.exception.handler;

import com.mounesh.root.exception.CarNotFoundException;
import com.mounesh.root.exception.model.GenericErrorRepresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RootExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CarNotFoundException.class)
    public ResponseEntity<GenericErrorRepresenter> handleCarNotFound(CarNotFoundException exception){
         GenericErrorRepresenter error = new GenericErrorRepresenter(exception.getMessage(), 404, "");
         return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<GenericErrorRepresenter> handleAllExceptions(Exception exception){
        GenericErrorRepresenter error = new GenericErrorRepresenter(exception.getMessage(), 500, "");
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
