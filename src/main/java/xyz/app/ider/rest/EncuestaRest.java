package xyz.app.ider.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.app.ider.model.Encuesta;
import xyz.app.ider.service.EncuestaService;

@RestController
@RequestMapping("/encuesta")
public class EncuestaRest {

	 @Autowired
	 private EncuestaService encuestaService;
	 
	    @PostMapping("/crear")
	    public ResponseEntity<Encuesta> crearEncuesta(@RequestBody Encuesta nuevaEncuesta) {
	        Encuesta encuestaCreada = encuestaService.crearEncuesta(nuevaEncuesta);
	        return ResponseEntity.status(HttpStatus.CREATED).body(encuestaCreada);
	    }
	    
	    @GetMapping("/todas")
	    public ResponseEntity<List<Encuesta>> obtenerTodasLasEncuestas() {
	        List<Encuesta> encuestas = encuestaService.obtenerTodasLasEncuestas();
	        return ResponseEntity.ok(encuestas);
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<Encuesta> obtenerEncuestaPorId(@PathVariable int id) {
	        Optional<Encuesta> encuesta = encuestaService.obtenerEncuestaPorId(id);
	        return encuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	    
	    @DeleteMapping("/eliminar/{id}")
	    public ResponseEntity<Void> eliminarEncuesta(@PathVariable int id) {
	        encuestaService.eliminarEncuesta(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
}
