package com.api.api.Excepciones.GlobalExceptionHandler;

import com.api.api.Excepciones.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.api.Excepciones.ExceptionClass.Error;

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
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
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

  @ExceptionHandler(prestamoAtrasadoException.class)
    public ResponseEntity<Error>manejarPrestamoAtrasadoException(prestamoAtrasadoException ex){
      Error error=new Error(
              HttpStatus.CONFLICT.value(),
              ex.getMessage(),
              System.currentTimeMillis()
      );
      return new ResponseEntity<>(error,HttpStatus.CONFLICT);
  }

    @ExceptionHandler(noHayContenidoException.class)
    public ResponseEntity<Error>manejarNoHayContenidoException(noHayContenidoException ex){
        Error error=new Error(
                HttpStatus.NO_CONTENT.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(usuarioNoEncontradoException.class)
    public ResponseEntity<Error>manejarUsuarioNoEncontradoException(usuarioNoEncontradoException ex){
        Error error=new Error(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(rolNoEncontradoException.class)
    public ResponseEntity<Error>manejarRolNoEncontradoException(rolNoEncontradoException ex){
     Error error=new Error(
             HttpStatus.NOT_FOUND.value(),
             ex.getMessage(),
             System.currentTimeMillis()
     );
     return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(permisoNoEncontradoException.class)
    public ResponseEntity<Error>manejarPermisoNoEncontradoException(permisoNoEncontradoException ex){
     Error error=new Error(
             HttpStatus.NOT_FOUND.value(),
             ex.getMessage(),
             System.currentTimeMillis()
     );
     return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
