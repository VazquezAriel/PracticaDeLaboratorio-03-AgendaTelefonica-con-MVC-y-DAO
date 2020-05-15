# PracticaDeLaboratorio-03-AgendaTelefonica-con-MVC-y-DAO

En esta Practica se implementa los patrones de diseño MVC y DAO persistiendo la información en la memoria de la computadora (sin acceso a una base de datos) mediante el uso del Diccionario Map y la coleccion Lista de Java.

### Lenguaje

+ Java = JDK 1.8
+ IDE = NetBeans Apache 11.3

### Librerias

+ java.util.Collection;
+ java.util.HashMap;
+ java.util.Map;
+ java.util.ArrayList;
+ java.util.List;
+ java.util.Objects;

## Realizacion de la practica

+ Se creo un proyecto en NetBeans con el nombre de Practica03-VazquezAriel en donde se crearon 6 paquetes modelo, vista, controlador (en el cual se aplicará el patrón de diseño MVC), dao , idao (en el cual se aplicará el patrón de diseño DAO) y test (en donde se ejecutará el programa).

+ Se creo las clases Usuario y Teléfono en el paquete modelo siguiendo el diagrama de clases.

**Diagrama de Clases:**

![](https://github.com/VazquezAriel/PracticaDeLaboratorio-03-AgendaTelefonica-con-MVC-y-DAO/blob/master/Diagrama%20de%20Clases.jpeg)
+ En el paquete dao se creó las Interfaces IUsuarioDAO y ITelefonoDAO las cuales tienen los métodos CRUD, también se creó las clases UsuarioDAO y TelefonoDAO que implementan las interfaces ya mencionadas para de esta manera guardar en un Diccionario (Map) objetos de tipo Usuario(UsuarioDAO) y objetos de tipo Teléfono(TelefonoDAO).

+ Se crearon las clases VistaUsuario y VistaTelefono en el paquete vista mediante la implementación de estas clases podremos interactuar con el usuario a través de la pantalla.

+ Se crearon los métodos CRUD dentro de la clase Usuario para poder guardar, editar, eliminar y buscar los Teléfonos guardados en la lista creada dentro de dicha clase

+ Se crearon las clases ControladorUsuario y ControladorTelefono en el paquete controlador a través de estas clases podemos controlar los Usuarios y Teléfonos que el usuario desee ingresar a través de la vista y guardarlos, editarlos,  eliminarlos o buscarlos mediante los métodos CRUD implementados en el DAO. 

+ Se creo la clase Menú dentro del paquete test misma que nos servirá para crear una instancia de las clases UsuarioDAO, TelefonoDAO, ControladorUsuario, ControladorTelefono, VistaUsuario y VistaControlador  e implementar en ella el método main en el cual se creó un menú que le permitirá al usuario escoger la opción que desee ejecutar.

## Ejecucion del programa

**Menu Principal**

![](https://github.com/VazquezAriel/PracticaDeLaboratorio-03-AgendaTelefonica-con-MVC-y-DAO/blob/master/Menu%20Principal.jpeg)

**Registrarse**

![](https://github.com/VazquezAriel/PracticaDeLaboratorio-03-AgendaTelefonica-con-MVC-y-DAO/blob/master/Registro.jpeg)

**Mostrar Usuarios**

![](https://github.com/VazquezAriel/PracticaDeLaboratorio-03-AgendaTelefonica-con-MVC-y-DAO/blob/master/Usuarios%20Registrados.jpeg)

**Inicio de sesion/SubMenu**

![](https://github.com/VazquezAriel/PracticaDeLaboratorio-03-AgendaTelefonica-con-MVC-y-DAO/blob/master/Inicio%20de%20sesion.jpeg)

Si decea comprobar todos las opciones disponibles se recomienda descargar el proyecto y abrirlo en NetBeans
