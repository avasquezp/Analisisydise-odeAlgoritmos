import java.util.Scanner;

public class CoberturaAntenas {

    //  va a recibir el arreglo vacio y lo llena con las posiciones que se va a ingresar
    static void leerCasas(Scanner sc, int[] casas) {

        for (int i = 0; i < casas.length; i++) {

            // pide la posicion de cada casa una por una
            System.out.print("posicion de la casa " + (i + 1) + ": ");
            casas[i] = sc.nextInt();
        }
    }

    // ── Método para ordenar las casas de menor a mayor ────────────────
    // aca se va a ordenar de menor a mayor y que siempre empiece por la casa que este mas a la izquierda 
    static void ordenar(int[] casas) {

        for (int i = 0; i < casas.length - 1; i++) {
            for (int j = i + 1; j < casas.length; j++) {

                // si es que una casa de la derecha tiene menor posicion se van a intercambiar 
                if (casas[j] < casas[i]) {
                    int tmp  = casas[i];
                    casas[i] = casas[j];
                    casas[j] = tmp;
                }
            }
        }
    }

    // aca en cada paso toma la primera casa sin cubrir y coloca la antena en R poiciones a su derecha para cubrir la mayor cantidad de casas
    static void colocarAntenas(int[] casas, int R) {

        // En el peor caso hay una antena por cada casa
        int[] antenas   = new int[casas.length];
        int cantAntenas = 0;
        int i = 0;

        while (i < casas.length) {

            int primeraSinCubrir = casas[i];

            // va a colocar la antena R posiciones a la derecha de las casas asi se llega a maximizar la cobertura hacia adelante 
            int posAntena = primeraSinCubrir + R;

            antenas[cantAntenas] = posAntena;
            cantAntenas++;

            // va a saltar todas las casas que quedan cubiertas por la antena 
            while (i < casas.length && casas[i] <= posAntena + R) {
                i++;
            }
        }

        System.out.println("\nantenas colocadas aproximadamente en:");
        for (int j = 0; j < cantAntenas; j++) {
            System.out.println(antenas[j]);
        }
        System.out.println("cantidad total: " + cantAntenas);
    }

    // solo va a pedir los datos iniciales y va a llamar a los metodos 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("numero de casas: ");
        int n = sc.nextInt();

        int[] casas = new int[n];

        // va a leer el rango de cobertura
        System.out.print("rango de cobertura R: ");
        int R = sc.nextInt();

        leerCasas(sc, casas);   
        ordenar(casas);           
        colocarAntenas(casas, R); 
    }
}
