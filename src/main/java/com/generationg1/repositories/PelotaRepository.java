package com.generationg1.repositories;
import com.generationg1.models.Pelota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelotaRepository extends JpaRepository<Pelota,Long> {

}
