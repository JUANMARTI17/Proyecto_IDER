package xyz.app.ider.rest;
	
	import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	
	import xyz.app.ider.model.Usuario;
	import xyz.app.ider.service.UsuarioService;
	
	@RestController
	@RequestMapping("/usuario")
	@CrossOrigin(origins = "http://localhost:4200")
	public class UsuarioRest {
		
		@Autowired
	    private UsuarioService usuarioService;
		
		@GetMapping("/{id}")
		public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
		    Optional<Usuario> usuario = usuarioService.findById(id);
		    return usuario.map(ResponseEntity::ok) 
		                  .orElseGet(() -> ResponseEntity.notFound().build());
		}
	
		
		@GetMapping
		public ResponseEntity<List<Usuario>> getAllUsuarios() {
		    return ResponseEntity.ok(usuarioService.findAll());
		}
	
		@PostMapping("/login")
		public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario usuario) {
		    Optional<Usuario> usuarioOpt = usuarioService.login(usuario.getEmail(), usuario.getPass());

		    if (usuarioOpt.isPresent()) {
		        Long userId = (long) usuarioOpt.get().getId();
		        Map<String, Object> response = new HashMap<>();
		        response.put("message", "Login successful");
		        response.put("userId", userId);
		        return ResponseEntity.ok(response); // Enviar el ID del usuario como parte de la respuesta
		    } else {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
		    }
		}
		
		@PostMapping("/registrar")
		public ResponseEntity<Usuario> registrar(@RequestBody Usuario nuevoUsuario) {
		    if (usuarioService.findByEmail(nuevoUsuario.getEmail()).isPresent()) {
		        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		    }
		    
		    Usuario usuarioRegistrado = usuarioService.registrarUsuario(nuevoUsuario);
		    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRegistrado);
		}
		
		// UsuarioRest.java
		@PutMapping("/{id}")
		public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioActualizado) {
		    Usuario usuario = usuarioService.actualizarUsuario(id, usuarioActualizado);
		    
		    if (usuario != null) {
		        return ResponseEntity.ok(usuario);  // Retorna el usuario actualizado
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Si el usuario no existe
		    }
		}

	
	}
