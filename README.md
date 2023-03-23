# BIOTEST
## ¿Que es BioTest?
Biotest es un proyecto, conformado por una aplicacion de escritorio, 
una aplicacion de android, una base de datos y un servidor PHP el cual permite a sus
usuarios aprender biologia jugando
## Funciones
### Aplicacion de Escritorio
- Usuario Administrador
    - Administrar preguntas
    - Administrar categorias
    - Administrar cuestionarios
    - Administrar usuarios
    - Crear una copia de seguridad
    - Restaurar una copia de seguridad
    - Editar sus datos
    - Seleccionar un modo de juego
    - Jugar
    - Ver los resultados de una partida
    - Realizar informes
    - Cerrar sesion
- Usuario Normal
    - Editar sus datos
    - Seleccionar un modo de juego
    - Jugar
    - Ver los resultados de una partida
    - Cerrar sesion
## Puesta en Marcha
## Base de datos
### Descargar xampp
Para poder utilizar este proyecto, es necesario descargar XAMPP. Puede descargar XAMPP desde la [página oficial de descarga](https://www.apachefriends.org/download.html).
## Importación de la base de datos

Dirijase a la siguiente ruta:

`./database/preguntas.sql`

Para crear la base de datos dirijase a la consola de comandos y escriba la siguiente sentencia:

```sql
CREATE DATABASE preguntas;
````
Ahora para importar el script con el contenido de la base de datos escriba el siguiente comando

```bash
mysql -u usuario -p base_de_datos < /ruta/a/mi/archivo.sql
````
### Configuracion
Para configurar el proyecto dirigase al siguiente archivo:

`./src/controller/baseDeDatos/configuracion.java`

Sustituya el host y la base de datos por los datos correspondientes
con su host y su base de datos
```java
String DBHOST = "localhost";
````
```java
String DBNAME = "preguntas";
````
Despues sustituya el nombre y la contraseña del usuario administrador
por el nombre y la contraseña de su usuario con permisos de administrador en la base de datos
```java
String ADMIN = "name";
````
```java
String PASSWORD_ADMIN = "password";
````
Una vez echo esto sustituya la ruta de instalacion de la carpeta mysql de su xampp
```java
String XAMPP_PATH = "C:/xampp/mysql/";
````
La ruta de instalacion por defecto suele ser:
`C:/xampp/mysql/`

Despues sustituya el email por el email desde el cual se van a mandar los correos
```java
String EMAIL_PASSWORD = "exrsdgkstaivnerh";
````
Genere la clave que le permite enviar correos desde aplicaciones de terceros en su gmail
,si no sabe como hacerlo visite el siguiente enlace: 
[Generado de claves en gmail](https://megacity20.com/support/106).

Despues sustituye la clave por la suya
```java
String EMAIL_PASSWORD = "xxxxxxxxx";
````
Por ultimo coloque el puerto y el host del servidor de correo en caso de que fuera 
necesario, en este caso se usa smtp y no se recomienda cambiarlo
```java
String SMTP_HOST  = "smtp.gmail.com";
````
```java
int SMTP_PORT = 587;
````










