
## Crear un proyecto con spring boot que incorpore: Spring web, MySQL driver (o
            MariaDB en su defecto), Spring Data JPA y Spring devtools.

* Crear las siguientes entidades:
 **TagColor: una enumeración, podrá ser de tipo BLUE, YELLOW, GREEN, RED.
Tag: representa una entidad etiqueta con los atributos id, nombre, color (enum
TagColor, almacenada como string en base de datos)
User: representa una entidad usuario con los siguientes atributos id, nombre,
apellido, dni, si está activo sí o no, fecha de nacimiento
Task: representa una entidad tarea, con los atributos id, título, descripción,
finalizada (sí o no), fecha de entrega LocalDate).
BillingInfo: representa la información de facturación de un usuario
Asociaciones entre entidades:
Un usuario tiene muchas tareas, una tarea sólo puede pertenecer a un mismo
usuario a la vez.
Una tarea puede tener muchas etiquetas, una etiqueta puede estar en más de
una tarea a la vez.
Un usuario tiene una información de facturación BillingInfo) y una información
de facturación sólo puede pertenecer a un mismo usuario.
Desarrollos:
Implementar controladores que permitan:
Crear entidades de cada tipo POST utilizando repositorios
Hibernate: proyecto 2
Actualizar entidades de cada tipo PUT utilizando repositorios
Recuperar entidades de cada tipo: recuperar todos, recuperar uno,
recuperar todos filtrando por un atributo utilizando criteria con
EntityManager desde clases DAO.
Los controladores llaman a capa de servicio y el servicio llama a repositorios o
DAOs.

Pruebas con Postman para cada entidad y exportar la colección postman para
agregarla al proyecto en la carpeta raíz.