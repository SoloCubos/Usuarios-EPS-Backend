package com.solocubos.usuarioeps.app.usuarioeps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solocubos.usuarioeps.app.usuarioeps.entities.Eps;
import com.solocubos.usuarioeps.app.usuarioeps.repository.EpsRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class EpsService implements GenericService<Eps, Integer>{

    @Autowired
    protected EpsRepository epsRepository;

    @Override
    @Transactional
    public List<Eps> findAll() throws Exception {
        try {
            List<Eps> eps = epsRepository.findAll();
            return eps;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Eps findById(Integer id) throws Exception {
        try {
            Optional<Eps> eps = epsRepository.findById(id);
            return eps.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Eps save(Eps entity) throws Exception {
        try{
            entity = epsRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Eps update(Integer id, Eps entity) throws Exception {
        try {
            Optional<Eps> eps = epsRepository.findById(id);
            Eps epsUpdate = eps.get();
            epsUpdate = epsRepository.save(entity);
            return epsUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer id) throws Exception {
        try {
            boolean exists = epsRepository.existsById(id);
            if(exists){
                epsRepository.deleteById(id);
                return true;
            }else throw new Exception();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
