import java.util.Scanner;

public class ContadorConsonantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array para almacenar las 5 consonantes/caracteres
        String[] consonantes = new String[5];

        System.out.println("Introduce 5 consonantes (una a una):");

        // Lectura y validación una por una
        for (int i = 0; i < 5; i++) {
            String entrada = "";
            boolean esValida = false;

            while (!esValida) {
                System.out.print("Consonante " + (i + 1) + ": ");
                entrada = scanner.nextLine();

                if (entrada.length() == 1 && !entrada.isEmpty()){
                    esValida = true;
                } else {
                    System.out.println("Entrada no válida. Por favor, introduce un único carácter.");
                }

            }

            consonantes[i] = entrada;
        }

        System.out.println("Escribe el texto a analizar:");
        String texto = scanner.nextLine();
        String textoLargo = texto.repeat(2000);

        // Creación del array de hilos
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < 5; i++) {
            HiloConsonante hilo = new HiloConsonante(consonantes[i], textoLargo);
            hilos[i] = new Thread(hilo);
            hilos[i].start();
        }

        // Espera a que finalicen todos los hilos
        for (int i = 0; i < 5; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println("Total de apariciones: " + HiloConsonante.getContadorTotal());

    }
}