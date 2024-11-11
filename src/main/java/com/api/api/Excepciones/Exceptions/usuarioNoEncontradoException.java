package com.api.api.Excepciones.Exceptions;

public class usuarioNoEncontradoException extends RuntimeException{
    public usuarioNoEncontradoException(){
        super("no se encontro el usuario");
    }
}
