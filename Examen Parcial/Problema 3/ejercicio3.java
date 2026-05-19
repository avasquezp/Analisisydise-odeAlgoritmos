public class Problema3 {

    // fusiona las dos mitades ordenadas y cuenta las inversiones que cruzan entre ellas
    public static long merge(int[] arr, int izq, int mid, int der) {
        int[] temp = new int[der - izq + 1];
        int i = izq, j = mid + 1, k = 0;
        long inversiones = 0;

        while (i <= mid && j <= der) {
            // si el elemento izquierdo es menor o igual no hay inversion
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                inversiones += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        // copiamos los elementos restantes de la mitad izquierda
        while (i <= mid)  temp[k++] = arr[i++];
        // copiamos los elementos restantes de la mitad derecha
        while (j <= der)  temp[k++] = arr[j++];

        // Copiamos el arreglo temporal al arreglo original
        for (int x = 0; x < temp.length; x++)
            arr[izq + x] = temp[x];

        return inversiones;
    }

    // divide el arreglo y cuenta inversiones recursivamente en cada mitad
    public static long contarInversiones(int[] arr, int izq, int der) {
        
        // un solo elemento, no hay inversiones posibles
        if (izq >= der) return 0;
        int mid = (izq + der) / 2;
        long invIzq  = contarInversiones(arr, izq, mid);
        long invDer  = contarInversiones(arr, mid + 1, der);
        long invCruz = merge(arr, izq, mid, der);
        return invIzq + invDer + invCruz;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 2};

        System.out.print("array: ");
        for (int n : array) System.out.print(n + " ");
        System.out.println("\ninversiones: " + contarInversiones(array, 0, array.length - 1));
    }
}
