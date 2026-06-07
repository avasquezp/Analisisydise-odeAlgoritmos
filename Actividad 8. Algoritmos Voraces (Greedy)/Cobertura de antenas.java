public class CoberturaAntenas {

    public static void main(String[] args) {

        // puse datos de entrada que ya serian fijos
        int[] casas = {1,2,7,11,20,21,30};
        int R = 5;

        // aca hice un ordenamiento de las casas de menor a mayor segun la posicion
        for (int i = 0; i < casas.length - 1; i++) {
            for (int j = i + 1; j < casas.length; j++) {
                if (casas[j] < casas[i]) {
                    int tmp  = casas[i];
                    casas[i] = casas[j];
                    casas[j] = tmp;
                }
            }
        }

        // aqui va a tomar la primera casa sin cubrir y colocar la antena, las R posiciones a su derecha para llegar al maximo de cbertura── Selección Greedy 
        int[] antenas   = new int[casas.length];
        int cantAntenas = 0;
        int i = 0;

        while (i < casas.length) {

            // primera casa sin cubrir
            int primeraSinCubrir = casas[i];

            // coloca la antena R posiciones a la derecha
            int posAntena = primeraSinCubrir + R;
            antenas[cantAntenas] = posAntena;
            cantAntenas++;

            // salta todas las casas que cubre esta antena
            while (i < casas.length && casas[i] <= posAntena + R) {
                i++;
            }
        }

        System.out.println("antenas colocadas aproximadamente en:");
        for (int j = 0; j < cantAntenas; j++) {
            System.out.println(antenas[j]);
        }
        System.out.println("cantidad total: " + cantAntenas);
    }
}
