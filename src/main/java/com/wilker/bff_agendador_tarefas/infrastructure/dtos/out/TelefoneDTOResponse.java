package com.wilker.bff_agendador_tarefas.infrastructure.dtos.out;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TelefoneDTOResponse {

    private Long id;
    private String ddd;
    private String numero;


}
