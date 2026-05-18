public class Problema1 {
    
    // en esta parte utiliza ek metodo recursivo que va a verificar si el arreglo esta bien ordenado de menior hasta el mayor 
    public static boolean orden(int[] arr, int inicio) {
        
        //cuando se llega al ultimo elemento ya no hay pares que comparar 
        if (inicio == arr.length - 1) return true;
        // si quizas el elemento actual es mayor al que le sigue, el arreglo no esta ordenado 
        if (arr[inicio] > arr[inicio + 1]) return false;
        
        // en esta parte se v a verificar lo que sigue del arreglo
        return orden(arr, inicio + 1);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 5, 8};
        int[] array2 = {1, 4, 2, 8};

        // muestra el array 1 y su resultado si es true o false en el compilador 
        System.out.print("array 1: ");
        for (int n : array1) System.out.print(n + " ");
        System.out.println(" = " + orden(array1, 0));

        // lo mismo que el array 1
        System.out.print("array 2: ");
        for (int n : array2) System.out.print(n + " ");
        System.out.println(" = " + orden(array2, 0));
    }
}
