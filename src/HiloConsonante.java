public class HiloConsonante implements Runnable{
    //Atributos
    String consonante;
    String textoLargo;
    public static int contadorTotal = 0;

    //Constructor
    public HiloConsonante(String consonante, String textoLargo) {
        this.consonante = consonante;
        this.textoLargo = textoLargo;
    }

    //metodo run
    @Override
    public void run() {

        int miContador = 0;
        //Bucle que cuenta dentro del texto que se le añade cuantas veces sale cada consonante añadida
        for(int i = 0; i < textoLargo.length(); i++){
            char letraActual = textoLargo.charAt(i);

            if(letraActual == consonante.charAt(0)){

                contadorTotal++;

                miContador++;

            }

        }

        System.out.println("Consonante: " + consonante + " - Apariciones: " + miContador);

    }
}
