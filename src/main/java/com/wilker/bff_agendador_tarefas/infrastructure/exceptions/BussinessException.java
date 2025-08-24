package com.wilker.bff_agendador_tarefas.infrastructure.exceptions;

public class BussinessException extends RuntimeException {
    public BussinessException(String message) {
        super(message);
    }
}
