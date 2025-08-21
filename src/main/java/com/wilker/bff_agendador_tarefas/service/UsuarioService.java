package com.wilker.bff_agendador_tarefas.service;

import com.wilker.bff_agendador_tarefas.infrastructure.dtos.in.*;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.EnderecoDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.TelefoneDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.TokenDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.out.UsuarioDTOResponse;
import com.wilker.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvarUsuario(UsuarioDTORequest UsuarioDTORequest){
        return usuarioClient.registraUsuario(UsuarioDTORequest);
    }

    public TokenDTOResponse authenticarUsuario(LoginRequest LoginRequest){
        return usuarioClient.authenticarUsuario(LoginRequest);
    }

    public UsuarioDTOResponse buscarUsuarioPeloEmail(String email, String token){
        return usuarioClient.buscarUsuarioPeloEmail(email, token);
    }

    public void deletaUsuarioPeloEmail(String email, String token){
        usuarioClient.deletaUsuarioPeloEmail(email, token);
    }

    public UsuarioDTOResponse atualizarDadosUsuario(UsuarioDTORequest UsuarioDTORequest, String token){
        return usuarioClient.atualizarDadosUsuario(UsuarioDTORequest, token);
    }

    public EnderecoDTOResponse atualizarEndereco(EnderecoDTORequest EnderecoDTORequest, Long idEndereco, String token){
        return usuarioClient.atualizarEndereco(EnderecoDTORequest, idEndereco, token);
    }

    public TelefoneDTOResponse atualizarTelefone(TelefoneDTORequest TelefoneDTORequest, Long idTelefone, String token){
        return usuarioClient.atualizarTelefone(TelefoneDTORequest, idTelefone, token);

    }
    public EnderecoDTOResponse cadastrarEndereco(EnderecoDTORequest EnderecoDTORequest, String token){
        return usuarioClient.cadastrarEndereco(EnderecoDTORequest, token);
    }

    public TelefoneDTOResponse cadastrarTelefone(TelefoneDTORequest TelefoneDTORequest, String token){
        return usuarioClient.cadastrarTelefone(TelefoneDTORequest, token);
    }




}
