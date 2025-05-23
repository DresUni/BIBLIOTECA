// esta clase contuene el metodo principal y sera el controlador de nuestro menu 
import java.util.Scanner; //importamos la clase Scanner

public class Main {// creamos la calse llamada Main
    public static void main(String[] args) { // metodo principal de nuestro codigo
        Biblioteca biblioteca = new Biblioteca(); // creamos nuestro metodo constructor

      //Insertamos 7 libros de diferentes autores
        biblioteca.agregarLibro(new Libro("1984", "George Orwell"));// agregamos un libro a nuestro arbol por medio del metodo agregarLibro que esta en la clase Biblioteca
        biblioteca.agregarLibro(new Libro("cien años de soledad", "gabo"));// agregamos un libro a nuestro arbol por medio del metodo agregarLibro que esta en la clase Biblioteca
        biblioteca.agregarLibro(new Libro("el principito", "Antoine de Saint-Exupéry"));// agregamos un libro a nuestro arbol por medio del metodo agregarLibro que esta en la clase Biblioteca
        biblioteca.agregarLibro(new Libro("don Quijote de la Mancha", "Miguel de Cervantes"));// agregamos un libro a nuestro arbol por medio del metodo agregarLibro que esta en la clase Biblioteca
        biblioteca.agregarLibro(new Libro("la Sombra del Viento", "Carlos Ruiz Zafón"));// agregamos un libro a nuestro arbol por medio del metodo agregarLibro que esta en la clase Biblioteca
        biblioteca.agregarLibro(new Libro("it", "Stephen King"));// agregamos un libro a nuestro arbol por medio del metodo agregarLibro que esta en la clase Biblioteca
        biblioteca.agregarLibro(new Libro("diccionario", "rae"));// agregamos un libro a nuestro arbol por medio del metodo agregarLibro que esta en la clase Biblioteca

        // Agregamos 3 usuarios desde el principio
        biblioteca.agregarUsuario("Antonio", "001");//agregamos un usuario a nuestra tabla hash por medio del metodo agregarUsuario que esta en la clase Biblioteca
        biblioteca.agregarUsuario("María", "002");//agregamos un usuario a nuestra tabla hash por medio del metodo agregarUsuario que esta en la clase Biblioteca
        biblioteca.agregarUsuario("Luis", "003");//agregamos un usuario a nuestra tabla hash por medio del metodo agregarUsuario que esta en la clase Biblioteca

        Scanner sc = new Scanner(System.in); //creamos el metodo construcor de la biblioteca Scanner
        int opcion;// variable de tipo entero que se usara para seleccionar la opcio. de nuestro menu

        do {// bucle para manejar el menu de nuestro proyecto
            System.out.println("\n--- Menú Biblioteca ---");// encabezado
            System.out.println("1. Buscar libro por título");// opcion 1
            System.out.println("2. Buscar libros por autor");// opcion 2
            System.out.println("3. Prestar libro");//opcion 3
            System.out.println("4. Devolver libro");// opcion 4
            System.out.println("5. Consultar historial de préstamos de usuario");//opcion 5
            System.out.println("6. Agregar usuario");// opcion 6
            System.out.println("0. Salir"); //salie
            
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiamos

            switch (opcion) { // switcj para manejar nuestro menu, este recibira la variable de opcion 
                case 1: //caso 1
                    System.out.print("Ingrese título del libro: ");// dialogo para ingresar el titulo del libro a buscar 
                    String tituloBuscar = sc.nextLine(); // se ingresa por consola
                    Libro libro = biblioteca.buscarLibro(tituloBuscar); // se llama a el metodo buscarLibro y el valor se otrogara a un nodo llamado libro donde se almacenara
                    if (libro != null) { // si el nodo libro es diferente de nulo significara que el libro existe 
                        System.out.println("Libro encontrado: " + libro); // dialogo para imprimir el libro que esta buscando
                    } else { // si libro es igual a nulo entoences no encontro coincidencia por ende el libro no existe
                        System.out.println("Libro no encontrado."); // dialogo para reafirmar que el libro buscado no existe
                    }// se cierra el else
                    break;// se cierra el caso

                case 2: // caso 2
                    System.out.print("Ingrese autor: ");// dialogo para ingresar el autor del libro a buscar
                    String autorBuscar = sc.nextLine(); // se ingresa por consola
                    biblioteca.buscarLibrosPorAutor(autorBuscar); // se llama al metodo buscarLibrosPirAutor
                    break; // se cierra el caso

                case 3: // caso 3
                    System.out.print("Nombre del usuario: "); //dialogo pars ingresar el nombre del usuario que va a hacer el prestamo del libro
                    String nombreUserPres = sc.nextLine(); // se ingresa por consola

                    System.out.print("Título del libro: ");//dialogo para ingresar el titulo del libro que desea prestar
                    String tituloPres = sc.nextLine(); // se ingresa por consola

                    System.out.println("Fecha de préstamo:"); // dialogo para ingresar la fecha de prestamo
                    System.out.print("Día: ");// dialogo para especificar el dia de prestamo
                    int diaPres = sc.nextInt(); //se ingresa por consola
                    System.out.print("Mes: ");//dialogo para especificar el mes prestamo
                    int mesPres = sc.nextInt(); //se ingresa por consola
                    System.out.print("Año: ");//dialogo para especificar el año prestamo
                    int añoPres = sc.nextInt(); //se ingresa por consola

                    System.out.println("Fecha de devolución (vencimiento):");// dialogo para ingresar la fecha de vencimiento
                    System.out.print("Día: ");//dialogo para especificar el dia vencimiento
                    int diaDev = sc.nextInt(); //se ingresa por consola
                    System.out.print("Mes: ");//dialogo para especificar el mes vencimiento
                    int mesDev = sc.nextInt(); //se ingresa por consola
                    System.out.print("Año: ");//dialogo para especificar el año vencimiento
                    int añoDev = sc.nextInt(); //se ingresa por consola
                    

                    biblioteca.prestarLibro(nombreUserPres, tituloPres,
                            diaPres, mesPres, añoPres,
                            diaDev, mesDev, añoDev); // se le pasan los datos ingresados por consola a el metodo prestar libro
                    break; // se cierra caso

                case 4: // caso 4
                    System.out.print("Nombre del usuario: "); // dialogo para ingresar el nombre del usuario
                    String nombreUserDev = sc.nextLine(); // se ingresa por consola

                    System.out.print("Título del libro a devolver: "); // dialogo para ingresar el titulo del libro que va a devolver
                    String tituloDev = sc.nextLine(); // se ingresa por consola

                    biblioteca.devolverLibro(nombreUserDev, tituloDev); // se pasan los valores ingresados por consola a el metodo devolverLibro
                    break; //se cierra el caso

                case 5:
                    System.out.print("Nombre del usuario: ");// dialogo para ingresar el nombre del usuario que va a devolver el libro
                    String nombreUserHist = sc.nextLine(); // se ingresa por consola

                    Usuario usuario = biblioteca.obtenerUsuario(nombreUserHist); // se pasa el dato de la variable a el metodo obtenerUsuario y el valor que se retorne se guardara en la variable usuario de tipo tabla hash
                    if (usuario != null) { // si usuario es diferente de nulo significara que si encontro una coincidencia
                        System.out.println("Historial de préstamos de " + nombreUserHist + ":"); // dialogo que mostrara el estado actual del usuario buscado 
                        usuario.mostrarPrestamos(); // se retornara el valor de mostrarPrestamos (atributo) del usuario buscado 
                    } else {// si usuario es nulo significara que no encontro coincidencia alguna
                        System.out.println("Usuario no encontrado."); // dialogo para reafirmar que no se encontraron coincidencias
                    } // se cierra el else
                    break; // se cierra el caso 5

                case 6: // caso 6
                    System.out.print("Nombre del nuevo usuario: "); // dialogo para ingresar el nombre del usuario que desea ingresar
                    String nuevoNombre = sc.nextLine(); // se ingresa por consola
                    System.out.print("Código del nuevo usuario: "); // dialogo para ingresar el codigo del usuario que desea ingresar 
                    String nuevoCodigo = sc.nextLine(); // se ingresa por consola
                    biblioteca.agregarUsuario(nuevoNombre, nuevoCodigo);  // se pasan los valores ingresados al metodo agregarUsuario
                    System.out.println("Usuario agregado correctamente."); // dialogo que reafirma que el usuario fue guardado de forma correcta
                    break; // se cierra el caso 6

                case 0: // caso0
                    System.out.println("Gracias por usar la biblioteca."); // mensaje de despedia
                    break; // se cierra el caso 

                default: // en caso de que el caso no existe 
                    System.out.println("Opción no válida."); // dialogo para afirmar que la opcion ingresada no es valida
                    break; // se cierra el default
           } // se cierra el switch

        } while (opcion != 0); //bucle para que se repita el menu mientras que la variable opcion sea diferente de 0

        sc.close(); // cerramos la biblioteca Scanner
    } // se cierra el metodo principal main
} // se cierra la clase Main