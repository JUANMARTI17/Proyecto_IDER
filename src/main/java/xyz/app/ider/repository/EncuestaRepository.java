package xyz.app.ider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.app.ider.model.Encuesta;

public interface EncuestaRepository extends JpaRepository<Encuesta, Integer> {

}
