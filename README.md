Sistema de Gestión de Reservas (JPA + Hibernate)
================================================

Aplicación Java orientada a la persistencia de datos mediante **Jakarta Persistence (JPA)** y **Hibernate**, diseñada para administrar el flujo de reservas en un entorno de restauración.

👤 Autor
--------
**1º DAW - Daniel Diaz Campoy**

🛠 Stack Tecnológico
--------------------

-   **Lenguaje:** Java 25

-   **Gestor de Dependencias:** Maven

-   **Persistencia:** Hibernate ORM + JPA 3.2

-   **Base de Datos:** MySQL

-   **Productividad:** Lombok

📂 Estructura del Proyecto
--------------------------

```
ProyectoBBDDFinal/

└── src/
    └── main/
        ├── java/
        │    ├── App/
        │    ├── models/
        │    ├── repositories/
        │    ├── services/
        │    └── utils
        │
        └── resources/
            └── META-INF/
                └── persistence.xml

```

⚙️ Configuración inicial
------------------------

### 1\. Preparación de la Base de Datos

Ejecuta el siguiente comando en tu cliente MySQL:

SQL

```
CREATE DATABASE restaurantesPU;

```

### 2\. Credenciales

Actualiza el archivo `src/main/resources/META-INF/persistence.xml` con tus credenciales locales de base de datos:

XML

```
<properties>
    <property name="jakarta.persistence.jdbc.user" value="TU_USUARIO"/>
    <property name="jakarta.persistence.jdbc.password" value="TU_PASSWORD"/>
    <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/restaurantesPU"/>
</properties>

```

🚀 Ejecución
------------

1.  **Clonar/Abrir** el proyecto como proyecto **Maven** en tu IDE (IntelliJ IDEA recomendado).

2.  Asegúrate de que el servicio **MySQL** esté activo.

3.  Ejecuta la clase `Main.java`. Maven gestionará automáticamente la descarga de dependencias y la inicialización de las entidades.
