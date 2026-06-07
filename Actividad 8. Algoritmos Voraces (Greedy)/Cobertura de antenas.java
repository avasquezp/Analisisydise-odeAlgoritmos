import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoberturaAntenas {

    public static void resolver(int[] casas, int R) {

        // ordena por casas a menor a mayor
        Arrays.sort(casas);

        List<Integer> antenas = new ArrayList<>();
        int i = 0;

        while (i < casas.length) {

            // tomar la primera casa sin cubrir
            int primeraSinCubrir = casas[i];

            // coloca la antena R posiciones a la derecha de la casa
            int posicion = primeraSinCubrir + R;
            antenas.add(posicion);

            // salta todas las casas que cubre la antena
            while (i < casas.length && casas[i] <= posicion + R) {
                i++;
            }
        }

        System.out.println("antenas colocadas aproximadamente en:");
        for (int pos : antenas) {
            System.out.println(pos);
        }
        System.out.println("cantidad total: " + antenas.size());
    }

    public static void main(String[] args) {

        System.out.println("--- ejemplo 1 ---");
        int[] casas1 = {1, 2, 7, 11, 20, 21, 30};
        resolver(casas1, 5);

        System.out.println();

        System.out.println("--- ejemplo 2 ---");
        int[] casas2 = {2, 4, 8, 15, 18, 22};
        resolver(casas2, 3);
    }
}
