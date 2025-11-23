🏯 Castillo Infinito – Sistema de Monitoreo de Pilares

Developed by: Dayanna Ramírez

Sistema backend para gestionar posiciones, mensajes tácticos y datos operativos de los Pilares dentro del Castillo Infinito.

🚀 Tecnologías utilizadas

Java 21

Spring Boot

Spring Data JPA

MySQL

Arquitectura por capas

Manejo de excepciones global

DTOs / Entities expuestas

⚙️ Cómo ejecutar el proyecto
1. Clonar el repositorio
git clone <URL_DEL_REPO>
cd castillo-infinito

2. Crear base de datos MySQL
CREATE DATABASE castillo_infinito;


Configurar application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/castillo_infinito
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update

3. Ejecutar
mvn spring-boot:run

📡 Endpoints
1. Consultar información de un Pilar

GET /api/pillars/{id}

Ejemplo Response

{
  "id": 1,
  "name": "Giyu Tomioka",
  "posX": -500,
  "posY": -200,
  "status": "Combatiendo"
}


2. Obtener triangulación del enemigo

GET /api/intelligence/triangulation

{
  "possibleMuzanPosition": { "x": 0, "y": -50 },
  "confidenceLevel": 0.78,
  "description": "Probabilidad alta de presencia demoníaca en las coordenadas dadas."
}


3. Registrar/actualizar posición de un Pilar

POST /api/pillars/update-position

Request

{
  "pillarId": 1,
  "posX": -480,
  "posY": -210,
  "status": "Herido"
}


Response

{
  "message": "Posición actualizada exitosamente.",
  "pillar": {
    "id": 1,
    "name": "Giyu Tomioka",
    "posX": -480,
    "posY": -210,
    "status": "Herido"
  }
}


4. Registrar mensaje táctico fragmentado

POST /api/messages

Request

{
  "pillarId": 3,
  "fragmentedContent": "Muz... mov... norte... ata..."
}


Response

{
  "id": 14,
  "pillarId": 3,
  "fragmentedContent": "Muz... mov... norte... ata...",
  "reconstructedContent": null,
  "timestamp": "2025-11-20T08:15:43"
}

5. Reconstruir mensaje táctico

PUT /api/messages/{id}/reconstruct

Request

{
  "reconstructedContent": "Muzan se mueve hacia el norte. Preparar ataque."
}


Response

{
  "id": 14,
  "pillarId": 3,
  "fragmentedContent": "Muz... mov... norte... ata...",
  "reconstructedContent": "Muzan se mueve hacia el norte. Preparar ataque.",
  "timestamp": "2025-11-20T08:15:43"
}



Scripts SQL o migraciones

Explicación de cada endpoint
