package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Datos;
import com.example.demo.dao.PersonaResponse;

public interface PersonaRepository extends JpaRepository<Datos, Integer>{

}
