# API REST de Gestión de Tareas

Este es mi primer proyecto de una API REST que permite gestionar tareas. La API incluye endpoints que manejan datos tanto con como sin el uso de DTOs. 
Aún está en desarrollo, pero actualmente puedes realizar operaciones CRUD básicas.

## Tecnologías Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- MYSQL 

### Pasos previos para el funcionamiento correcto

Antes de poder utilizar los endpoints, es necesario insertar los valores iniciales en la tabla `status` para asegurarse de que los estados de las tareas estén disponibles. 
Esto se puede hacer ejecutando las siguientes instrucciones SQL en la base de datos:

sql
-- Insertar los estados en la tabla `status`
INSERT INTO status (status_name) VALUES ('pendiente');
INSERT INTO status (status_name) VALUES ('progreso');
INSERT INTO status (status_name) VALUES ('completada');

-- Confirmar los cambios en la base de datos
COMMIT;

### Endpoints

**POST /tasksDTO** - Crear una nueva tarea utilizando DTO

Ejemplo de cuerpo de la solicitud (JSON):


{
  "title": "Mi tarea",
  "description": "Descripción de la tarea",
  "dueDate": "2024-12-31",
  "statusName": "pendiente"
}

**POST /tasks** - Crear una nueva tarea

Ejemplo de cuerpo de la solicitud (JSON):

{
    "title": "Complete project documentation",
    "description": "Finish writing the documentation for the project",
    "dueDate": "2023-12-31",
    "status": {
        "id": 1
    }
}
### **GET /tasksDTO** - Obtener todas las tareas usando el DTO, excluyendo el campo `id` de las tareas.

Este endpoint devuelve una lista de todas las tareas almacenadas, pero con los datos enviados a través del **DTO (Data Transfer Object)**,
donde el campo `id` de las tareas está restringido para no ser expuesto en la respuesta.

#### Respuesta Exitosa (200 OK)

- **Cuerpo de la respuesta:**

  
   {
    "title": "Mi tarea",
    "description": "Descripción de la tarea",
    "dueDate": "2024-12-31",
    "statusName": "pendiente"
   }

