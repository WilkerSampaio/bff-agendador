package com.wilker.bff_agendador_tarefas.infrastructure.dtos.in;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    private String email;
    private String senha;
}
