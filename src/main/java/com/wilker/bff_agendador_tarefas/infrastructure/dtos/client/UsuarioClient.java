package com.wilker.bff_agendador_tarefas.infrastructure.dtos.client;

import com.wilker.bff_agendador_tarefas.infrastructure.dtos.EnderecoDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.TelefoneDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.TokenDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @PostMapping
    UsuarioDTO registraUsuario(@RequestBody UsuarioDTO usuarioDTO);

    @PostMapping("/login")
    TokenDTO authenticarUsuario(@RequestBody UsuarioDTO usuarioDTO);

    @GetMapping
    UsuarioDTO buscarUsuarioPeloEmail(@RequestParam("email") String email,
                                      @RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deletaUsuarioPeloEmail(@PathVariable String email,
                                                       @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTO atualizarDadosUsuario(@RequestBody UsuarioDTO usuarioDTO,
                                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizarEndereco(@RequestBody EnderecoDTO enderecoDTO,
                                                         @RequestParam("id") Long id,
                                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTO atualizarTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                                         @RequestParam ("id") Long id,
                                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTO cadastrarEndereco (@RequestBody EnderecoDTO enderecoDTO,
                                                          @RequestHeader ("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTO cadastrarTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                                         @RequestHeader ("Authorization") String token);

}
