### **Descripción del Proyecto**

El sistema **Examen1Back2** es una aplicación académica construida con
**Spring Boot**, cuyo propósito es administrar de manera organizada los
datos relacionados con usuarios, docentes y cursos.

La solución sigue una **arquitectura en capas**, utilizando
**JPA/Hibernate** para el acceso y gestión de la información
persistente, y **MySQL** como motor de base de datos.

Las entidades principales que conforman la aplicación son:

-   **Usuario**: Modela a cada persona dentro del sistema, almacenando
    datos como nombre, correo, contraseña, teléfono y el rol que
    desempeña (administrador, docente, estudiante o invitado).

-   **Docente**: Registra a los profesores junto con su especialidad,
    manteniendo una relación uno a uno con la entidad Usuario.

-   **Curso**: Representa las asignaturas disponibles, vinculadas a los
    docentes mediante una relación de muchos a uno.

-   **TipoUsuario (enum)**: Enumera los roles posibles que puede asumir
    un usuario en la plataforma.

### **Listado de errores**

**1. Primer Commit**

-   **Clase Curso**:

    -   En la línea 5 no estaba presente la anotación \@Table, la cual
        fue agregada.

    -   En las líneas 8 y 9 las anotaciones \@Id y \@GeneratedValue
        estaban mal escritas, por lo que se corrigieron y además se
        especificó la estrategia de generación de la clave primaria.

    -   En la línea 11 se añadió la anotación \@Column al atributo
        nombre, ya que estaba ausente.

-   **Clase Docente**:

    -   En la línea 7 la anotación \@Entity estaba mal escrita y fue
        corregida.

    -   En la línea 8 se agregó la anotación \@Table, que no estaba
        definida.

    -   En la línea 10 se añadió la anotación \@Id para definir la clave
        primaria.

    -   En la línea 14 se agregó la anotación \@Column al atributo
        especialidad.

-   **Clase Usuario**:

    -   En la línea 5 se corrigió el error de escritura en la anotación
        \@Entity.

    -   En la línea 10 se especificó el tipo de estrategia del campo
        TipoUsuario como STRING mediante \@Enumerated(EnumType.STRING).

    -   En la línea 16, al atributo nombre, se le añadió la anotación
        \@Column indicando el nombre de la columna en la base de datos.

    -   En las líneas 19 y 22 se agregaron las anotaciones \@Column a
        los atributos contraseña y teléfono, respectivamente.

### **2. Segundo Commit**

-   **Clase Curso**:

    -   En la línea 19 se añadió el modificador de acceso private que
        hacía falta en un atributo.

    -   A partir de la línea 29 se implementaron los métodos *getter* y
        *setter* correspondientes.

-   **Clase Docente**:

    -   En la línea 27 se agregaron los constructores que no estaban
        definidos: uno vacío y otro con todos los atributos.

-   **Clase Usuario**:

    -   En la línea 45 se añadieron los métodos *getter* y *setter*
        faltantes.

### **3. Tercer Commit**

-   **Package**:

    -   Se creó una nueva capa denominada ayudas, que contiene un enum
        donde se clasifican los tipos de usuario, persistidos como
        STRING.

-   **Clase Curso**:

    -   Se realizó la importación del nuevo paquete ayudas para utilizar
        el enum definido.

### **4. Cuarto Commit**

-   **Clase Curso**:

    -   En la línea 13 se cambió el nombre de la columna a nombreCurso.

    -   En la línea 18 se actualizó el valor de la referencia JSON a
        \"relaciondocentecurso\".

-   **Clase Docente**:

    -   En la línea 16 se definió la longitud máxima de caracteres para
        el atributo especialidad.

    -   En la línea 20 se actualizó el valor de la referencia JSON a
        \"relaciondocentecurso\".

    -   En la línea 21 se inicializó el arreglo de cursos.

    -   En la línea 25 se cambió el valor de la referencia JSON a
        \"relaciondocenteusuario\".

-   **Clase Usuario**:

    -   En la línea 18 se estableció la longitud máxima de caracteres
        para el atributo correoElectronico.

    -   En la línea 21 se hizo lo mismo para el atributo contraseña.

    -   En la línea 27 se añadió la anotación \@Column con parámetros al
        atributo tipoUsuario.

-   **Resources**:

    -   En el archivo application.properties se agregaron la URL,
        usuario, contraseña y la configuración de Hibernate (Update)
        necesarias para la conexión a la base de datos.

### **5. Quinto Commit**

-   **Clase Curso**:

    -   En la línea 17 se eliminó un punto y coma innecesario en la
        anotación \@JoinColumn.

### **6. Sexto Commit:**

-   **Resources:**

-   Se actualizó el nombre de la base de datos.

-   Se agregó spring.jpa.show-sql=true para visualizar en consola las
    sentencias SQL generadas por Hibernate.

-   Se agregó
    spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
    para definir el dialecto de MySQL 8 y garantizar compatibilidad con
    la base de datos.
	
### **7. Séptimo Commit**

-   **Clase Usuario**:

    -   Se modificó la restricción *unique* de la columna **contraseña**, estableciéndola en **False**.

-   **Resources**:

    -   Se eliminó el marcador de posición `"BASE DATOS ACA"`.

-   **Clase Curso**:

    -   Se actualizó el constructor completo para reflejar todos los atributos.


### **Guía para establecer la conexión con la base de datos**

**1. Creación de la base de datos en MySQL (usando XAMPP)**

-   Inicia los servicios de **Apache** y **MySQL** desde el panel de
    control de XAMPP.

-   Ingresa a **phpMyAdmin** mediante la URL:
    http://localhost/phpmyadmin.

-   Define una nueva base de datos (ejemplo: examen_backend).

-   *(Opcional)* Registra un usuario con contraseña personalizada en
    lugar de trabajar con el usuario root.

**2. Incorporación de dependencias en el proyecto**\
En el archivo pom.xml deben declararse las librerías necesarias:

-   **Spring Web** → para implementar controladores REST.

-   **Spring Data JPA** → encargado del manejo de entidades y
    persistencia con Hibernate.

-   **MySQL Driver** → establece la comunicación con MySQL.

-   **H2 Database** *(opcional)* → útil para pruebas en memoria.

-   **Spring Boot DevTools** → facilita el reinicio automático durante
    el desarrollo.

**3. Configuración en el archivo application.properties**\
Ubicado en src/main/resources/application.properties, se definen los
parámetros de conexión:

-   Dirección de la base de datos (ejemplo:
    jdbc:mysql://localhost:3306/examen_backend).

-   Usuario y contraseña (por defecto: root y sin contraseña).

-   Driver a utilizar: com.mysql.cj.jdbc.Driver.

-   Opciones de JPA/Hibernate: spring.jpa.hibernate.ddl-auto=update,
    spring.jpa.show-sql=true, y el dialecto correspondiente a MySQL.

**4. Ejecución de la aplicación**

-   Al iniciar el proyecto desde la clase principal (marcada con
    \@SpringBootApplication), **Spring Boot conecta automáticamente**
    con la base de datos configurada.

-   Hibernate analiza todas las clases anotadas con \@Entity.

-   Con base en esas entidades, se generan las tablas correspondientes
    en la base de datos.

-   Cada campo de la clase se traduce en una columna.

-   Si existen relaciones entre entidades (ejemplo: \@OneToMany,
    \@ManyToOne, \@OneToOne), estas se reflejan en la base de datos con
    sus respectivas llaves foráneas.

**Recomendaciones**

**1. Definir reglas desde el inicio**

-   Establece un esquema de nombres para clases, atributos y relaciones.

-   Prepara una guía de estilo o un documento de arquitectura para
    asegurar que todos los desarrolladores trabajen bajo los mismos
    lineamientos.

**2. Compilar y validar continuamente**

-   Ejecuta el proyecto cada vez que se añada una clase nueva.

-   Implementa pruebas unitarias básicas que confirmen el correcto
    funcionamiento de las entidades y sus relaciones.

**3. Inicialización adecuada de colecciones y objetos**

-   Nunca dejes listas, mapas u objetos sin inicializar.

-   Usa constructores o declaraciones directas (new ArrayList\<\>(),
    etc.) para evitar excepciones como NullPointerException.

**4. Configuración cuidadosa de relaciones JPA**

-   Define siempre atributos como mappedBy, cascade, fetch y
    \@JoinColumn en las asociaciones.

-   Utiliza \@JsonManagedReference y \@JsonBackReference para prevenir
    ciclos en la serialización JSON.

**5. Documentar el código**

-   Añade comentarios claros y concisos en clases y atributos.

-   Esto facilita la comprensión del código tanto para otros
    desarrolladores como para ti misma en el futuro.

**6. Mantener el archivo application.properties completo**

-   No dejes parámetros incompletos: incluye credenciales de base de
    datos, dialecto de Hibernate y puerto del servidor.

-   Usa perfiles separados (application-dev.properties,
    application-prod.properties) para diferenciar entornos.

**7. Reducir código repetitivo**

-   Implementa librerías como **Lombok** (@Getter, \@Setter)

-   Esto mejora la legibilidad y disminuye el boilerplate.

**8. Manejo correcto de enums**

-   Declara los enums con \@Enumerated(EnumType.STRING) para evitar que
    se almacenen como valores numéricos.

-   Asegúrate de que sus valores estén alineados con el dominio del
    sistema.
