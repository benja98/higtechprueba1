package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Datos;

public interface PersonaRepository extends JpaRepository<Datos, Integer>{

}
