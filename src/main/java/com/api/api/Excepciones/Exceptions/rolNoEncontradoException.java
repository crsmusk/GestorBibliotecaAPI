package com.api.api.Excepciones.Exceptions;

public class rolNoEncontradoException extends RuntimeException {
    public rolNoEncontradoException(){
        super("rol no encontrado");
    }
}
