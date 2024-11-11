package com.api.api.Excepciones.Exceptions;

public class noHayContenidoException extends RuntimeException{
    public noHayContenidoException(){
        super("no hay contenido");
    }
}
