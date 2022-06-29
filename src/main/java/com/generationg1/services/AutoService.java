package com.generationg1.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.generationg1.models.Auto;
import com.generationg1.repositories.AutoRepository;

@Service
@Transactional
public class AutoService {
    @Autowired
    AutoRepository autoRepository;

    //guardar un auto
    public void guardarAuto(@Valid Auto auto) {
        autoRepository.save(auto);

    }
    /**obtener una lista de autos*/
    public List<Auto> findAll() {
        return autoRepository.findAll();
    }

    public Auto buscarId(Long id) {
        return autoRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamos
    }

    public void eliminarPorId(Long id) {

        autoRepository.deleteById(id);
    }
    public List<Auto> buscarMarca(String marca) {
        //llamado a un metodo propio
        //return autoRepository.buscarMarca(marca); //Query Tradicional
        return autoRepository.findAllAutoMarca(marca);//Query por objeto
    }

    //PAGINACION
    //variable estatica, cantidad de datos a mostrar por pagina
    private static final int LOTE = 5;
    //deprecado = new PageRequest(...)
    public Page<Auto> paginarAutos(int numeroPagina){
        PageRequest pageRequest = PageRequest.of(numeroPagina, LOTE,Sort.Direction.DESC,"velocidad");
        //Page<Auto> autos = autoRepository.findAll(pageRequest);
        return autoRepository.findAll(pageRequest);
    }


}