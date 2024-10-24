package xyz.app.ider.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import xyz.app.ider.model.Pregunta;
import xyz.app.ider.repository.PreguntaRepository;

@Service
public class PreguntaService implements PreguntaRepository {
	
	@Autowired
    private PreguntaRepository preguntaRepository;
	
	 public Pregunta savePregunta(Pregunta pregunta) {	//Guardar pregunta
	        return preguntaRepository.save(pregunta);
	    }

	    public List<Pregunta> getAllPreguntas() {	//Obtener todas las preguntas
	        return preguntaRepository.findAll();
	    }

	    public Optional<Pregunta> getPreguntaById(int id) { 	//Obtener pregunta por ID
	        return preguntaRepository.findById(id);
	    }

	    public void deletePregunta(int id) {  	//Borrar Pregunta
	        preguntaRepository.deleteById(id);
	    }
	    
	    public List<Pregunta> getPreguntasByEncuestaId(int encuestaId) {
	        List<Pregunta> preguntas = preguntaRepository.findAll(); 	 //Método para listar preguntas por ID de Encuesta
	        return preguntas.stream()
	                .filter(pregunta -> pregunta.getSeccionEncuesta() != null && 
	                        pregunta.getSeccionEncuesta().getEncuesta().getId() == encuestaId)
	                .toList();
	    }

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Pregunta> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pregunta> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Pregunta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pregunta getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pregunta> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pregunta> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pregunta> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pregunta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pregunta> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pregunta> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pregunta> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pregunta entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Pregunta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pregunta> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Pregunta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pregunta> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Pregunta> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pregunta> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Pregunta> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Pregunta, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
