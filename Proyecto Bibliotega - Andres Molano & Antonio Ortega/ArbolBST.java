// Esta clase se usara para usasr los metodos de nuestro arbol, como insercion, buscar y recorrerlo en InOrden
public class ArbolBST { // clase llamada ArbolBST
    nodo raiz; // creamos la raiz de nueztro arbol

    public ArbolBST() { // metodo para crearle un valor a nuestra raiz
        raiz = null; // creamos nuestra raiz con un valor de nulo porque esta vacia
    } // se cierra el metodo de la raiz

    public void insertar(Libro libro) { // creamos el metodo publico insertar que encapsula el metodo insertarRec 
        raiz = insertarRec(raiz, libro); // le damos el valor que retorne el metodo "insertarrec" a nuestra raiz
    }// cerramos el metodo

    private nodo insertarRec(nodo raiz, Libro libro) { //metodo que si tiene el procedimiento para insertar un nodo en nuestro arbol
        if (raiz == null) return new nodo(libro); // si la raiz aun no tiene nodos se retornara el valor del nuevo nodo creado 

        if (libro.titulo.compareTo(raiz.libro.titulo) < 0) /* si el metodo compareTo encuentra una coincidencia entre el valor
        de la raiz.libro.titulo y libro.titulo este metodo retornara un valor de 0
         y si lirbo.titulo es mayor retornara un valor mayor*/
            raiz.izquierdo = insertarRec(raiz.izquierdo, libro); // si la condicion se cumple entonces el nuevo nodo se guardara ala izquierda de la raiz
        else if (libro.titulo.compareTo(raiz.libro.titulo) > 0) // // si el titulo del nuevo libro es mayor alfabeticamente al de la raiz, se insertara en el derecho
            raiz.derecho = insertarRec(raiz.derecho, libro);

        return raiz; //retornamos raiz
    }// cierre del metodo insertarRec


public Libro buscar(String titulo) {// Metodo publico para buscar un libro por su titulo
    return buscarRec(raiz, titulo); // Llama al metodo comenzando desde la raiz del arbol
}// cirre del metodo 


private Libro buscarRec(nodo raiz, String titulo) {// Metodo privado  que busca un libro en el arbol por su titulo
    if (raiz == null) return null; // Si el nodo actual es nulo, el libro no esta en el arbol

    if (titulo.equals(raiz.libro.titulo)) return raiz.libro; // Si el titulo coincide con el del nodo, se devuelve el libro encontrado

    // Si el titulo buscado es menor alfabeticamente, busca en el  izquierdo
    // Si es mayor, busca en el  derecho 
    return (titulo.compareTo(raiz.libro.titulo) < 0) ? buscarRec(raiz.izquierdo, titulo)
                                                     : buscarRec(raiz.derecho, titulo);
}
public void recorridoInOrden() {// Metodo publico que inicia el recorrido inorden del arbol (muestra libros en orden alfabetico)
    recorridoInOrdenRec(raiz); // Llama al metodo  para recorrer desde la raiz
}
private void recorridoInOrdenRec(nodo raiz) { // Metodo  para recorrer el arbol en orden (izquierda, raiz, derecha)
    if (raiz != null) { // Si el nodo no es nulo
        recorridoInOrdenRec(raiz.izquierdo); // Recorre el izquierdo
        System.out.println(raiz.libro); // Muestra el libro del nodo actual
        recorridoInOrdenRec(raiz.derecho); // Recorre el derecho
    }// cierre del if por su el nodo no es nulo
}// cierre del metodo recorridoInOrdenRec
}// cierre del la clase ArbolBST
