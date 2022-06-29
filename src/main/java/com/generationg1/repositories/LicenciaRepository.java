package com.generationg1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generationg1.models.Licencia;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Long>{

}