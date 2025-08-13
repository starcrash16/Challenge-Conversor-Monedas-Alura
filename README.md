# 💱 Challenge - Conversor de Monedas en Java (Spring Boot)

Proyecto desarrollado como parte de la **Especialización Backend en Alura**.  
Esta aplicación permite realizar conversiones de una cantidad en una moneda de origen a otra moneda de destino, utilizando datos en tiempo real de [ExchangeRate API](https://www.exchangerate-api.com/).

El programa se ejecuta directamente en la **terminal** y guía al usuario paso a paso para realizar la conversión.

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot** (versión 3.x)
- **Maven**
- **Consumo de API REST**
- **JSON**
- **IDE recomendado:** IntelliJ IDEA / Eclipse / VS Code

## 📋 Descripción

El usuario ingresa:
1. La moneda de origen (ej. USD, EUR, MXN).
2. La moneda de destino.
3. La cantidad a convertir.

La aplicación consulta la tasa de cambio en tiempo real desde **ExchangeRate API** y devuelve el valor equivalente en la moneda seleccionada.

## 📂 Estructura del Proyecto

```plaintext
src/
 ├── main/
 │   ├── java/com/example/conversor
 │   │   ├── service/      # Lógica de conversión y consumo de API
 │   │   ├── model/        # Clases para manejar los datos
 │   │   ├── Main.java     # Punto de entrada de la aplicación
 │   └── resources/
 │       └── application.properties
 └── test/...
⚙️ Configuración
Clonar el repositorio

bash
Copiar
Editar
git clone https://github.com/tuusuario/nombre-del-repositorio.git
cd nombre-del-repositorio
Obtener y configurar API Key

Regístrate en ExchangeRate API.

Obtén tu API Key.

Agrega tu API Key en el archivo application.properties:

properties
Copiar
Editar
exchangerate.api.key=TU_API_KEY_AQUI
Compilar y ejecutar

bash
Copiar
Editar
mvn clean install
mvn spring-boot:run
💻 Ejemplo de uso
plaintext
Copiar
Editar
=== Conversor de Monedas ===
Ingrese la moneda de origen (ej. USD, EUR, MXN):
USD
Ingrese la moneda de destino:
EUR
Ingrese la cantidad a convertir:
100

Tasa de cambio: 0.9123
100 USD equivalen a 91.23 EUR
📦 Dependencias principales
spring-boot-starter

spring-boot-starter-test

com.fasterxml.jackson.core

org.springframework.web.client.RestTemplate

🛠 Mejoras futuras
Validar que los códigos de moneda ingresados sean correctos.

Mostrar lista de monedas disponibles.

Permitir múltiples conversiones sin reiniciar el programa.
