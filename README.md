# PROYECTO WEB SERVICE AREP

Cesar Eduardo Lanos Camacho
## Link Funcional Aplicacion Web en Heroku

[con solo HTML](https://proyectoarem1.herokuapp.com/index.html)

[con solo .png](https://proyectoarem1.herokuapp.com/bug.png)

[con solo pojo (Suma)](https://proyectoarem1.herokuapp.com/fram/suma/23)
[con solo pojo (Cuadrado)](https://proyectoarem1.herokuapp.com/fram/cuadrado/23)

## EMPEZAR

Copie el proyecto via git clone en cualquier diretorio para empezar a trabajar:
```
git clone https://github.com/arem2019-1/Proyecto1Arem
```

### Prerequisitos

Tener instalado Java jdk versiones 7+, Maven comandos y git

### Instalando

1. Ejecutar en terminal:

```
$$ mvn package
```
2.(opcional):
si requiere la documetacion del codigo

```
mvn javadoc:javadoc
```
### Ejecutando

2. (Demostracion):
  compile el proyecto en terminal desde la carpeta raiz ejecutando la siguiente linea:
  
```
java -cp target/HttpServer-1.0.0-jar-with-dependencies.jar co.edu.escuelaing.arem.HttpServer.HttpServer
  
```

3. (server):
una vez compilado el programa se ejecuta en el puerto 4567,para probarlo vaya a esta direccion desde su navegador:

```
http://localhost:4567/index.html
  
```
```
http://localhost:4567/bug.png
  
```
```
http://localhost:4567/fram/cuadrado/90
```
```
https://proyectoarem1.herokuapp.com/fram/suma/23

## Licencia

This project is licensed under the GNU General Public License - see the [LICENSE](LICENSE) file for details


