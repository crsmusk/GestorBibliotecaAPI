package com.api.api.Excepciones;

public class libroNoDisponibleException extends RuntimeException {
   public libroNoDisponibleException(String mensaje){
    super("libro no disponible");
   }
}
