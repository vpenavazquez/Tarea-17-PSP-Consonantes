public class HiloConsonante implements Runnable{
    //Atributos
    private String consonante;
    private String textoLargo;
    private static int contadorTotal = 0;

    //Constructor
    public HiloConsonante(String consonante, String textoLargo) {
        this.consonante = consonante;
        this.textoLargo = textoLargo;
    }

    public static int getContadorTotal() {
        return contadorTotal;
    }

    //metodo run
    @Override
    public void run() {

        int miContador = 0;
        //Bucle que cuenta dentro del texto que se le añade cuantas veces sale cada consonante añadida
        for(int i = 0; i < textoLargo.length(); i++){
            char letraActual = textoLargo.charAt(i);

            if(letraActual == consonante.charAt(0)){

                miContador++;

            }

        }

        sumarAlTotal(miContador);

        System.out.println("Consonante: " + consonante + " - Apariciones: " + miContador);

    }

    public static synchronized void sumarAlTotal(int cantidad) {
        contadorTotal += cantidad;
    }
}
