# Kleverness
Reto Kleverness

#Crear la base de datos prueba en postgres

#En la APP
#Configurar aplication/properties
#spring.datasource.url=jdbc:postgresql://192.168.1.184:5432/prueba
#spring.datasource.username=postgres
#spring.datasource.password=admin
#spring.datasource.driver-class-name=org.postgresql.Driver

Crear usuario
#Ejecutar UsuarioTest con JUnit
	#Se crea:
	#usuario:visa
	#password:123

#Generar el archivo .Jar con Maven install
#Crear imagen Docker
#Abrir un CMD y ejecutar el dockerfile con el siguiente comando
docker build -t prueba .

#Ejecutar la imagen de Docker en un contenedor
docker run -d -p 5050:5050 prueba

#Para subir a AWS
#Configurar en el archivo deploy PEM y Servidor
Ejecutar ./deploy 

#Documentacion
Swagger
http://localhost:5000/swagger-ui.html

