import java.util.Random;
import java.util.Scanner;

public class JuegoSimpsonFinal {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static String[][] tablero;
    private static int filaBart;
    private static int columnaBart;

    private static void imprimirTablero(){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + "");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void asignarLibreACasilla(String caracter){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = caracter;
            }
        }
    }

    private static void asignarPersonajesACasillaLibre(String caracter, int numRepeteciones){
        //Poner a Bart en el tablero
        Random aleatorio = new Random();
        int filaAleatorio = -1;
        int columnaAleatorio = -1;
        for(int i = 0; i < numRepeteciones; i++){
            do {
                filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            } while (!tablero[filaAleatorio][columnaAleatorio].equals("[ ]"));
            tablero[filaAleatorio][columnaAleatorio] = caracter;
        }
        if (caracter.equals("[B]")) {
            filaBart = filaAleatorio;
            columnaBart = columnaAleatorio;
        }
    }

    public static void main(String[] args) {
        // Creacion de la matriz tablero
        tablero = new String[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        asignarLibreACasilla("[ ]");
        //imprimirTablero();
        asignarPersonajesACasillaLibre("[B]", 1);
        //imprimirTablero();
        asignarPersonajesACasillaLibre("[H]", 10);
        //imprimirTablero();
        asignarPersonajesACasillaLibre("[M]", 10);
        //imprimirTablero();
        tablero[MAX_FILA_TABLERO - 1][MAX_COLUMNA_TABLERO - 1] = "[F]";
        imprimirTablero();

        /* Desplazamiento de Bart */
        Scanner lector = new Scanner(System.in);
        int vidas = 10;

        do {
            System.out.println("Dime el desplazamiento que quieres realizar");
            System.out.println("A--> Izquierda, S--> Abajo, D--> Derecha, W--> Arriba");
            String desplazamiento = lector.nextLine().toUpperCase(); // conversión a mayúsculas
            System.out.println("Desplazamiento=" + desplazamiento);

            switch(desplazamiento) {
                case "A": // Izquierda
                    if ((columnaBart - 1) >= 0) {
                        moverBart(filaBart, columnaBart - 1);
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "S": // Abajo
                    if ((filaBart + 1) < MAX_FILA_TABLERO) {
                        moverBart(filaBart + 1, columnaBart);
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "D": // Derecha
                    if ((columnaBart + 1) < MAX_COLUMNA_TABLERO) {
                        moverBart(filaBart, columnaBart + 1);
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "W": // Arriba
                    if ((filaBart - 1) >= 0) {
                        moverBart(filaBart - 1, columnaBart);
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                default:
                    System.out.println("Tecla inválida. Usa WASD para moverte.");
                    break;
            }
            imprimirTablero();
        } while (vidas > 0);
    }

    private static void moverBart(int nuevaFila, int nuevaColumna) {
        switch (tablero[nuevaFila][nuevaColumna]) {
            case "[H]":
                int vidas = 10;
                vidas--;
                System.out.println("Has perdido una vida. Te quedan=" + vidas + " vidas.");
                break;
            case "[ ]":
                // Movimiento válido
                break;
            case "[M]":
                System.out.println("El muro no te deja desplazarte a esta casilla.");
                return; // No mover si es un muro
            case "[F]":
                System.out.println("¡Has llegado a la meta! Fin del juego.");
                System.exit(0);
        }
        tablero[filaBart][columnaBart] = "[ ]"; // Casilla anterior de Bart
        tablero[nuevaFila][nuevaColumna] = "[B]"; // Nueva posición de Bart
        filaBart = nuevaFila;
        columnaBart = nuevaColumna;
    }
}
