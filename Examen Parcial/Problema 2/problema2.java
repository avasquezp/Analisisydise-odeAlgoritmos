public class Problema2 {

    // va a guardar el maximo y segundo maximo
    static int max = 0, segundo = 0;

    public static void segundoMayor(int[] arr, int izq, int der) {
        
        // en el caso base un solo elemento y no hay nada que dividir 
        if (izq == der) return;

        // divide el arreglo en 2 mitades 
        int mid = (izq + der) / 2;

        // va a recursidad para cada mitad
        segundoMayor(arr, izq, mid);    
        segundoMayor(arr, mid + 1, der);  

        // recorre el rango actual buscando el max y el segundo 
        for (int i = izq; i <= der; i++) {
            
            // encontramos un numero mayor al maximo actual
            if (arr[i] > max) {
                segundo = max;  
                max = arr[i]; 
            } 
            // si no es mayor al que es maximo pero si al segundo y no es igual al maximo
            else if (arr[i] > segundo && arr[i] != max) {
                segundo = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = {8, 3, 10, 5, 7};

        segundoMayor(array1, 0, array1.length - 1);

        System.out.print("Array: ");
        for (int n : array1) System.out.print(n + " ");

        System.out.println("\nSegundo mayor: " + segundo); // 8
    }
}
