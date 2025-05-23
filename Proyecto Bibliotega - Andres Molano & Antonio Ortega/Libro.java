   //Esta clase se usara para guardar los varoles como titulo y autor de los libros que estaran en el arbol
    public class Libro {//clase llamada libroo
        String titulo;// atributo de la clase libro (nodo)
        String autor;// atributo de la clase libro (nodo)
    
        public Libro(String titulo, String autor) { // metodo de acceso publico que se va a usar para instanciar los valores del nodo
            this.titulo = titulo;// instanciamos la variable titulo que esta dentro de nuestro nodo para otorgarle el valor de la variable titulo (fuera del nodo)
            this.autor = autor;// instanciamos la variable titulo que esta dentro de nuestro nodo para otorgarle el valor de la variable titulo (fuera del nodo)
        } //se cierra el metodo Libro
    
        @Override//sin esto el metodo toString por defecto devolvería una ubicación del objeto en memoria, no la informacion legible.
        public String toString() {// metodo toString que sirve para imprimar los datos en el nodo de forma clara
            return "Libro{Titulo='" + titulo + "', Autor='" + autor + "'}"; // retorna el
        }// cierre del metodo tostring
    }// cierre de la clase libro
