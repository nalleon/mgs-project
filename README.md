<div align="justify">

# METAL GEAR SOLID Wiki - Proyecto
> **Desarrollador:** Nabil L.A. ([@nalleon](https://github.com/nalleon)) 

<br>

<div align="center">
<img src="img/logo.png" width=600>
</div>

## Índice
- [Metal Gear Solid Wiki - Proyecto](/code/mgs-project/)
  - [Anteproyecto](/draft-project/)
  - [Detalles del proyecto](#index01)
  - [Tecnologías utilizadas](#index02)
  - [Definición de la BBDD](#index03)


## Detalles del proyecto <a name="index01"></a>

Este tiene como objetivo principal crear una base de datos que almacene información relevante sobre la saga de videojuegos Metal Gear Solid. Esta wiki contará con información sobre los personajes, juegos, directores, artistas y usuarios que interactúan con el sistema. 
  

El proyecto incluirá una API RESTful para permitir la gestión y consulta de los datos, junto con una interfaz gráfica para la visualización de la información de los videojuegos y sus personajes. La seguridad será un objetivo importante, por lo que se implementarán medidas de autenticación y autorización para proteger el acceso a los recursos de la API. Además, se utilizarán bases de datos relacionales y no relacionales para manejar diferentes tipos de datos y escenarios de uso.



## Tecnologías utilizadas <a name="index02"></a>

Estas son las tecnologías que utilizaremos a lo largo del desarollor del proyecto:

- **IDE:**
  - [IntelliJ IDEA - Community Edition](https://www.jetbrains.com/idea/) para el desarrollo del código en Java.
  - [Visual Studio Code](https://code.visualstudio.com/) para la creación de documentación en Markdown y desarrollo adicional en JavaScript.

- **Gestión de Dependencias:**
  - [Maven](https://maven.apache.org/) para la gestión de dependencias y compilación del proyecto.

- **Bases de Datos y ORM:**
  - [MongoDB Atlas](https://www.mongodb.com/) como base de datos no relacional.
  - [SQLite](https://www.sqlite.org/index.html) como base de datos relacional.
  - [Hibernate/JPA](https://hibernate.org/) como framework ORM para la gestión de entidades relacionales.

- **Frameworks para la API:**
  - [Spring Boot](https://spring.io/projects/spring-boot) como framework principal para el desarrollo de la aplicación.
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa) para la interacción con bases de datos relacionales.
  - [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb) para la interacción con bases de datos MongoDB.
  - [Swagger](https://swagger.io/) para la documentación y pruebas de los endpoints de la API.

- **Securización:**
  - [**Spring Security**](https://spring.io/projects/spring-security): como framework para la gestión de autenticación y autorización.
  - [**JSON Web Tokens (JWT)**](https://jwt.io/): para la creación y validación de tokens seguros para la autenticación de usuarios.
  - [**Spring Security Test**](https://docs.spring.io/spring-security/reference/testing/overview.html): para facilitar la creación de pruebas relacionadas con la seguridad.

- **Documentación:**
  - [Markdown](https://daringfireball.net/projects/markdown/) para la creación de documentos estructurados y legibles.
  - [Swagger UI](https://swagger.io/tools/swagger-ui/) como interfaz gráfica para la documentación de la API.

- **Despliegue:**
  - [Docker](https://www.docker.com/) para la creación de contenedores y despliegue del proyecto en diferentes entornos.


<div align="center">
<img src="img/tech.png" width=140>
</div>

## Definición de la BBDD <a name="index03"></a>

Inicialmente esta ha sido la definición de las clases para la implementación en base de datos relacionales (Sqlite) y no relacionales (Mongo).

<div align="center">
<img src="img/classes-diagram-db.png">
</div>

<br>


### Relaciones:

| Entidad 1    | Relación | Entidad 2    | Descripción            |
|--------------|----------|--------------|------------------------|
| **Juegos**   | N:M      | **Personajes** | Un juego puede tener múltiples personajes, y un personaje puede aparecer en múltiples juegos. |
| **Juegos**   | 1:N      | **Directores** | Un juego es dirigido por un único director, pero un director puede dirigir varios juegos. |
| **Personajes** | 1:N    | **Artistas**   | Un personaje es creado por un único artista, pero un artista puede crear varios personajes. |
| **Usuarios** | 1:N      | **Roles**      | Un usuario puede tener un único rol, pero un rol puede ser asignado a varios usuarios. |


<br>
