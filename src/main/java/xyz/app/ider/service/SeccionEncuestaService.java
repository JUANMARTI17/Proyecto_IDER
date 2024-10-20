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

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import xyz.app.ider.model.SeccionEncuesta;
import xyz.app.ider.repository.SeccionEncuestaRepository;

@Service
public class SeccionEncuestaService implements SeccionEncuestaRepository{

	@Autowired
	private SeccionEncuestaRepository seccionEncuestaRepository;
	
	 @PersistenceContext
	 private EntityManager entityManager;
	
	public SeccionEncuesta crearSeccion(SeccionEncuesta seccionEncuesta) {  //Crear seccion encuesta
        return seccionEncuestaRepository.save(seccionEncuesta);
    }
	
	public List<SeccionEncuesta> listarSecciones() {
        return seccionEncuestaRepository.findAll();
    }
	
	public void eliminarSeccion(int id) {  //Elimina seccion encuesta por ID
        seccionEncuestaRepository.deleteById(id);
    }
	
	public SeccionEncuesta actualizarSeccion(SeccionEncuesta seccionEncuesta) {  //Edita seccion encuesta por ID
        return seccionEncuestaRepository.save(seccionEncuesta);
    }
	
	public Optional<SeccionEncuesta> obtenerSeccionPorId(int id) {  //Obtiene seccion por ID
        return seccionEncuestaRepository.findById(id);
    }
	
	public List<SeccionEncuesta> listarSeccionesPorEncuesta(int encuestaId) {
        String jpql = "SELECT s FROM SeccionEncuesta s WHERE s.encuesta.id = :encuestaId";
        TypedQuery<SeccionEncuesta> query = entityManager.createQuery(jpql, SeccionEncuesta.class);
        query.setParameter("encuestaId", encuestaId);
        return query.getResultList();
    }
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends SeccionEncuesta> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SeccionEncuesta> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<SeccionEncuesta> entities) {
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
	public SeccionEncuesta getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeccionEncuesta getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeccionEncuesta getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SeccionEncuesta> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SeccionEncuesta> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SeccionEncuesta> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeccionEncuesta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeccionEncuesta> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SeccionEncuesta> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SeccionEncuesta> findById(Integer id) {
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
	public void delete(SeccionEncuesta entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends SeccionEncuesta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SeccionEncuesta> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SeccionEncuesta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SeccionEncuesta> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends SeccionEncuesta> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SeccionEncuesta> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends SeccionEncuesta> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends SeccionEncuesta, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
