package com.api.api.Excepciones.Exceptions;

public class permisoNoEncontradoException extends RuntimeException{
    public permisoNoEncontradoException(){
        super("permiso no encontrado");
    }
}
