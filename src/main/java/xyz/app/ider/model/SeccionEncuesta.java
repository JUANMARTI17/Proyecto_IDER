package xyz.app.ider.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SeccionEncuesta")
public class SeccionEncuesta {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_Encuesta", referencedColumnName = "id")
    private Encuesta encuesta;

	public SeccionEncuesta() {
		super();
	}

	public SeccionEncuesta(int id, String titulo, Encuesta encuesta) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.encuesta = encuesta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
    
}
