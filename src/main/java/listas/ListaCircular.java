package listas;

/**
 *
 * @author andum
 */
public class ListaCircular {

    nodo primero;
    nodo ultimo;
    cajero caja;

    //Método constructor para incializar la lista
    public ListaCircular() {
        primero = null;
        ultimo = null;
    }

    //Método para iniciar y dar un nombre al CAJERO
    public void asignarCajero(int c, String n) {
        caja = new cajero();
        caja.clave = c;
        caja.nombre = n;
    }

    //Método para ingresar un Nodo en la lista asignandole a este un valor dado como dato
    public void ingresarNodo(int x, String n) {
        nodo nuevo = new nodo();
        nuevo.dato = x;
        nuevo.nombre = n;

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

    //Método para que se muestre el orden en que se atienden los clientes
    public void atender() {
        // Se va recorriendo la lista y "completando" cuatro de las transacciones traidas
        System.out.println("\nCAJERO: " + caja.nombre);
        nodo actual = new nodo();
        actual = primero;
        do {
            if (ultimo.dato == 0) {
                eliminarNodo(ultimo.nombre);
            }
            // Se "completan" 4 de las transacciones del actual nodo y si aun tiene, se envia a la cola
            actual.dato = actual.dato - 4;
            ultimo = actual;
            primero = primero.siguiente;
            if (actual.dato < 0) {
                actual.dato = 0;
                ultimo = actual;
            }
            desplegarLista();

            //System.out.println(actual.dato + ": " +actual.nombre);
            actual = actual.siguiente;

            //Ya que es una lista circular, actual volverá al primer nodo en un momento.
        } while (actual.dato > 0 || primero.dato > 0 || primero.siguiente.dato > 0);
    }

    // se crea el método para que se muestre la lista de Nodos
    public void desplegarLista() {
        // Se muestra al cajero y seguido, los clientes.
        //System.out.println("CAJERO: " + caja.clave + ": " + caja.nombre);
        System.out.println("\nCAJERO: " + caja.nombre);

        // El nodo actual es el primero y luego va recorriendo la Lista
        nodo actual = new nodo();
        actual = primero;
        do {
            System.out.println(actual.dato + ": " + actual.nombre);
            actual = actual.siguiente;

            //Ya que es una lista circular, actual volverá al primer nodo en un momento.
        } while (actual != primero);
        //Luego de un salto de línea se muestra el dato hacia el que apunta el último nodo para confirmar que es el primero.
        System.out.println("\n" + actual.dato + ": " + actual.nombre);
    }

    //método para eliminar un nodo, usado al terminar las transacciones de un cliente
    public void eliminarNodo(String n) {
        nodo actual = new nodo();
        nodo anterior = new nodo();
        actual = primero;
        anterior = ultimo;        
        do {
            if (actual.nombre.equals(n)){
                if (actual == primero){
                    primero = primero.siguiente;
                    ultimo.siguiente = primero;
                } else if (actual == ultimo){
                    anterior.siguiente = ultimo.siguiente;
                    ultimo = anterior;
                }
            }
            anterior = actual;
            actual = actual.siguiente;

            //Ya que es una lista circular, actual volverá al primer nodo en un momento.
        } while (actual != primero);
    }
}
