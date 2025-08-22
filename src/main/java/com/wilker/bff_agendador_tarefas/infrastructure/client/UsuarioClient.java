package com.wilker.bff_agendador_tarefas.infrastructure.client;

import com.wilker.bff_agendador_tarefas.infrastructure.dtos.in.*;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.EnderecoDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.TelefoneDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.TokenDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @PostMapping
    UsuarioDTOResponse registraUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest);

    @PostMapping("/login")
    TokenDTOResponse authenticarUsuario(@RequestBody LoginRequest loginRequest);

    @GetMapping
    UsuarioDTOResponse buscarUsuarioPeloEmail(@RequestParam("email") String email,
                                              @RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deletaUsuarioPeloEmail(@PathVariable String email,
                                                       @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizarDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest,
                                             @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco(@RequestBody EnderecoDTORequest enderecoDTORequest,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizarTelefone(@RequestBody TelefoneDTORequest telefoneDTORequest,
                                          @RequestParam ("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastrarEndereco (@RequestBody EnderecoDTORequest enderecoDTORequest,
                                           @RequestHeader ("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastrarTelefone(@RequestBody TelefoneDTORequest telefoneDTORequest,
                                          @RequestHeader ("Authorization") String token);

}
