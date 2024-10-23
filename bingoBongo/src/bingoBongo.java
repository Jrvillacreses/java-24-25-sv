import java.util.Random;
import java.util.Scanner;

public class bingoBongo {

    // Función para crear el cartón lleno de -1
    public static int[][] crearCarton() {
        int[][] carton = new int[3][9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                carton[i][j] = -1; // Inicializa el cartón con -1
            }
        }
        return carton;
    }

    // Función para rellenar el cartón
    public static void rellenarCarton(int[][] carton, Random random) {
        int numerosColocados = 0;
        boolean[] numerosUsados = new boolean[91]; // Array para rastrear números usados (1 a 100)

        while (numerosColocados < 15) {
            int numeroAleatorio = random.nextInt(90) + 1; // Números del 1 al 100

            // Determinar la columna
            int columna = numeroAleatorio / 10;
            if (columna > 8) {
                columna = 8; // Números 80-89 van a la última columna
            }

            // Verificar si el número ya fue utilizado
            if (!numerosUsados[numeroAleatorio]) {
                // Colocar el número en la fila correcta
                boolean colocado = false;
                for (int fila = 0; fila < 3; fila++) {
                    if (carton[fila][columna] == -1) {
                        carton[fila][columna] = numeroAleatorio;
                        numerosUsados[numeroAleatorio] = true; // Marcar el número como usado
                        numerosColocados++;
                        colocado = true;
                        break;
                    }
                }

                // Si no pudo colocarse, intenta con otro número aleatorio
                if (!colocado) {
                    continue;
                }
            }
        }
    }

    // Función para ordenar el cartón por método burbuja (por columnas)
    public static void ordenarCarton(int[][] carton) {
        for (int col = 0; col < 9; col++) {
            for (int i = 0; i < 3 - 1; i++) {
                for (int j = 0; j < 3 - i - 1; j++) {
                    if (carton[j][col] > carton[j + 1][col] && carton[j + 1][col] != -1) {
                        int temp = carton[j][col];
                        carton[j][col] = carton[j + 1][col];
                        carton[j + 1][col] = temp;
                    }
                }
            }
        }
    }

    // Función para imprimir el cartón
    public static void imprimirCarton(int[][] carton) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] == -1) {
                    System.out.print("XX\t"); // Imprime "XX" para indicar espacio vacío
                } else {
                    System.out.print(carton[i][j] + "\t");
                }
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }

    // Función para generar una combinación ganadora aleatoria
    public static int[] generarCombinacionGanadora(Random random) {
        int[] combinacionGanadora = new int[15];
        for (int i = 0; i < 15; i++) {
            combinacionGanadora[i] = random.nextInt(90) + 1;
        }
        return combinacionGanadora;
    }

    // Función para imprimir la combinación ganadora
    public static void imprimirCombinacionGanadora(int[] combinacionGanadora) {
        for (int numero : combinacionGanadora) {
            System.out.print(numero + " ");
        }
        System.out.println(); // Nueva línea después de imprimir la combinación
    }

    // Función para imprimir el cartón de aciertos
    public static void imprimirCartonAciertos(int[][] carton, int[] numerosAciertos) {
        // Creamos un nuevo cartón para representar los aciertos
        int[][] cartonAciertos = new int[3][9];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                // Inicializamos el cartón de aciertos con "XX"
                cartonAciertos[i][j] = -1; // -1 indica espacio vacío
                // Verificamos si el número del cartón original es un acierto
                for (int numero : numerosAciertos) {
                    if (carton[i][j] == numero) {
                        cartonAciertos[i][j] = numero; // Colocamos el número acertado
                        break;
                    }
                }
            }
        }

        // Imprimimos el cartón de aciertos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (cartonAciertos[i][j] == -1) {
                    System.out.print("XX\t"); // Imprime "XX" para indicar que no hay aciertos
                } else {
                    System.out.print(cartonAciertos[i][j] + "\t"); // Imprime el número acertado
                }
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Crear y llenar el cartón
        int[][] carton = crearCarton();
        rellenarCarton(carton, random);
        ordenarCarton(carton);

        // Imprimir el cartón
        System.out.println("Cartón de Bingo:");
        imprimirCarton(carton);

        // Generar combinación ganadora
        System.out.println("Generando combinación ganadora en 5 segundos...");
        Thread.sleep(5000);

        int[] combinacionGanadora = generarCombinacionGanadora(random);

        // Imprimir combinación ganadora
        System.out.println("Combinación ganadora:");
        imprimirCombinacionGanadora(combinacionGanadora);

        // Contar aciertos
        int aciertos = 0;
        int[] numerosAciertos = new int[15]; // Suponiendo que habrá un máximo de 15 aciertos

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < combinacionGanadora.length; k++) {
                    if (carton[i][j] == combinacionGanadora[k]) {
                        numerosAciertos[aciertos] = carton[i][j];
                        aciertos++;
                    }
                }
            }
        }

        // Crear un nuevo array con los números acertados sin ceros adicionales
        int[] numerosAciertosFinales = new int[aciertos];
        for (int i = 0; i < aciertos; i++) {
            numerosAciertosFinales[i] = numerosAciertos[i];
        }

        // Imprimir resultados
        System.out.println("Cantidad de aciertos: " + aciertos);
        System.out.println("Cartón de Aciertos:");
        imprimirCartonAciertos(carton, numerosAciertosFinales);

    }
}

