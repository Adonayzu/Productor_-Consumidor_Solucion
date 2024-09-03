package productorconsumidor;

public class Buffer {
    private int[] buffer;


    private int contador = 0;

    private int tamanio;

    public Buffer(int tamanio) {
        this.tamanio = tamanio;
        buffer = new int[tamanio];
    }

    public synchronized void producir(int item)  throws InterruptedException {

        while (contador == tamanio){
            wait();
        }
        buffer[contador] = item; /// item para si el espacio 3 se libero entonces alli se agrega el valor
        System.out.println( "Producido: " + item );
        contador++;
        notifyAll();

    }

    public synchronized int consumir() throws InterruptedException {
        while (contador == 0){
            wait();
        }
        contador--;
        int item = buffer[contador]; // lo consume del buffer
        System.out.println( "Consumido: " + item );
        notifyAll();
        return item;

    }
}
