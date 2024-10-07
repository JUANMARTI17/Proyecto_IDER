-- Crear tabla Roles
CREATE TABLE Roles (
    id_rol SERIAL PRIMARY KEY,  -- id auto-incremental
    nombre_rol VARCHAR(50) NOT NULL,  -- Administrador o Usuario
    descripcion_rol TEXT NOT NULL
);

select * from Roles;

-- Crear tabla Usuario
CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,  -- id auto-incremental
    identificacion VARCHAR(20) NOT NULL,  -- CC, TI, etc.
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fechaCreacion DATE DEFAULT CURRENT_DATE,
    estado VARCHAR(20) NOT NULL,  -- activo, inactivo
    email VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NOT NULL,
    id_rol INT,  -- llave foránea a Roles
	 CONSTRAINT fk_roles_usuario FOREIGN KEY (id_rol) REFERENCES Roles(id_rol)
);

select * from Usuario;


-- Crear tabla Encuesta
CREATE TABLE Encuesta (
    id SERIAL PRIMARY KEY,  -- id auto-incremental
    fecha_Creacion DATE DEFAULT CURRENT_DATE,
    fecha_Cierre DATE,
    titulo VARCHAR(150) NOT NULL,
    descripcion TEXT,
    estado VARCHAR(20),  -- abierta, cerrada
    id_usuario INT,  -- llave foránea a Usuario
    CONSTRAINT fk_usuario_encuesta FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
);

select * from Encuesta;

-- Crear tabla SeccionEncuesta
CREATE TABLE SeccionEncuesta (
    id SERIAL PRIMARY KEY,  -- id auto-incremental
    titulo VARCHAR(150) NOT NULL,
    id_Encuesta INT,  -- llave foránea a Encuesta
    CONSTRAINT fk_encuesta_seccion FOREIGN KEY (id_Encuesta) REFERENCES Encuesta(id)
);

select * from SeccionEncuesta;

-- Crear tabla Pregunta
CREATE TABLE Pregunta (
    id SERIAL PRIMARY KEY,  -- id auto-incremental
    texto TEXT NOT NULL,  -- texto de la pregunta
    tipo VARCHAR(20) NOT NULL,  -- tipo de pregunta (ej. multiple_choice, text)
    id_SeccionEncuesta INT,  -- llave foránea a SeccionEncuesta
    CONSTRAINT fk_seccion_pregunta FOREIGN KEY (id_SeccionEncuesta) REFERENCES SeccionEncuesta(id)
);

select * from Pregunta;

-- Crear tabla Opciones
CREATE TABLE Opciones (
    id SERIAL PRIMARY KEY,  -- id auto-incremental
    tipo VARCHAR(20) NOT NULL,  -- tipo de opción
    texto TEXT NOT NULL,  -- texto de la opción
    seleccionable BOOLEAN NOT NULL,  -- si es seleccionable
    id_pregunta INT,  -- llave foránea a Pregunta
    CONSTRAINT fk_pregunta_opcion FOREIGN KEY (id_pregunta) REFERENCES Pregunta(id)
);

select * from Opciones;

-- Crear tabla Respuesta
CREATE TABLE Respuesta (
    id SERIAL PRIMARY KEY,  -- id auto-incremental
    Respuesta TEXT NOT NULL,  -- respuesta del usuario
    id_SeccionEncuesta INT,  -- llave foránea a SeccionEncuesta
    id_Pregunta INT,  -- llave foránea a Pregunta
    CONSTRAINT fk_seccion_respuesta FOREIGN KEY (id_SeccionEncuesta) REFERENCES SeccionEncuesta(id),
    CONSTRAINT fk_pregunta_respuesta FOREIGN KEY (id_Pregunta) REFERENCES Pregunta(id)
);

select * from Respuesta;
