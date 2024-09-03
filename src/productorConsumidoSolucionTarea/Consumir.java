package productorConsumidoSolucionTarea;

public class Consumir implements Runnable{
    private Buffer buffer;

    public Consumir(Buffer buffer){
        this.buffer = buffer;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            try {
                buffer.consumir();
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

    }
}
