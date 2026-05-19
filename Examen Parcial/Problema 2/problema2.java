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
        int[] array1 = {8, 3, 10, 5, 7};

        System.out.print("Array: ");
        for (int n : array1) System.out.print(n + " ");
        System.out.println("\nSegundo mayor: " + segundoMayor(array1, 0, array1.length - 1)); 
    }
}
