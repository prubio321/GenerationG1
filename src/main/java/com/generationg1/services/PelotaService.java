package com.generationg1.services;
import com.generationg1.models.Pelota;
import com.generationg1.repositories.PelotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PelotaService {

    @Autowired
    PelotaRepository pelotarepository;

    //guardar un pelota
    public void savePelota(@Valid Pelota pelota) {
        pelotarepository.save(pelota);
    }

    //obtener una lista de pelotas
    public List<Pelota> findAll() {

        return pelotarepository.findAll();
    }

    public Pelota buscarId(Long id) {
        return pelotarepository.findById(id).get();//.get especifica el tipo de dato
    }
}
