package productorconsumidor;

import java.util.function.Consumer;

public class AppProductorCosumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        Thread productor = new Thread(new Productor(buffer));
        Thread consumir = new Thread(new Consumir(buffer));

        productor.start();
        consumir.start();


    }
}
