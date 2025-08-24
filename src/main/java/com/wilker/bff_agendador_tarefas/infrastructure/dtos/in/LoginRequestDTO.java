package com.wilker.bff_agendador_tarefas.infrastructure.dtos.in;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoginRequestDTO {
    private String email;
    private String senha;
}
