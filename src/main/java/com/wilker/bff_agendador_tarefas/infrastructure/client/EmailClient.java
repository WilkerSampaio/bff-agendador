package com.wilker.bff_agendador_tarefas.infrastructure.client;

import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "notificacao", url ="${notificao.url}")
public interface EmailClient {

    public void enviarEmail(TarefasDTOResponse tarefasDTOResponse);
}
