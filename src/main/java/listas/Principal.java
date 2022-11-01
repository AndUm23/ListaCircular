package listas;

/**
 *
 * @author andum
 */
public class Principal {

    public static void main(String[] args) {
        //Se crea una lista Circular con el nombre lis
        ListaCircular lis = new ListaCircular();
        
        //Se le agregan nuevos nodos a la lista
        lis.ingresarNodo(32);
        lis.ingresarNodo(42);
        lis.ingresarNodo(16);
        lis.ingresarNodo(21);
        lis.ingresarNodo(8);
        
        //Se llama el método para mostrar la lista
        lis.desplegarLista();
    }  
}
