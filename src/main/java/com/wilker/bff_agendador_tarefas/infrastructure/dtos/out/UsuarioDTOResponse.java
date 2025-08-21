package com.wilker.bff_agendador_tarefas.infrastructure.dtos.out;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UsuarioDTOResponse {
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResponse> enderecos;
    private List<TelefoneDTOResponse> telefones;


}
