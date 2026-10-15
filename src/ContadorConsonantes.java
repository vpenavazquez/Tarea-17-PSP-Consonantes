import java.util.Scanner;

public class ContadorConsonantes {
    public static void main(String[] args){
        // Peticion de consonantes y texto
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dame 5 consonantes");

        String consonantes = scanner.nextLine();

        System.out.println("Escribe lo que quieras");

        String texto = scanner.nextLine();

        //Repeticion del texto
        String textoLargo = texto.repeat(2000);

        System.out.println(textoLargo.length());

        //Creacion de array de hilos
        Thread hilos[] = new Thread[5];

        //Recorremos la lista de hilos extraemos cada letra e intanciamos cada hilo
        for(int i = 0; i < 5; i++){
            Runnable tarea = new HiloConsonante(String.valueOf(consonantes.charAt(i)), textoLargo);

            //lanzamos todos los hilos a la vez
            hilos[i] = new Thread(tarea);
            hilos[i].start();

        }
        //Hacemos que los hilos se ejecuten primero antes que el main
        for(int i = 0; i < 5; i++){
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("total de repeticiones de consonantes: " + HiloConsonante.contadorTotal);

    }


}
