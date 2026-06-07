import java.util.Scanner;

public class MochilaFraccional {

    // va a leer los datos del usuario 
    static void leerDatos(Scanner sc, String[] nombres, double[] valores, double[] pesos) {

        for (int i = 0; i < nombres.length; i++) {

            System.out.print("nombre del objeto " + (i + 1) + ": ");
            nombres[i] = sc.next();

            System.out.print("valor: ");
            valores[i] = sc.nextDouble();

            System.out.print("peso: ");
            pesos[i] = sc.nextDouble();
        }
    }

    // ordena por el valor y el peso que va de mayor a menor ──
    static void ordenar(String[] nombres, double[] valores, double[] pesos) {

        int n = nombres.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                // si el objeto j es más provechoso que el objeto i se intercambian
                if ((valores[j] / pesos[j]) > (valores[i] / pesos[i])) {

                    // intercambia valores
                    double tmpV = valores[i];
                    valores[i]  = valores[j];
                    valores[j]  = tmpV;

                    // intercambia pesos
                    double tmpP = pesos[i];
                    pesos[i]    = pesos[j];
                    pesos[j]    = tmpP;

                    // intercambiar nombres, va a llegar a intercambiar los arreglos para que los indices siga representando lo mismo
                    String tmpN = nombres[i];
                    nombres[i]  = nombres[j];
                    nombres[j]  = tmpN;
                }
            }
        }
    }

    // en esta parte en el proceso va a tomar el objeto que sea mas beneficioso y que este disponible, si cabe lo toma si no solo la fraccion 
    static void llenarMochila(String[] nombres, double[] valores, double[] pesos, double capacidad) {

        double restante   = capacidad; 
        double valorTotal = 0;         

        System.out.println("\nobjetos seleccionados:");

        for (int i = 0; i < nombres.length; i++) {

            // si la mochila está llena se detiene
            if (restante == 0) break;

            if (pesos[i] <= restante) {

                valorTotal += valores[i];
                restante   -= pesos[i];
                System.out.println(nombres[i] + " completo");

            } else {

                // se va a calcula que fraccion va a caber 
                valorTotal += (restante / pesos[i]) * valores[i];
                System.out.println((int) restante + "/" + (int) pesos[i]
                    + " Parte del objeto " + nombres[i]);

                // la mochila queda llena tras tomar la fracción
                restante = 0;
            }
        }

        System.out.println("Valor total aproximado: " + (int) valorTotal);
    }

    // aca solo se va a encargar de pedir los datos iniciales y llamar a los métodos
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Capacidad de la mochila: ");
        double capacidad = sc.nextDouble();

        System.out.print("Numero de objetos: ");
        int n = sc.nextInt();

        // crear arreglos para guardar los datos de cada objeto
        String[] nombres = new String[n];
        double[] valores = new double[n];
        double[] pesos   = new double[n];

        // Llamar a los métodos en orden
        leerDatos(sc, nombres, valores, pesos); 
        ordenar(nombres, valores, pesos);
        llenarMochila(nombres, valores, pesos, capacidad); 
    }
}
