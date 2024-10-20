package xyz.app.ider.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.app.ider.model.SeccionEncuesta;
import xyz.app.ider.service.SeccionEncuestaService;

@RestController
@RequestMapping("/secciones")
public class SeccionEncuestaRest {

	@Autowired
	private SeccionEncuestaService seccionEncuestaService;
	
	@PostMapping
    public ResponseEntity<SeccionEncuesta> crearSeccion(@RequestBody SeccionEncuesta seccionEncuesta) {
        SeccionEncuesta nuevaSeccion = seccionEncuestaService.crearSeccion(seccionEncuesta);
        return ResponseEntity.ok(nuevaSeccion);
    }
	
	  @GetMapping
	    public List<SeccionEncuesta> listarSecciones() {
	        return seccionEncuestaService.listarSecciones();
	    }
	
	 @DeleteMapping("/eliminar/{id}")
	    public ResponseEntity<Void> eliminarSeccion(@PathVariable int id) {
	        seccionEncuestaService.eliminarSeccion(id);
	        return ResponseEntity.noContent().build();
	    }
	 
	 @PutMapping("/actualizar/{id}")
	    public ResponseEntity<SeccionEncuesta> actualizarSeccion(@PathVariable int id, @RequestBody SeccionEncuesta seccionEncuesta) {
	        seccionEncuesta.setId(id);
	        SeccionEncuesta seccionActualizada = seccionEncuestaService.actualizarSeccion(seccionEncuesta);
	        return ResponseEntity.ok(seccionActualizada);
	    }
	
	@GetMapping("obtener/{id}")
    public ResponseEntity<SeccionEncuesta> obtenerSeccionPorId(@PathVariable int id) {
        return seccionEncuestaService.obtenerSeccionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	 @GetMapping("/obtenerporEncuesta/{encuestaId}")
	    public ResponseEntity<List<SeccionEncuesta>> listarSeccionesPorEncuesta(@PathVariable int encuestaId) {
	        List<SeccionEncuesta> secciones = seccionEncuestaService.listarSeccionesPorEncuesta(encuestaId);
	        return ResponseEntity.ok(secciones);
	    }
	
}
