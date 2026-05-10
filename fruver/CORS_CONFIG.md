# Configuración CORS en Fruver

Este proyecto ahora tiene configurado CORS para permitir que cualquier frontend pueda acceder a la API desde cualquier URL.

## Configuraciones implementadas:

### 1. Configuración global (CorsConfig.java)
Ubicado en: `src/main/java/com/fruver/fruver/config/CorsConfig.java`

Permite CORS para:
- Todos los endpoints (`/**`)
- Cualquier origen (`*`)
- Métodos: GET, POST, PUT, DELETE, OPTIONS, PATCH
- Todos los headers
- Credenciales
- Cache de 3600 segundos

### 2. Configuración por anotación (UsuarioController.java)
Se agregó `@CrossOrigin` al controlador de usuarios para habilitar CORS específicamente para los endpoints de usuarios.

### 3. Configuración en properties (application.properties)
Se agregaron propiedades de configuración en `application.properties`:
```
spring.mvc.cors.allowed-origins=*
spring.mvc.cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS,PATCH
spring.mvc.cors.allowed-headers=*
spring.mvc.cors.allow-credentials=true
spring.mvc.cors.max-age=3600
```

## Para usar desde tu frontend:

Puedes hacer peticiones desde cualquier URL, por ejemplo:

```javascript
// Ejemplo con fetch
fetch('http://localhost:2006/usuarios', {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json'
  }
})
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.error('Error:', error));
```

## Notas:

- El servidor está configurado para ejecutarse en el puerto 2006
- Se permiten peticiones desde cualquier dominio (`*`)
- Si necesitas restringir a dominios específicos, modifica el valor de `allowed-origins` en `CorsConfig.java` o `application.properties`