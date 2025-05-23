//esta clase se usara para almacenar la lista de prestamo la cual se usara para especificar la fecha de entregq y vencimiento y definir si el usuario devolvio el lirbo o no 
public class Prestamo {
// se crea la clase Prestamo
    Libro libro;
// atributo se la clase Prestamo
    //atributos de la clase para definir el dia de prestamo y la fecha de vencimiento
    int diaPres, mesPres, añoPres;
//atrubutos dr la clase prestamo de tipo entero
    int diaVen, mesVen, añoVen;
//atrubutos dr la clase prestamo de tipo entero
    boolean devuelto;
// atributo de tipo booleano para definir si el libri se devolvio o no

    public Prestamo(Libro libro, int diaPres, int mesPres, int añoPres, int diaVen, int mesVen, int añoVen) {
//metodo de acceso publico que se va a usar para instanciar los valores del nodo
        this.libro = libro;
// instanciamos la variable Libro que esta dentro de nuestro nodo para otorgarle el valor de la variable Libro (fuera del nodo)
        this.diaPres = diaPres;
//instanciamos la variable diaPres que esta dentro de nuestro nodo para otorgarle el valor de la variable diaPres
        this.mesPres = mesPres;
//instanciamos la variable mesPres que esta dentro de nuestro nodo para otorgarle el valor de la variable mesPres
        this.añoPres = añoPres;
//instanciamos la variable añoPres que esta dentro de nuestro nodo para otorgarle el valor de la variable añoPres
        this.diaVen = diaVen;
//instanciamos la variable diaVen que esta dentro de nuestro nodo para otorgarle el valor de la variable diaVen
        this.mesVen = mesVen;
//instanciamos la variable mesVen que esta dentro de nuestro nodo para otorgarle el valor de la variable mesVen
        this.añoVen = añoVen;
//instanciamos la variable añoVen que esta dentro de nuestro nodo para otorgarle el valor de la variable añoVen
        this.devuelto = false;
// instanciamos devuelto para definir que el lkbro aun esta disponible
    } //se cierra el metodo Prestamo

    @Override
    public String toString() { // tostring para el retorno string necesario
//sin esto el metodo toString por defecto devolvería una ubicación del objeto en memoria, no la informacion legible
        return "Préstamo de: " + libro +
               ", Fecha préstamo: " + diaPres + "/" + mesPres + "/" + añoPres +
               ", Vence: " + diaVen + "/" + mesVen + "/" + añoVen +
               ", Devuelto: " + (devuelto ? "Sí" : "No");
//// retorna el texto
        }// cierra el tostring
    }//cierra la clase prestamo

