package com.leonardogg.demospringboots3.web.api;

import com.leonardogg.demospringboots3.model.Usuario;
import com.leonardogg.demospringboots3.repository.UsuarioRepository;
import com.leonardogg.demospringboots3.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private S3Service s3Service;

    @GetMapping
    List<Usuario> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .peek(usuario-> usuario.setImagenUrl(s3Service.getObjectUrl(usuario.getFoto())))
                .peek(usuario-> usuario.setPdfUrl(s3Service.getObjectUrl(usuario.getCedula())))
                .collect(Collectors.toList());
    }

    @PostMapping
    Usuario create(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        usuario.setImagenUrl(s3Service.getObjectUrl(usuario.getFoto()));
        usuario.setPdfUrl(s3Service.getObjectUrl(usuario.getCedula()));
        return usuario;
    }
}
