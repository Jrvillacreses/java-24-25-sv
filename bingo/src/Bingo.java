import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bingo {
    static Object[][] carton = new Object[10][3]; // Matriz para el cartón de Bingo
    static Scanner leer = new Scanner(System.in);

    // Método para inicializar el cartón vacío (con "X")
    public static void inicializarCarton() {
        for (int col = 0; col < 10; col++) {
            for (int fila = 0; fila < 3; fila++) {
                carton[col][fila] = "X"; // Inicializamos todas las posiciones con "X"
            }
        }
    }

    // Método para que el usuario elija 15 números y los coloque en el cartón
    public static void rellenarCarton() {
        ArrayList<Integer>[] columnas = new ArrayList[10]; // Lista de números para cada columna (basado en decenas)

        // Inicializamos las listas para cada columna
        for (int col = 0; col < 10; col++) {
            columnas[col] = new ArrayList<>();
        }

        int numerosColocados = 0;

        while (numerosColocados < 15) {
            System.out.println("Introduce un número para tu cartón (entre 1 y 99):");
            int numero = leer.nextInt();

            // Validar que el número esté en el rango permitido
            if (numero < 1 || numero > 99) {
                System.out.println("Número fuera de rango. Por favor, elige un número entre 1 y 99.");
                continue;
            }

            // Calcular la columna correspondiente a la decena
            int col = numero / 10; // Columna basada en la decena (0 para 1-9, 1 para 10-19, etc.)

            // Verificamos que no se repitan números en la misma columna
            if (columnas[col].contains(numero)) {
                System.out.println("Este número ya está en tu cartón. Introduce otro número.");
                continue;
            }

            // Añadir el número a la columna correspondiente
            columnas[col].add(numero);
            numerosColocados++;

        }

        // Ordenamos los números en cada columna
        for (int col = 0; col < 10; col++) {
            Collections.sort(columnas[col]);
        }

        // Colocamos los números ordenados en el cartón
        for (int col = 0; col < 10; col++) {
            for (int fila = 0; fila < columnas[col].size(); fila++) {
                carton[col][fila] = columnas[col].get(fila); // Colocamos el número ordenado en la matriz
            }
        }
    }

    // Método para imprimir el cartón de Bingo
    public static void imprimirCarton() {
        System.out.println("Tu cartón de Bingo:");
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 10; col++) {
                if (carton[col][fila] instanceof Integer) {
                    System.out.printf("%2d ", carton[col][fila]); // Imprime el número con formato
                } else {
                    System.out.print(" X "); // Imprime "X" en los espacios vacíos
                }
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }

    // Método para generar una combinación ganadora de 15 números aleatorios entre 1 y 99
    public static int[] generarCombinacionGanadora() {
        int[] ganadores = new int[15];
        boolean[] yaGenerado = new boolean[100]; // Array para marcar los números ya generados
        int contador = 0;

        while (contador < 15) {
            int numeroGanador = (int) (Math.random() * 99) + 1; // Números aleatorios entre 1 y 99

            if (!yaGenerado[numeroGanador]) { // Si el número no ha sido generado antes
                ganadores[contador] = numeroGanador;
                yaGenerado[numeroGanador] = true; // Marcamos como generado
                contador++;
            }
        }

        return ganadores;
    }

    // Método para comprobar cuántos aciertos tiene el usuario
    public static int comprobarAciertos(int[] ganadores) {
        int aciertos = 0;

        for (int col = 0; col < 10; col++) {
            for (int fila = 0; fila < 3; fila++) {
                if (carton[col][fila] instanceof Integer) {
                    int numeroCarton = (int) carton[col][fila];
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

    public static void main(String[] args) {
        // Inicializamos el cartón vacío
        inicializarCarton();

        // El usuario rellena su cartón con 15 números
        rellenarCarton();

        // Mostramos el cartón al usuario
        imprimirCarton();

        // Generamos la combinación ganadora
        int[] ganadores = generarCombinacionGanadora();

        // Mostramos los números ganadores
        System.out.println("Números ganadores:");
        for (int i = 0; i < ganadores.length; i++) {
            System.out.print(ganadores[i] + " ");
        }
        System.out.println();

        // Comprobamos cuántos aciertos tiene el usuario
        int aciertos = comprobarAciertos(ganadores);
        System.out.println("¡Has acertado " + aciertos + " números!");
    }
}
