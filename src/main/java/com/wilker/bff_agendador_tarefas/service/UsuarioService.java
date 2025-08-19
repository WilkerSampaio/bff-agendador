package com.wilker.bff_agendador_tarefas.service;

import com.wilker.bff_agendador_tarefas.infrastructure.dtos.EnderecoDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.TelefoneDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.TokenDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.UsuarioDTO;
import com.wilker.bff_agendador_tarefas.infrastructure.dtos.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO){
        return usuarioClient.registraUsuario(usuarioDTO);
    }

    public TokenDTO authenticarUsuario(UsuarioDTO usuarioDTO){
        return usuarioClient.authenticarUsuario(usuarioDTO);
    }

    public UsuarioDTO buscarUsuarioPeloEmail(String email, String token){
        return usuarioClient.buscarUsuarioPeloEmail(email, token);
    }

    public void deletaUsuarioPeloEmail(String email, String token){
        usuarioClient.deletaUsuarioPeloEmail(email, token);
    }

    public UsuarioDTO atualizarDadosUsuario(UsuarioDTO usuarioDTO, String token){
        return usuarioClient.atualizarDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTO atualizarEndereco(EnderecoDTO enderecoDTO, Long idEndereco, String token){
        return usuarioClient.atualizarEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTO atualizarTelefone(TelefoneDTO telefoneDTO, Long idTelefone, String token){
        return usuarioClient.atualizarTelefone(telefoneDTO, idTelefone, token);

    }
    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO, String token){
        return usuarioClient.cadastrarEndereco(enderecoDTO, token);
    }

    public TelefoneDTO cadastrarTelefone(TelefoneDTO telefoneDTO, String token){
        return usuarioClient.cadastrarTelefone(telefoneDTO, token);
    }




}
