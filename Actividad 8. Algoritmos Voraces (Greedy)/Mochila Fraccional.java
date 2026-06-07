import java.util.Scanner;

public class MochilaFraccional {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // aqui es la entrada de datos 
        System.out.print("capacidad de la mochila: ");
        double capacidad = sc.nextDouble();

        System.out.print("numero de objetos: ");
        int n = sc.nextInt();

        // en esta parte cada indice i representa un mismo objeto
        String[] nombres = new String[n];
        double[] valores = new double[n];
        double[] pesos   = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("nombre del objeto " + (i + 1) + ": ");
            nombres[i] = sc.next();
            System.out.print("valor: ");
            valores[i] = sc.nextDouble();
            System.out.print("peso: ");
            pesos[i] = sc.nextDouble();
        }

        // aca se hace el ordenamiento greddy, se va ordenando por razon de valor y peso de mayor a menor, un objeto con mayor razon dara mas valor por cada unidad de peso
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((valores[j] / pesos[j]) > (valores[i] / pesos[i])) {
                    // aqui intercambia los 3 arreglos al mismo tiempo para que pueda mantener la relacionado entre el nombre, el valor y peso 
                    double tmpV = valores[i]; valores[i] = valores[j]; valores[j] = tmpV;
                    double tmpP = pesos[i];   pesos[i]   = pesos[j];   pesos[j]   = tmpP;
                    String tmpN = nombres[i]; nombres[i] = nombres[j]; nombres[j] = tmpN;
                }
            }
        }

        // aqui en cada paso se toma el objeto mejor, si es que cabe completo se toma entero pero si no solo toma la fraccion que cabe 
        double restante   = capacidad;
        double valorTotal = 0;

        System.out.println("\nobjetos seleccionados:");

        for (int i = 0; i < n; i++) {

            // si la mochila ya está llena no se toma nada más
            if (restante == 0) break;

            if (pesos[i] <= restante) {
                valorTotal += valores[i];
                restante   -= pesos[i];
                System.out.println(nombres[i] + " completo");

            } else {
                // si el objeto no cabe completo, se calcula la fraccion que cabe
                valorTotal += (restante / pesos[i]) * valores[i];
                System.out.println((int) restante + "/" + (int) pesos[i]
                    + " Parte del objeto " + nombres[i]);
                restante = 0; // mochila llena tras tomar la fracción
            }
        }

        System.out.println("valor total aproximado: " + (int) valorTotal);
    }
}
