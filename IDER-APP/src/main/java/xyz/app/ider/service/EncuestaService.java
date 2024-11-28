package xyz.app.ider.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import xyz.app.ider.model.Encuesta;
import xyz.app.ider.repository.EncuestaRepository;

@Service
public class EncuestaService implements EncuestaRepository {

	@Autowired
	private EncuestaRepository encuestaRepository;
	
	
    public Encuesta crearEncuesta(Encuesta encuesta) {	// Método para crear una nueva encuesta
        return encuestaRepository.save(encuesta);
    }
    

    public List<Encuesta> obtenerTodasLasEncuestas() {	//Método para obtener todas las encuestas
        return encuestaRepository.findAll();
    }
    
    
    public Optional<Encuesta> obtenerEncuestaPorId(int id) { // Método para obtener una encuesta por su id
        return encuestaRepository.findById(id);
    }
    

    public void eliminarEncuesta(int id) {	 // Método para eliminar una encuesta por su id
        encuestaRepository.deleteById(id);
    }
    
 // Método en EncuestaService para actualizar una encuesta
    public Encuesta actualizarEncuesta(int id, Encuesta encuestaActualizada) {
        // Verificar si la encuesta con el id dado existe
        Optional<Encuesta> encuestaExistente = encuestaRepository.findById(id);
        if (encuestaExistente.isPresent()) {
            Encuesta encuesta = encuestaExistente.get();
            
            // Actualizar los campos de la encuesta existente con los datos de la nueva encuesta
            encuesta.setTitulo(encuestaActualizada.getTitulo());
            encuesta.setDescripcion(encuestaActualizada.getDescripcion());
            encuesta.setFechaCierre(encuestaActualizada.getFechaCierre());
            encuesta.setEstado(encuestaActualizada.getEstado());
            encuesta.setUsuario(encuestaActualizada.getUsuario()); // Si el usuario también se actualiza
            
            // Guardar la encuesta actualizada en el repositorio
            return encuestaRepository.save(encuesta);
        }
        return null; // Retorna null si la encuesta no existe
    }

    public List<Encuesta> obtenerEncuestasPorEstado(String estado) {
        List<Encuesta> todasLasEncuestas = encuestaRepository.findAll();
        return todasLasEncuestas.stream()
                .filter(encuesta -> estado.equalsIgnoreCase(encuesta.getEstado()))
                .toList();
    }
    
    // Método programado para ejecutar cada día a medianoche
    @Scheduled(cron = "0 * * * * ?") // Cada minuto
    public void actualizarEncuestasInactivas() {
        List<Encuesta> todasLasEncuestas = encuestaRepository.findAll(); // Obtiene todas las encuestas

        for (Encuesta encuesta : todasLasEncuestas) {
            if (encuesta.getFechaCierre() != null &&
                encuesta.getFechaCierre().before(new Date()) && 
                !"inactiva".equalsIgnoreCase(encuesta.getEstado())) {
                
                encuesta.setEstado("inactiva"); // Cambia el estado a "inactiva"
                encuestaRepository.save(encuesta); // Guarda los cambios
            }
        }
    }
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Encuesta> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Encuesta> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Encuesta> entities) {
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
	public Encuesta getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Encuesta getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Encuesta getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Encuesta> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Encuesta> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Encuesta> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Encuesta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Encuesta> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Encuesta> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Encuesta> findById(Integer id) {
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
	public void delete(Encuesta entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Encuesta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Encuesta> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Encuesta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Encuesta> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Encuesta> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Encuesta> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Encuesta> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Encuesta, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
