package xyz.app.ider.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.app.ider.model.Opciones;
import xyz.app.ider.model.Pregunta; // Importar modelo Pregunta
import xyz.app.ider.service.OpcionesService;
import xyz.app.ider.repository.PreguntaRepository; // Importar repositorio Pregunta
import xyz.app.ider.dto.OpcionDTO; // Importar OpcionDTO

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/opciones")
@CrossOrigin(origins = "http://localhost:4200")
public class OpcionesRest {

    @Autowired
    private OpcionesService opcionesService;

    @Autowired
    private PreguntaRepository preguntaRepository; // Inyección del repositorio Pregunta

    // Crear una nueva opción sin DTO
    @PostMapping
    public Opciones crearOpcion(@RequestBody Opciones opcion) {
        return opcionesService.crearOpcion(opcion);
    }

    @PostMapping("/conPregunta")
    public ResponseEntity<?> crearOpcionConPregunta(@RequestBody OpcionDTO opcionDTO) {
        Pregunta pregunta = preguntaRepository.findById(opcionDTO.getPreguntaId())
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
        Opciones opcion = new Opciones();
        opcion.setPregunta(pregunta);
        opcion.setTexto(opcionDTO.getTexto());
        opcionesService.crearOpcion(opcion);
        
        String respuesta = "Opción creada con éxito";
        System.out.println("Respuesta generada: " + respuesta);
        return ResponseEntity.ok(respuesta);
    }


    // Obtener todas las opciones
    @GetMapping
    public List<Opciones> obtenerOpciones() {
        return opcionesService.obtenerOpciones();
    }

    // Obtener una opción por ID
    @GetMapping("/{id}")
    public Optional<Opciones> obtenerOpcionPorId(@PathVariable int id) {
        return opcionesService.obtenerOpcionPorId(id);
    }

    // Eliminar una opción
    @DeleteMapping("/{id}")
    public void eliminarOpcion(@PathVariable int id) {
        opcionesService.eliminarOpcion(id);
    }
}
