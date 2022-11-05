package listas;

/**
 *
 * @author andum
 */
public class Principal {

    public static void main(String[] args) {
        //Se crea una lista Circular con el nombre lis
        ListaCircular lis = new ListaCircular();
        
        //Se crea y asigna un nombre al cajero
        lis.asignarCajero(0, "Juan");
        
        //Se le agregan nuevos clientes a la lista con la cantidad de operaciones
        lis.ingresarNodo(23, "Julián");
        lis.ingresarNodo(19, "Pepe");
        lis.ingresarNodo(16, "Javier");
        lis.ingresarNodo(21, "Andres");
        lis.ingresarNodo(8, "Carol");
        
        //Se llama el método para mostrar la lista
        lis.desplegarLista();
        
        //Se empiezan a atender los clientes con el metodo:
        lis.atender();
    }  
}
