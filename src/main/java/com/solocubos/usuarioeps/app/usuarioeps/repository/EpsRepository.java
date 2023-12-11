package com.solocubos.usuarioeps.app.usuarioeps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solocubos.usuarioeps.app.usuarioeps.entities.Eps;

@Repository
public interface EpsRepository extends JpaRepository<Eps, Integer>{

}
