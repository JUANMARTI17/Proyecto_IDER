package xyz.app.ider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.app.ider.model.Opciones;
import xyz.app.ider.repository.OpcionesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OpcionesService {

    @Autowired
    private OpcionesRepository opcionesRepository;

    // Crear una opción
    public Opciones crearOpcion(Opciones opcion) {
        return opcionesRepository.save(opcion);
    }

    // Obtener todas las opciones
    public List<Opciones> obtenerOpciones() {
        return opcionesRepository.findAll();
    }

    // Obtener opción por ID
    public Optional<Opciones> obtenerOpcionPorId(int id) {
        return opcionesRepository.findById(id);
    }

    // Eliminar opción
    public void eliminarOpcion(int id) {
        opcionesRepository.deleteById(id);
    }
    
 // Actualizar opción
    public Opciones actualizarOpcion(int id, Opciones opcionActualizada) {
        return opcionesRepository.findById(id)
            .map(opcion -> {
                opcion.setTipo(opcionActualizada.getTipo());
                opcion.setTexto(opcionActualizada.getTexto());
                opcion.setSeleccionable(opcionActualizada.isSeleccionable());
                opcion.setPregunta(opcionActualizada.getPregunta()); // Si es necesario actualizar la pregunta
                return opcionesRepository.save(opcion);
            })
            .orElseThrow(() -> new RuntimeException("Opción no encontrada con ID: " + id));
    }
}
