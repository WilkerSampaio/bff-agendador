package com.wilker.bff_agendador_tarefas.service;

import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.TarefasDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.client.TarefaClient;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.in.TarefasDTORequest;
import com.wilker.bff_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefasService {

    private final TarefaClient tarefaClient;

    public TarefasDTOResponse salvarTarefa(TarefasDTORequest TarefasDTORequest, String token){
        return tarefaClient.registraTarefa(TarefasDTORequest, token);

    }

    public List<TarefasDTOResponse> buscaListaDeTarefaPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token){
     return tarefaClient.buscaListaDeTarefaPorPeriodo(dataInicial, dataFinal, token);

    }

    public List<TarefasDTOResponse> buscarTarefaPorEmail(String token){
        return tarefaClient.buscaTarefaPorEmail(token);

    }

    public void deletaTarefaPorId(String id, String token){
         tarefaClient.deletaTarefaPorId(id, token);

    }

    public TarefasDTOResponse alteraStatusTarefa(StatusNotificacaoEnum statusNotificacaoEnum, String id, String token){
      return tarefaClient.alterarStatusTarefa(statusNotificacaoEnum, id, token);

    }

    public TarefasDTOResponse alterarDadosTarefa(TarefasDTORequest TarefasDTORequest, String id, String token){
        return  tarefaClient.alterarDadosTarefa(TarefasDTORequest, id, token);

    }

}
