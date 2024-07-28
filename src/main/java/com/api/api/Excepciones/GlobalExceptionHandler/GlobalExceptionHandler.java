package com.api.api.Excepciones.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.api.Excepciones.ExceptionClass.Error;
import com.api.api.Excepciones.Exceptions.autorException;
import com.api.api.Excepciones.Exceptions.generoException;
import com.api.api.Excepciones.Exceptions.libroException;
import com.api.api.Excepciones.Exceptions.libroNoDisponibleException;
import com.api.api.Excepciones.Exceptions.personaException;
import com.api.api.Excepciones.Exceptions.prestamoException;

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
      HttpStatus.CONFLICT.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.CONFLICT);
  }

  
    @ExceptionHandler(libroNoDisponibleException.class)
  public ResponseEntity<Error>manejarLibroNoDisponibleExcepcion(libroNoDisponibleException ex){
    Error error=new Error(
      HttpStatus.CONFLICT.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.CONFLICT);
  }

  @ExceptionHandler(autorException.class)
  public ResponseEntity<Error>manejarAutorException(autorException ex){
    Error error=new Error(
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(generoException.class)
  public ResponseEntity<Error>manejarGeneroException(generoException ex){
    Error error=new Error(
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }
}
