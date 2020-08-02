package com.javatechie.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.jwt.api.entity.JsonResponseDTO;

public interface ParsedJsonRepostiory extends JpaRepository<JsonResponseDTO, Integer> {

}
