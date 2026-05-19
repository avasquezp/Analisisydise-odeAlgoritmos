public class Problema3 {

    public static int contarInversiones(int[] arr, int n) {
        
        // solo un elemento pero no hay inversiones
        if (n == 1) return 0;
        // contamos inversiones del elemento actual con todos los anteriores
        int contador = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[n - 1]) {
                contador++;
            }
        }

        // para l recursividad contamos inversiones del resto del arreglo
        return contador + contarInversiones(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 2};

        System.out.print("array: ");
        for (int n : array) System.out.print(n + " ");
        System.out.println("\ninversiones: " + contarInversiones(array, array.length)); 
    }
}
