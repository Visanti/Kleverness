# Kleverness
Reto Kleverness

##Crear la base de datos prueba en postgres

###_En la APP Kleverness_
_Configurar aplication/properties_
_spring.datasource.url=jdbc:postgresql://localhost:5432/prueba_
_spring.datasource.username=postgres_
_spring.datasource.password=admin_
_spring.datasource.driver-class-name=org.postgresql.Driver_

####Crear usuario
#Ejecutar UsuarioTest con JUnit
	_Se crea:_
	_usuario:visa_
	_password:123

#Generar el archivo .Jar con Maven install_
#_Crear imagen Docker_
#_Abrir un CMD y ejecutar el dockerfile con el siguiente comando_
_docker build -t prueba . _

#Ejecutar la imagen de Docker en un contenedor
docker run -d -p 5050:5050 prueba

#Para subir a AWS
#Configurar en el archivo deploy PEM y Servidor
Ejecutar ./deploy 

#Documentacion
Swagger
http://localhost:5000/swagger-ui.html

