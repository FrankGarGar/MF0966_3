package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

}
