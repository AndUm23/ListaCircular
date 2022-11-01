package listas;

/**
 *
 * @author andum
 */
public class ListaCircular {

    nodo primero;
    nodo ultimo;

    //Método constructor para incializar la lista
    public ListaCircular() {
        primero = null;
        ultimo = null;
    }

    //Método para ingresar un Nodo en la lista asignandole a este un valor dado como dato
    public void ingresarNodo(int x) {
        nodo nuevo = new nodo();
        nuevo.dato = x;

        // En caso de que la lista no haya sido creada, el nodo recien creado es el primero.
        // Siendo el único dato, apunta hacia el mismo.
        if (primero == null) {
            primero = nuevo;
            ultimo = primero;
            primero.siguiente = ultimo;

        //Ya que hay un dato en el primer nodo, el nuevo nodo pasa a apuntar al primero.
        } else {
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            ultimo = nuevo;
        }
    }

    // se crea el método para que se muestre la lista de Nodos
    public void desplegarLista() {
        
        // El nodo actual es el primero y luego va recorriendo la Lista
        nodo actual = new nodo();
        actual = primero;
        do {
            System.out.println(actual.dato);
            actual = actual.siguiente;
            
            //Ya que es una lista circular, actual volverá al primer nodo en un momento.
        } while (actual != primero);
        //Luego de un salto de línea se muestra el dato hacia el que apunta el último nodo para confirmar que es el primero.
        System.out.println("\n" + actual.dato);

    }
}
