./docker build -t kleverness .
echo "                            " 
echo "*****  IMAGEN GENERADA *****" 
echo "                            "
DIA=`date +"%d%m%Y"`
HORA=`date +"_%H%M"`
ARCHIVO="kleverness${DIA}${HORA}.tar"
docker save kleverness > $ARCHIVO
echo "                                     " 
echo "*****  IMAGEN GUARDADA $ARCHIVO *****" 
echo " "
#---------------------------------------------------------SERVIDOR UAT  --------------------------------------------------------------------------  
   #CONFIGURAR PEN Y SERVIDOR 
scp  -i "/d/VICENTE/key.pem" $ARCHIVO centos@server.amazonaws.com:/home/centos/
echo "                                                                             "
echo "***** Imagen copiada *****"
echo "                                                                             "
ssh -i "/d/VICENTE/key.pem" centos@server.amazonaws.com << EOF
	sudo su -
	docker stop kleverness
	echo "                                                  "          
	echo "***** Contenedor kleverness detenido *****"
	echo "                                                  "
	docker rm kleverness
	echo "                                                   "
	echo "***** Contenedor kleverness eliminado *****"
	echo "                                                   "
	docker rmi kleverness
	echo "                                                  "
	echo "***** Imagen kleverness eliminada ***** "
	echo "                                                  "
	docker load < "/home/centos/$ARCHIVO"
	echo "                                                            "
	echo "***** Imagen kleverness cargada de $ARCHIVO ***** "
	echo "                                                            "
	docker run -d -p 5000:5000 kleverness
	echo "                                                  "
	echo "***** Contenedor kleverness iniciado *****"
	echo "                                                  "
	exit
EOF