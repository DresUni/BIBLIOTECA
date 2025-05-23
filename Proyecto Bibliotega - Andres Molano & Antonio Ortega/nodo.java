// esta clase nos permitira establecer la logica de nuestro arbol de busqueda
public class nodo { //clase llamada nodo
    Libro libro; // atributo que sera un nodo con los atributos de la clase Libro
    nodo izquierdo, derecho;

    public nodo(Libro libro) { // establecemos las direcciones del arbol
        this.libro = libro;/* instanciamos la variable libro que esta dentro de nuestro nodo para otorgarle
el valor de la variable libro y que tendra la estructura de la clase libro */
izquierdo = derecho = null; // definimos izuqierda y derecha como nulo
    }// cierre de nodo
}// cierre de la clase nodo
