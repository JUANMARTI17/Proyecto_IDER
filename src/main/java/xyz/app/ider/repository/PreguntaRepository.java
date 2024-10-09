package xyz.app.ider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.app.ider.model.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

}