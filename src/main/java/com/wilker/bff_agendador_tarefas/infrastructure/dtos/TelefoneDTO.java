package com.wilker.bff_agendador_tarefas.infrastructure.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TelefoneDTO {

    private Long id;
    private String ddd;
    private String numero;


}
