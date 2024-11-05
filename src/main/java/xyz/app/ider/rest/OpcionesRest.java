package xyz.app.ider.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.app.ider.model.Opciones;
import xyz.app.ider.service.OpcionesService;


@RestController
@RequestMapping("/opciones")
public class OpcionesRest {

	@Autowired
	private OpcionesService opcionesService;
	
	 @PostMapping
	    public Opciones crearOpcion(@RequestBody Opciones opcion) {
	        return opcionesService.crearOpcion(opcion);
	    }
	 
	 @GetMapping
	    public List<Opciones> obtenerOpciones() {
	        return opcionesService.obtenerOpciones();
	    }
	
}
