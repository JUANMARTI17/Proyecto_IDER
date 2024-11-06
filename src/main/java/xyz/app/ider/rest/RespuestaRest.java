package xyz.app.ider.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.app.ider.model.Respuesta;
import xyz.app.ider.service.RespuestaService;

@RestController
@RequestMapping("/respuestas")
public class RespuestaRest {

	 @Autowired
	 private RespuestaService respuestaService;
	 
	    @PostMapping
	    public Respuesta responderEncuesta(@RequestBody Respuesta respuesta) {
	        return respuestaService.saveRespuesta(respuesta);
	    }

}
