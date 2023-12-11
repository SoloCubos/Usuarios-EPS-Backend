package com.solocubos.usuarioeps.app.usuarioeps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solocubos.usuarioeps.app.usuarioeps.entities.Usuario;
import com.solocubos.usuarioeps.app.usuarioeps.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UsuarioService implements GenericService<Usuario, Integer>{

    @Autowired
    protected UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public List<Usuario> findAll() throws Exception {
        try {
            List<Usuario> usuario = usuarioRepository.findAll();
            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario findById(Integer id) throws Exception {
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(id);
            return usuario.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario save(Usuario entity) throws Exception {
        try{
            entity = usuarioRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario update(Integer id, Usuario entity) throws Exception {
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(id);
            Usuario usuarioUpdate = usuario.get();
            usuarioUpdate = usuarioRepository.save(entity);
            return usuarioUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer id) throws Exception {
        try {
            boolean exists = usuarioRepository.existsById(id);
            if(exists){
                usuarioRepository.deleteById(id);
                return true;
            }else throw new Exception();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    

}
