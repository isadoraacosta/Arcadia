package com.ufg.trabalhoPOO.service;

import com.ufg.trabalhoPOO.model.dto.requisicao.LoginUsuarioDTO;
import com.ufg.trabalhoPOO.model.dto.requisicao.RequestUsuarioDTO;
import com.ufg.trabalhoPOO.model.dto.resposta.ResponseUsuarioDTO;
import com.ufg.trabalhoPOO.model.entidade.Usuario;
import com.ufg.trabalhoPOO.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service // Serviço do padrao MVC
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
    }


    public ResponseUsuarioDTO registrarUsuario(RequestUsuarioDTO requestUsuarioDTO) {

        Usuario usuario = new Usuario(requestUsuarioDTO);

        usuarioRepository.save(usuario);

        Usuario usuarioCriado =  usuarioRepository.findByEmail(requestUsuarioDTO.getEmail()).orElseThrow(() -> {
            throw new RuntimeException("Falha ao criar usuario");
        });

        return new ResponseUsuarioDTO(usuarioCriado);
    }

    public ResponseUsuarioDTO login(LoginUsuarioDTO loginUsuarioDTO) {
        //Pesquisa se o email existe, se nao existir lança um erro
        Usuario usuario = usuarioRepository.findByEmail(loginUsuarioDTO.getEmail()).orElseThrow(() -> {
            throw new RuntimeException("Email ou Senha Incorreto");
        }
        );

        // Verifica se as senhas sao iguais, se sim ele retona
        if (Objects.equals(loginUsuarioDTO.getSenha(), usuario.getSenha())) {
            return new ResponseUsuarioDTO(usuario);
        }

        // se as senhas nao forem iguais lança um erro
        throw new RuntimeException("Email ou Senha Incorreto");
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
