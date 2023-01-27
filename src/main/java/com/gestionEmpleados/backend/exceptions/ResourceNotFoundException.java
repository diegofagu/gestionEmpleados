package com.gestionEmpleados.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//excepciones personalizadas
//en resumen lo que hace es que si no existe un empleado va a llamar esta excepcion personalizada

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionID = 1L; //id de la clase

    public ResourceNotFoundException(String message){
        super(message);
    }


}
