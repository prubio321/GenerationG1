package com.generationg1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generationg1.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ //JpaRepository<Objeto,Tipo_dato_PK>
    /** las interface solo definen los metodos*/
    /** Querys y usar metodo que se conectan a la base de datos*/

    /* validar la existencia del email */
    Usuario findByEmail(String email);
}