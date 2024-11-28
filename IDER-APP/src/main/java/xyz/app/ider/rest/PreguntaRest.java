package xyz.app.ider.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.app.ider.model.Pregunta;
import xyz.app.ider.service.PreguntaService;

@RestController
@RequestMapping("/preguntas")
@CrossOrigin(origins = "http://localhost:4200")
public class PreguntaRest {

	 @Autowired
	 private PreguntaService preguntaService;
	 
	 @PostMapping
	 public ResponseEntity<Pregunta> crearPregunta(@RequestBody Pregunta pregunta) {
		 Pregunta nuevaPregunta = preguntaService.savePregunta(pregunta);
	     return ResponseEntity.ok(nuevaPregunta);
	   }
	 
	 @GetMapping
	    public ResponseEntity<List<Pregunta>> listarPreguntas() {
	        List<Pregunta> preguntas = preguntaService.getAllPreguntas();
	        return ResponseEntity.ok(preguntas);
	    }

	 @GetMapping("/{id}")
	    public ResponseEntity<Pregunta> obtenerPreguntaPorId(@PathVariable int id) {
	        Optional<Pregunta> pregunta = preguntaService.getPreguntaById(id);
	        return pregunta.map(ResponseEntity::ok)
	                       .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminarPregunta(@PathVariable int id) {
	        preguntaService.deletePregunta(id);
	        return ResponseEntity.noContent().build();
	    }
	 
	    @GetMapping("/encuesta/{encuestaId}")
	    public ResponseEntity<List<Pregunta>> listarPreguntasPorEncuesta(@PathVariable int encuestaId) {
	        List<Pregunta> preguntas = preguntaService.getPreguntasByEncuestaId(encuestaId);
	        return ResponseEntity.ok(preguntas);
	    }
	    
	    @PutMapping("/actualizar/{id}")
	    public ResponseEntity<Pregunta> actualizarPregunta(@PathVariable int id, @RequestBody Pregunta pregunta) {
	        try {
	            Pregunta preguntaActualizada = preguntaService.actualizarPregunta(id, pregunta);
	            return ResponseEntity.ok(preguntaActualizada);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(404).body(null); // Opción de manejar la excepción con un mensaje adecuado
	        }
	    }

	
}
