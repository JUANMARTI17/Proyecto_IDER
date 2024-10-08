package xyz.app.ider.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Respuesta")
public class Respuesta {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String respuesta;

    @ManyToOne
    @JoinColumn(name = "id_SeccionEncuesta", referencedColumnName = "id")
    private SeccionEncuesta seccionEncuesta;

    @ManyToOne
    @JoinColumn(name = "id_Pregunta", referencedColumnName = "id")
    private Pregunta pregunta;

	public Respuesta() {
		super();
	}

	public Respuesta(int id, String respuesta, SeccionEncuesta seccionEncuesta, Pregunta pregunta) {
		super();
		this.id = id;
		this.respuesta = respuesta;
		this.seccionEncuesta = seccionEncuesta;
		this.pregunta = pregunta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public SeccionEncuesta getSeccionEncuesta() {
		return seccionEncuesta;
	}

	public void setSeccionEncuesta(SeccionEncuesta seccionEncuesta) {
		this.seccionEncuesta = seccionEncuesta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
    
}
