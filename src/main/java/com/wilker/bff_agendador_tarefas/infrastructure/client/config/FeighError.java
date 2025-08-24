package com.wilker.bff_agendador_tarefas.infrastructure.client.config;

import com.wilker.bff_agendador_tarefas.infrastructure.exceptions.BussinessException;
import com.wilker.bff_agendador_tarefas.infrastructure.exceptions.ConflictException;
import com.wilker.bff_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.wilker.bff_agendador_tarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeighError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new ConflictException("Erro, atributo já existente");

            case 404:
                return new ResourceNotFoundException("Erro, atributo não encontrado");

            case 401:
                return new UnauthorizedException("Erro, usuário não autorizado");

            default:
                return new BussinessException("Erro, não tratado");
        }
    }
}
