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

    public UsuarioDTOResponse salvarUsuario(UsuarioDTORequest usuarioDTORequest){
        return usuarioClient.registraUsuario(usuarioDTORequest);
    }

    public TokenDTOResponse authenticarUsuario(LoginRequest loginRequest){
        return usuarioClient.authenticarUsuario(loginRequest);
    }

    public UsuarioDTOResponse buscarUsuarioPeloEmail(String email, String token){
        return usuarioClient.buscarUsuarioPeloEmail(email, token);
    }

    public void deletaUsuarioPeloEmail(String email, String token){
        usuarioClient.deletaUsuarioPeloEmail(email, token);
    }

    public UsuarioDTOResponse atualizarDadosUsuario(UsuarioDTORequest usuarioDTORequest, String token){
        return usuarioClient.atualizarDadosUsuario(usuarioDTORequest, token);
    }

    public EnderecoDTOResponse atualizarEndereco(EnderecoDTORequest enderecoDTORequest, Long idEndereco, String token){
        return usuarioClient.atualizarEndereco(enderecoDTORequest, idEndereco, token);
    }

    public TelefoneDTOResponse atualizarTelefone(TelefoneDTORequest telefoneDTORequest, Long idTelefone, String token){
        return usuarioClient.atualizarTelefone(telefoneDTORequest, idTelefone, token);

    }
    public EnderecoDTOResponse cadastrarEndereco(EnderecoDTORequest enderecoDTORequest, String token){
        return usuarioClient.cadastrarEndereco(enderecoDTORequest, token);
    }

    public TelefoneDTOResponse cadastrarTelefone(TelefoneDTORequest telefoneDTORequest, String token){
        return usuarioClient.cadastrarTelefone(telefoneDTORequest, token);
    }




}
