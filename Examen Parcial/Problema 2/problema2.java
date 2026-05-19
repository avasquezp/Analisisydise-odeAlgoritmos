import java.util.Scanner;

public class Problema2 {
    // retorna el segundo mayor del arreglo
    public static int segundoMayor(int[] arr, int izq, int der) {
        
        //  en el caso base los dos elementos los comparamos y vamos a retornar el menor
        if (der - izq == 1) {
            return Math.min(arr[izq], arr[der]);
        }

        // en este solo va un elemento 
        if (izq == der) return arr[izq];

        // lo divide
        int mid = (izq + der) / 2;

         // va a cada mitad
        int maxIzq = Math.max(arr[izq], arr[mid]);
        int maxDer = Math.max(arr[mid + 1], arr[der]);

         // combina el segundo mayor es el menor entre los maximos de cada mitad C
        if (maxIzq > maxDer) {
            return Math.max(maxDer, segundoMayor(arr, izq, mid));
        } else {
            return Math.max(maxIzq, segundoMayor(arr, mid + 1, der));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("cuantos numeros: ");
        int tam = sc.nextInt();
        int[] array = new int[tam];

        for (int i = 0; i < tam; i++) {
            System.out.print("numero " + (i + 1) + 
