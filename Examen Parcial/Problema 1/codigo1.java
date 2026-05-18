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
        int[] array1 = {1, 2, 3, 5, 8};
        int[] array2 = {1, 4, 2, 8};

        // muestra el array 1 y su resultado si es true o false en el compilador 
        System.out.print("array 1: ");
        for (int n : array1) System.out.print(n + " ");
        System.out.println(" = " + orden(array1, 0, array1.length - 1));

        // lo mismo que el array 1
        System.out.print("array 2: ");
        for (int n : array2) System.out.print(n + " ");
        System.out.println(" = " + orden(array2, 0, array2.length - 1));
    }
}
