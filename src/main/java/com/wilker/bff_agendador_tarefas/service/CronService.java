package com.wilker.bff_agendador_tarefas.service;

import com.wilker.bff_agendador_tarefas.infrastructure.dtos.in.LoginRequestDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.TarefasDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CronService {
    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")

    public void buscaTarefaDaProximaHora(){
        String token = login(converterParaRequestDTO());
        log.info("iniciado a busca de tarefas");

       LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
       LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);
       List<TarefasDTOResponse> listaDeTarefas = tarefasService.buscaListaDeTarefaPorPeriodo(horaFutura, horaFuturaMaisCinco,
               token);

        log.info("tarefas encontradas " + listaDeTarefas);

        listaDeTarefas.forEach(tarefa -> {emailService.enviarEmail(tarefa);
            log.info("Email enviado para o usuário " + tarefa.getEmailUsuario());
            tarefasService.alteraStatusTarefa(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);});

        log.info("Finalizado a busca de tarefas");

    }

    public String login(LoginRequestDTO loginRequestDTO){
        return usuarioService.authenticarUsuario(loginRequestDTO);
    }

    public LoginRequestDTO converterParaRequestDTO(){
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }

}
