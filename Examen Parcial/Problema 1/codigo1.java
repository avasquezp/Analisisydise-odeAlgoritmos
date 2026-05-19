import java.util.Scanner;

public class Problema1 {
    // en esta parte utiliza ek metodo recursivo que va a verificar si el arreglo esta bien ordenado de menor hasta el mayor 
    public static boolean orden(int[] array, int izquierda, int derecha) {
        // el caso base es que los indices se cruzaron o son iguales es que esta ordenado
        if (izquierda >= derecha) return true;
         // si el extremo que esta a la izquierda es mayor que el derecho significa que no esta ordenado 
        if (array[izquierda] > array[derecha]) return false;
         // si es que el par izquierdo no esta bien ordenado va a retornar un false
        if (array[izquierda] > array[izquierda + 1]) return false;
        // se va a achicar por ambos lados
        return orden(array, izquierda + 1, derecha - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("cuantos numeros: ");
        int tam = sc.nextInt();
        int[] array = new int[tam];

        for (int i = 0; i < tam; i++) {
            System.out.print("numero " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        System.out.println(orden(array, 0, array.length - 1));
        sc.close();
    }
}
