//esta clase se usara para crear los usuarios y relacionarlos con sus préstamos de libros
import java.util.HashMap; // Importa la libreria HashMap

public class Usuario { // creamos la clase Usuario

    
    public String nombre; // atributos de la clase Usuarios que se usaran en la lista hash
    public String codigo;// atributos de la clase Usuarios que se usaran en la lista hash
    public HashMap<String, Prestamo> prestamos;  // Guarda los préstamos usando el título del libro como clave.

    // Constructor de la clase Usuario: inicializa nombre, código y crea un HashMap vacío para los préstamos.
    public Usuario(String nombre, String codigo) {//metodo de acceso publico que se va a usar para instanciar los valores del nodo
        this.nombre = nombre;//instanciamos la variable nombre que esta dentro de nuestro nodo para otorgarle el valor de la variable nombre (fueta del nodo)
        this.codigo = codigo;//instanciamos la variable codigo que esta dentro de nuestro nodo para otorgarle el valor de la variable codigo(fuera del nodo)
        this.prestamos = new HashMap<>();// inicializamos prestamo 
    }// se cierra el metodo Usuario

    
    public void agregarPrestamo(Prestamo prestamo) { // metodo para agregar un prestamo al usuario.
        
        prestamos.put(prestamo.libro.titulo, prestamo);// agregamos el prestamo al HashMap usando el titulo del libro como clave
    } // se cierra el metodo agregarPrestamo

    
    public void mostrarPrestamos() {// metodo para mostrar todos los prestamos del usuario
       
        if (prestamos.isEmpty()) { // Si el HashMap esta vacio mostrara un mensaje y terminara abruptamente
            System.out.println("No tiene prestamos."); // imprime si la tabla esta vacia
            return; // se cierrq abruptamente
        }//se cierra el metodo mostrarPrestamos

       
        for (HashMap.Entry entrada : prestamos.entrySet()) { // si hay prestamos, recorre el HashMap y los imprime uno por uno
            System.out.println(entrada.getValue()); // imprime la informacion del prestamo
        } // se cierra el for que recorre prestamos
    }// se cierra el metodo mostratPrestamos
} // se cierra la clase Usuario