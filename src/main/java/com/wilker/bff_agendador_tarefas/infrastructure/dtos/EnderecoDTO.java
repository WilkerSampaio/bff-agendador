package com.wilker.bff_agendador_tarefas.infrastructure.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EnderecoDTO {

    private Long id;
    private String rua;
    private String numero;
    private String complemento;
    private String estado;
    private String cidade;
    private String cep;
}
