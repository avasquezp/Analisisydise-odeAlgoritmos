import java.util.Arrays;

public class MochilaFraccional {

    static class Objeto {
        String nombre;
        double valor;
        double peso;

        public Objeto(String nombre, double valor, double peso) {
            this.nombre = nombre;
            this.valor = valor;
            this.peso = peso;
        }

        public double razon() {
            return valor / peso;
        }
    }

    public static void resolver(Objeto[] objetos, double capacidad) {

        // va a ordenar por razon valor/peso de mayor a menor
        Arrays.sort(objetos, (a, b) -> Double.compare(b.razon(), a.razon()));

        double valorTotal = 0;
        double restante = capacidad;

        System.out.println("Objetos seleccionados:");

        for (Objeto obj : objetos) {
            if (restante == 0) break;

            if (obj.peso <= restante) {
  
                restante -= obj.peso;
                valorTotal += obj.valor;
                System.out.println(obj.nombre + " completo");

            } else {
                // solo va a caber una fracción
                double fraccion = restante / obj.peso;
                valorTotal += fraccion * obj.valor;
                System.out.println((int) restante + "/" + (int) obj.peso
                    + " Parte del objeto " + obj.nombre);
                restante = 0;
            }
        }

        System.out.println("Valor total aproximado: " + (int) valorTotal);
    }

    public static void main(String[] args) {

        System.out.println("--- Ejemplo 1 ---");
        Objeto[] ejemplo1 = {
            new Objeto("A", 60, 10),
            new Objeto("B", 100, 20),
            new Objeto("C", 120, 30)
        };
        resolver(ejemplo1, 50);

        System.out.println();

        System.out.println("--- Ejemplo 2 ---");
        Objeto[] ejemplo2 = {
            new Objeto("A", 80, 20),
            new Objeto("B", 100, 10),
            new Objeto("C", 120, 30)
        };
        resolver(ejemplo2, 25);
    }
