import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[][] tableroYoda;
    public static String[][] tableroVader;
    public static final int MAX_FILA_TABLERO = 10;
    public static final int MAX_COLUMNA_TABLERO = 10;
    public static final String YODA = "[Y]";
    public static final String VADER = "[V]";
    public static int filaYoda;
    public static int columnaYoda;
    public static int filaVader;
    public static int columnaVader;

    public static void asignarLibreCasilla(String caracter){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tableroYoda[i][j] = caracter;
                tableroVader[i][j] = caracter;
            }
        }
    }
    public static void asignarPersonajeCasilla(String tablero[][], String caracter, int numRepeticiones){
        Random aleatorio = new Random();
        int filaAleatorio = -1;
        int columnaAleatorio = -1;
        for(int i = 0; i < numRepeticiones; i++){
            do{
                filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            }while (!tablero[columnaAleatorio][filaAleatorio].equals("[ ]"));
            tablero[columnaAleatorio][filaAleatorio] = caracter;
        }
    }

    public static void imprimirTablero(String tablero[][]){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void movimiento(Scanner scanner, String tablero[][], String )

    public static void main(String[] args) {
        tableroYoda = new String[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        tableroVader = new String[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        asignarLibreCasilla("[ ]");
        asignarPersonajeCasilla(tableroYoda,"[Y]", 1);
        asignarPersonajeCasilla(tableroYoda,"[D]", 5);
        asignarPersonajeCasilla(tableroYoda,"[M]", 5);
        tableroYoda[MAX_FILA_TABLERO - 1][MAX_COLUMNA_TABLERO - 1] = "[F]";
        imprimirTablero(tableroYoda);
        asignarPersonajeCasilla(tableroVader,"[V]", 1);
        asignarPersonajeCasilla(tableroVader,"[R]", 5);
        asignarPersonajeCasilla(tableroVader,"[M]", 5);
        tableroVader[MAX_FILA_TABLERO - 1][MAX_COLUMNA_TABLERO - 1] = "[F]";
        imprimirTablero(tableroVader);

    }
}