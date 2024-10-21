import java.util.Scanner;

public class Bingo {
    static int[][] carton = new int[9][3]; // Matriz para el cartón de Bingo

    // Método para inicializar el cartón vacío (con 0, que será tratado como "X")
    public static void inicializarCarton() {
        for (int col = 0; col < 9; col++) {
            for (int fila = 0; fila < 3; fila++) {
                carton[col][fila] = 0; // Inicializamos todas las posiciones con 0
            }
        }
    }

    // Método para rellenar el cartón automáticamente con 15 números aleatorios
    public static void rellenarCarton() {
        int numerosColocados = 0;
        int[] yaGenerados = new int[100]; // Array para verificar si el número ya ha sido usado

        while (numerosColocados < 15) {
            int numero = (int) (Math.random() * 99) + 1; // Generamos un número aleatorio entre 1 y 99

            if (yaGenerados[numero] == 0) { // Si no ha sido generado aún
                yaGenerados[numero] = 1; // Marcamos como generado
                int col = numero / 10; // Calculamos la columna según la decena
                colocarNumeroEnColumna(numero, col);
                numerosColocados++;
            }
        }
    }

    // Método para colocar el número en la columna correspondiente
    public static void colocarNumeroEnColumna(int numero, int col) {
        for (int fila = 0; fila < 3; fila++) {
            if (carton[col][fila] == 0) { // Buscamos la primera fila libre (marcada como 0)
                carton[col][fila] = numero; // Colocamos el número
                ordenarColumna(col); // Ordenamos la columna después de colocar el número
                break;
            }
        }
    }

    // Método para ordenar los números en una columna de menor a mayor
    public static void ordenarColumna(int col) {
        int temp;
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (carton[col][i] > carton[col][j] && carton[col][j] != 0) {
                    temp = carton[col][i];
                    carton[col][i] = carton[col][j];
                    carton[col][j] = temp;
                }
            }
        }
    }

    // Método para imprimir el cartón de Bingo
    public static void imprimirCarton() {
        System.out.println("Tu cartón de Bingo:");
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 9; col++) {
                if (carton[col][fila] == 0) {
                    System.out.print(" X "); // Imprime "X" en los espacios vacíos
                } else {
                    System.out.printf("%2d ", carton[col][fila]); // Imprime el número
                }
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }

    // Método para generar una combinación ganadora de 15 números aleatorios entre 1 y 99
    public static void generarCombinacionGanadora(int[] ganadores) {
        int[] yaGenerados = new int[100]; // Array para verificar si el número ya ha sido usado
        int contador = 0;

        while (contador < 15) {
            int numeroGanador = (int) (Math.random() * 99) + 1;

            if (yaGenerados[numeroGanador] == 0) { // Si no ha sido generado aún
                yaGenerados[numeroGanador] = 1; // Marcamos como generado
                ganadores[contador] = numeroGanador;
                contador++;
            }
        }
    }

    // Método para comprobar cuántos aciertos tiene el usuario
    public static int comprobarAciertos(int[] ganadores) {
        int aciertos = 0;

        for (int col = 0; col < 9; col++) {
            for (int fila = 0; fila < 3; fila++) {
                int numeroCarton = carton[col][fila];
                if (numeroCarton != 0) {
                    for (int i = 0; i < ganadores.length; i++) {
                        if (ganadores[i] == numeroCarton) {
                            aciertos++; // Incrementamos el contador si hay acierto
                            break;
                        }
                    }
                }
            }
        }

        return aciertos;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner leer = new Scanner(System.in);

        // Inicializamos el cartón vacío
        inicializarCarton();

        // Rellenamos el cartón automáticamente con 15 números aleatorios
        rellenarCarton();

        // Mostramos el cartón al usuario
        imprimirCarton();

        // Espera de 5 segundos antes de mostrar la combinación ganadora
        System.out.println("\nEsperando 5 segundos para la combinación ganadora...");
        Thread.sleep(5000);

        // Generamos la combinación ganadora
        int[] ganadores = new int[15];
        generarCombinacionGanadora(ganadores);

        // Mostramos los números ganadores
        System.out.println("\nNúmeros ganadores:");
        for (int i = 0; i < ganadores.length; i++) {
            System.out.print(ganadores[i] + " ");
        }
        System.out.println();

        // Comprobamos cuántos aciertos tiene el usuario
        int aciertos = comprobarAciertos(ganadores);
        System.out.println("\n¡Has acertado " + aciertos + " números!");
    }
}
