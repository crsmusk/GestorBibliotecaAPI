package com.api.api.Excepciones.Exceptions;

public class libroNoDisponibleException extends RuntimeException {
   public libroNoDisponibleException(String mensaje){
    super("libro no disponible");
   }
}
