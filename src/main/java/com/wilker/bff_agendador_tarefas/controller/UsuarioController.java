package com.wilker.bff_agendador_tarefas.controller;


import com.wilker.bff_agendador_tarefas.infrastructure.dtos.EnderecoDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.TelefoneDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.TokenDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.UsuarioDTO;
import com.wilker.bff_agendador_tarefas.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "usuario", description = "cadastro e login de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salva usuários", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode =  "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> registraUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login usuários", description = "Authentica usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado")
    @ApiResponse(responseCode =  "401", description = "Credencias inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TokenDTO> authenticarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.authenticarUsuario(usuarioDTO));
    }
    @GetMapping
    @Operation(summary = "Buscar dados usuário", description = "Buscar dados do usuário por email ")
    @ApiResponse(responseCode = "200", description = "Usuário econtrado")
    @ApiResponse(responseCode =  "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPeloEmail(@RequestParam ("email") String email,
                                                             @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPeloEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta usuários", description = "Deleta um usuário por email")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode =  "404", description = "Usuário não econtrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaUsuarioPeloEmail(@PathVariable String email,
                                                       @RequestHeader("Authorization") String token){
        usuarioService.deletaUsuarioPeloEmail(email,token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar dados de usuários", description = "Atualiza dados de um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode =  "404", description = "Usuário não econtrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> atualizarDadosUsuario(@RequestBody UsuarioDTO usuarioDTO,
                                                            @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizarDadosUsuario(usuarioDTO, token));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualiza endereço de usuário", description = "Atualiza um endereço do usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode =  "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTO> atualizarEndereco(@RequestBody EnderecoDTO enderecoDTO,
                                                         @RequestParam("id") Long id,
                                                         @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizarEndereco(enderecoDTO,id, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualiza telefone de usuário", description = "Atualiza um telefone do usuário")
    @ApiResponse(responseCode = "200", description = "telefone atualizado com sucesso")
    @ApiResponse(responseCode =  "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTO> atualizarTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                                         @RequestParam ("id") Long id,
                                                         @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizarTelefone(telefoneDTO, id ,token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Salva endereço de usuário", description = "Salva endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode =  "400", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTO> cadastrarEndereco (@RequestBody EnderecoDTO enderecoDTO,
                                                          @RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(usuarioService.cadastrarEndereco(enderecoDTO,token));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Salva telefone de usuário", description = "Salva telefone de usuário")
    @ApiResponse(responseCode = "200", description = "telefone salvo com sucesso")
    @ApiResponse(responseCode =  "400", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTO> cadastrarTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                                         @RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(usuarioService.cadastrarTelefone(telefoneDTO,token));
    }
}
