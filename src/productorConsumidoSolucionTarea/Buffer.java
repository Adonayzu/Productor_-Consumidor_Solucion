package productorConsumidoSolucionTarea;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    //private int[] buffer;
    Queue<Integer> buffer = new LinkedList<>();

    //private int contador = 0;

    private int tamanio;

    public Buffer(int tamanio) {
        this.tamanio = tamanio;

    }

    public synchronized void producir(int item)  throws InterruptedException {

        while (buffer.size() == tamanio){ // si el buffer esta lleno
            wait();
        }
        buffer.add(item); /// va a añadir el item a la cola
        System.out.println( "Producido: " + item );
       // contador++;
        notifyAll();

    }

    public synchronized int consumir() throws InterruptedException {
        while (buffer.isEmpty()){ // cola vacia
            wait();
        }
        //contador--;
        int item = buffer.poll(); // lo consume del buffer y va a retornar el primer elemento de la cola
        System.out.println( "Consumido: " + item );
        notifyAll();
        return item;

    }
}
