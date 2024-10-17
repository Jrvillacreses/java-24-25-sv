import java.util.Random;
import java.util.Scanner;

public class Main {
    static public final int MAXFILAS = 10;
    static public final int MAXCOLUMNAS = 10;
    static public String[][] tablero = new String[MAXFILAS][MAXCOLUMNAS];
    static Random aleatorio = new Random();
    static int filaBart = aleatorio.nextInt(MAXFILAS);
    static int columnaBart = aleatorio.nextInt(MAXCOLUMNAS);
    static int vidas = 10;
    static public void crearTablero() {
        for (int i = 0; i < MAXFILAS; i++) {
            for (int j = 0; j < MAXCOLUMNAS; j++) {
                tablero[i][j] = "[ ]";
            }
        }
    }
    static public void imprimirTablero() {
        for (int i = 0; i < MAXFILAS; i++) {
            for (int j = 0; j < MAXCOLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    static public void colocarBart() {
        tablero[filaBart][columnaBart] = "[B]";
    }
    static public void colocarHomer() {
        int filaHomer;
        int columnaHomer;
        for (int i = 0; i < 10; i++) {
            do {
                filaHomer = aleatorio.nextInt(MAXFILAS);
                columnaHomer = aleatorio.nextInt(MAXCOLUMNAS);
            } while (tablero[filaHomer][columnaHomer] != "[ ]");
            tablero[filaHomer][columnaHomer] = "[H]";
        }
    }
    static public void colocarMuro() {
        int filaMuro;
        int columnaMuro;
        for (int i = 0; i < 5; i++) {
            do {
                filaMuro = aleatorio.nextInt(MAXFILAS);
                columnaMuro = aleatorio.nextInt(MAXCOLUMNAS);
            } while (tablero[filaMuro][columnaMuro] != "[ ]");
            tablero[filaMuro][columnaMuro] = "[M]";
        }
    }
    static public void colocarSalida() {
        tablero[MAXFILAS - 1][MAXCOLUMNAS - 1] = "[F]";
    }



    public static void main(String[] args) {
        crearTablero();
        colocarSalida();
        colocarBart();
        colocarHomer();
        colocarMuro();
        do {
            imprimirTablero();
            System.out.println("Dime el desplazamiento que quieres realizar");
            System.out.println("A--> Izquierda, S--> Abajo, D--> Derecha, W--> Arriba");
            Scanner lector = new Scanner(System.in);
            String desplazamiento = lector.nextLine().toUpperCase(); // conversión a mayúsculas
            System.out.println("Desplazamiento=" + desplazamiento);
            //Desplazamiento general , no interacciones
            switch(desplazamiento) {
                case "A": // Izquierda
                    if ((columnaBart - 1) >= 0) {
                        moverBart(filaBart, columnaBart - 1);
                    } else {
                        System.out.println("¡No puedes salirte del tablero!");
                    }
                    break;
                case "S": // Abajo
                    if ((filaBart + 1) < MAXFILAS) {
                        moverBart(filaBart + 1, columnaBart);
                    } else {
                        System.out.println("¡No puedes salirte del tablero!");
                    }
                    break;
                case "D": // Derecha
                    if ((columnaBart + 1) < MAXCOLUMNAS) {
                        moverBart(filaBart, columnaBart + 1);
                    } else {
                        System.out.println("¡No puedes salirte del tablero!");
                    }
                    break;
                case "W": // Arriba
                    if ((filaBart - 1) >= 0) {
                        moverBart(filaBart - 1, columnaBart);
                    } else {
                        System.out.println("¡No puedes salirte del tablero!");
                    }
                    break;
                default:
                    System.out.println("Tecla inválida. Usa WASD para moverte.");
                    break;
            }
        } while (vidas > 0);
    }
    // Interacciones de movimiento con variable propia
    private static void moverBart(int nuevaFila, int nuevaColumna) {
        switch (tablero[nuevaFila][nuevaColumna]) {
            case "[H]":
                int vidas = 10;
                vidas--;
                System.out.println("Te ha pillado Homer. Te quedan " + vidas + " vidas.");
                break;
            case "[ ]":
                // Movimiento válido
                break;
            case "[M]":
                System.out.println("¡No puedes atravesar muros!");
                return; // No mover si es un muro
            case "[F]":
                System.out.println("¡Has llegado a la meta! Fin del juego.");
                System.exit(0);
        }
        //Declaracion para cambios de casilla al movernos
        tablero[filaBart][columnaBart] = "[ ]"; // Casilla anterior de Bart
        tablero[nuevaFila][nuevaColumna] = "[B]"; // Nueva posición de Bart
        filaBart = nuevaFila;
        columnaBart = nuevaColumna;
    }

    }

/* Ejercicio Simpson Jairo Villacreses
1-Declarar Funciones
2-Realizar Funciones
3-crear tablero
4-imprimir tablero
5-Crear/colocar a bart
6- Crear/colocar homer
7- crear/colocar Muros
8- Crear Límites
9- Condición de juego (if vidas >0)
10- Función de movimiento
 */