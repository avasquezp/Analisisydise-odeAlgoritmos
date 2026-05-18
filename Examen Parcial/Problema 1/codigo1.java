public class Problema1 {
    
    // en esta parte utiliza ek metodo recursivo que va a verificar si el arreglo esta bien ordenado de menor hasta el mayor 
    public static boolean orden(int[] arr, int inicio) {

        // si es que queda un elemento va a estar ordenado, es como si fuera ir cortando todo el array por la derecha 
        if (tam == 1) return true;
        // si es que el ultimo elemento esta menor que el anterior no va a estar ordenado 
        if (arr[tam - 1] < arr[tam - 2]) return false;
        // aca va a ver si el arreglo esta reducido en 1 
        return orden(arr, tam - 1);
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
