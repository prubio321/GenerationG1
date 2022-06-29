package com.generationg1.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationg1.models.Licencia;
import com.generationg1.repositories.LicenciaRepository;

@Service
public class LicenciaService {
    @Autowired
    LicenciaRepository licenciaRepository;

    public void save(@Valid Licencia licencia) {
        // almacenar en base datos la licencia
        licenciaRepository.save(licencia);
    }

    public List<Licencia> findAll() {
        // retorno de la lista de licencias
        return licenciaRepository.findAll();
    }

}