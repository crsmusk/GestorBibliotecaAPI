package com.api.api.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(libroException.class)
  public ResponseEntity<Error>manejarLibroExcepcion(libroException ex){
   Error error=new Error(
    HttpStatus.BAD_REQUEST.value(),
    ex.getMessage(),
    System.currentTimeMillis()
   );
   return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(personaException.class)
  public ResponseEntity<Error>manejarPersonaExcepcion(personaException ex){
    Error error=new Error(
      HttpStatus.BAD_REQUEST.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(prestamoException.class)
  public ResponseEntity<Error>manejarPrestamoExcepcio(prestamoException ex){
    Error error=new Error(
      HttpStatus.BAD_REQUEST.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> manejarExcepcionGeneral(Exception ex) {
        Error error = new Error(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Ha ocurrido un error interno",
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(libroNoDisponibleException.class)
  public ResponseEntity<Error>manejarLibroNoDisponibleExcepcion(libroNoDisponibleException ex){
    Error error=new Error(
      HttpStatus.CONFLICT.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  }
}
