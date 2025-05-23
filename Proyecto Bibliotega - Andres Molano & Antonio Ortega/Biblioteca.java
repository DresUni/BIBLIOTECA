import java.util.HashMap; // Permite usar una tabla para guardar datos con una clave para encontrarlos 
import java.util.ArrayList; // Importa la clase ArrayList para usar listas dinámicas que almacenan elementos ordenados

public class Biblioteca { // se inicia la clase con metodo de acceso publico llamada Biblioteca
    private ArbolBST libros; // arbol para almacenar los libros y de acceso privado
    private HashMap<String, Usuario> usuarios; // mapa para almacenar usuarios (clave: nombre) de acceso privado

    public Biblioteca() { //metodo para inicializar el arbol y el mapa 
        libros = new ArbolBST(); // inicializamos el arbol de libros
        usuarios = new HashMap<>(); // inicializamos el mapa de usuarios
    }// se cierra el metodo Biblioteca

    public void agregarLibro(Libro libro) { //metodo para insertar el un libro en la clase Libro
        libros.insertar(libro); // inserta un libro en el arbol
    } // se cierra el metodo agragarLibro

    public Libro buscarLibro(String titulo) { // metodo para buscar un libro llamando al metodo buscar que esta en ArbolBST
        return libros.buscar(titulo); // busca un libro por titulo en el arbol
    } // Se cierra el metodo buscarLibro

    
    public void buscarLibrosPorAutor(String autor) {// metodo para buscar libros por autor recorriendo el arbol y guardandolos en una lista
        ArrayList<Libro> encontrados = new ArrayList<>(); // lista para guardar libros encontrados
        buscarPorAutorRec(libros.raiz, autor, encontrados); // llamada del metodo buscarPorAutorRec traido desde la clase ArboBST

        if (encontrados.isEmpty()) { // Si no encontro ningun libro
            System.out.println("No se encontraron libros del autor: " + autor); // immprime si no se encontro ningun libro
        } else { // si encontro un libro
            System.out.println("Libros encontrados del autor " + autor + ":"); // si encuentra un libro imprime el texto
            for (Libro libro : encontrados) {// hace el recorrido de la lista encontrados
                System.out.println(libro); // muestra los libros encontrados
            } // se cierra el for que recorre la lista encontrados
        }//se cierra el else
    } // se cierra el metodo buscarPorAutorRec

    
    private void buscarPorAutorRec(nodo raiz, String autor, ArrayList<Libro> lista) {// metodo para buscar libros por autor en el arbol
        if (raiz != null) { // Si no es un vecotr vacio hara...
            buscarPorAutorRec(raiz.izquierdo, autor, lista); // busca en subarbol izquierdo
            if (raiz.libro.autor.equals(autor)) { // si autor coincide se agrega a lista
                lista.add(raiz.libro); // lo agrega a lista
            } //se cierra el if que agrega la coincidencia a la lista
            buscarPorAutorRec(raiz.derecho, autor, lista); // Busca en subarbol derecho
        } //se cierra el primer if que valida que el arbol no este vacio
    } //se cierra el metodo de buscarPorAutorRec

    
    public void agregarUsuario(String nombre, String codigo) { //metodo que agrega un usuario nuevo si no existe ya en el mapa
        if (usuarios.containsKey(codigo)) { // Si usuario ya existe
            System.out.println("El usuario ya existe."); 
            return;// se cierra el ciclo de forma abrupta
        } // se cierra el 
        usuarios.put(nombre, new Usuario(nombre, codigo)); //Si el usuario no esta repetido entonces el usuario se guardara 
    }// se cierra el metodo agregarUsuario

  
    public Usuario obtenerUsuario(String nombre) {   // metodo para obtener un usuario por su nombre
        return usuarios.get(nombre); // devuelve el usuario o null si no existe
    } // se cierra el metodo de obtenerUsuario

  
    private boolean estaPrestado(String tituloLibro) { // metodo que verifica si un libro esta prestado
     
        for (Usuario usuario : usuarios.values()) { // for para recorrer todos los valores del mapa usuarios y dar acceso a Prestamo
           
            for (Prestamo prestamo : usuario.prestamos.values()) {// for para recorrer todos los valores de la lista prestamos
                // Si el libro esta prestado y no ha sido devuelto 
                if (prestamo.libro.titulo.equals(tituloLibro) && !prestamo.devuelto) { // si el libro está prestado y no devuelto
                    return true; // retorna true dando a entender que el libro no esta disponible
                } // se cierra el if
            } // se cierra el for de prestamos
        } //se cierra el for de usuarios
        return false; // Libro disponible
    }

    
    public boolean prestarLibro(String nombreUsuario, String tituloLibro,
                                int diaPres, int mesPres, int anioPres,
                                int diaVen, int mesVen, int anioVen) {// metodo para realizaz el prestamo de un libro a un usuario

        Usuario usuario = obtenerUsuario(nombreUsuario); // Busca usuario
        Libro libro = buscarLibro(tituloLibro); // Busca libro

        if (usuario == null) { // Usuario no encontrado
            System.out.println("Usuario no encontrado.");// se imprime el texto de la situacion coerrspondiente ( Usuario no encontrado )
            return false;//si el valor no es nulo entonces retorna false
        }
        if (libro == null) { // Libro no encontrado
            System.out.println("Libro no encontrado.");// se imprime el texto de la situacion coerrspondiente (Libro no encontrado )
            return false;//si el valor no es nulo entonces retorna false
        }
        if (estaPrestado(tituloLibro)) { // Si libro no esta disponible
            System.out.println("El libro ya esta prestado y no disponible.");// se imprime el texto de la situacion coerrspondiente ( El libro ya esta prestado y no disponible )
            return false;//si el valor no es nulo entonces retorna false
        }

        
        Prestamo prestamo = new Prestamo(libro, diaPres, mesPres, anioPres, diaVen, mesVen, anioVen);// se crea un nuevo prestamo con las fechas y datos de libro y lo agrega al usuario
        usuario.agregarPrestamo(prestamo); // se agrega el prestamo al usuario guargandolo en la lista de prestamo
        System.out.println("Prestamo registrado correctamente."); // dialogo para confirmar que el prestamo se hizo de forma correcta
        return true; // retorna true para confirmar que la operacion de guardar el valor fue exitosa
    }// se cierra el metodo prestarLibro

   
    public boolean devolverLibro(String nombreUsuario, String tituloLibro) {  // metodo devuelve un libro prestado por un usuario
        Usuario usuario = obtenerUsuario(nombreUsuario); // busca el usuario por medio del metodo obtenerUsuario y el valor retornado se agrega a la variable usuario  

        if (usuario == null) { // si usuario es igual a nulo significara que noencontro coincidencia
            System.out.println("Usuario no encontrado."); // dialogo para confirmar que se encontro el usuario 
            return false;  // se retonra false para dar a entender que el usuario no existe
        } // se cierra el if

        
        for (Prestamo prestamo : usuario.prestamos.values()) {// for que recorre los prestamos del usuario para encontrar el libro no devuelto
            if (prestamo.libro.titulo.equals(tituloLibro) && !prestamo.devuelto) {// verifica si el prestamo corresponde al libro buscado y aun no ha sido devuelto
                prestamo.devuelto = true; // marca el libro como devuelto
                System.out.println("Libro devuelto correctamente."); // dialogo para confirmar que el libro se devolvio de forma correcta
                return true; // se retorna true para dar a entender que el usuario si existe
            } // se cierra el if
        } // se cierra el for que recorre nuestra lista prestamo
        System.out.println("No se encontro un prestamo activo para ese libro y usuario."); // si al hacer el recorrido no se cumple la condicion significara que no se encontro un prestamo vigente para el libro
        return false; // retorna falso para señalar que no se realizo la devolucion porque el prestamo no existe o ya fue devuelto
    } 

  
    public Prestamo obtenerPrestamoActivo(String nombreUsuario, String tituloLibro) { // metodo para obtener el prestamo activo de un libro para un usuario
        Usuario usuario = obtenerUsuario(nombreUsuario);// busca el usuario por medio del metodo obtenerUsuario y el valor retornado se agrega a la variable usuario 
        if (usuario == null) return null; // si usuario no es igual a nulo el metodo retornara el valor de null

       
        for (Prestamo prestamo : usuario.prestamos.values()) {// for que Recorre prestamos para buscar el activo
            if (prestamo.libro.titulo.equals(tituloLibro) && !prestamo.devuelto) {
                return prestamo;// retorna prestamo si hay activo
            }
        }
        return null; // No hay prestamo activo
    }// cierre de Prestamo

   
    public void mostrarLibros() { // metodo que Muestra todos los libros en orden del arbol
        libros.recorridoInOrden(); // llamamos al metodo recorridoInOrden de la clase ArbolBST
    }// cierre de mostrarLibros

    
    public void mostrarUsuarios() {// Muestra todos los usuarios registrados
        // Recorre cada entrada del mapa usuarios
        for (HashMap.Entry<String, Usuario> entrada : usuarios.entrySet()) { // hacemos el recorrido de nuestra tabla hash creando una variable auxiliar y dandole acceso por medio de entrySet
            System.out.println("Usuario: " + entrada.getKey()); // Muestra nombre del usuario porque esta representa la clave de la tabla hash
        }// cierre del for 
    }//cierre del metodo de mostrar los usuarios
}// cierre de la clase Biblioteca