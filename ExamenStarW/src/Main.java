import java.util.Random;
import java.util.Scanner;

public class Main {
    // Variables tablero
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static final int VIDASJ1 = 5;
    static final int VIDASJ2 = 5;
    static String[][] tableroYoda = new String[MAX_FILAS][MAX_COLUMNAS];
    static String[][] tableroYoda2 = new String[MAX_FILAS][MAX_COLUMNAS];
    static String[][] tableroVader = new String[MAX_FILAS][MAX_COLUMNAS];
    static String[][] tableroVader2 = new String[MAX_FILAS][MAX_COLUMNAS];

    // Random y escaner
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    // Variables posicion personajes
    static int filaYoda;
    static int columnaYoda;
    static int filaVader;
    static int columnaVader;

    // Variables Personajes
    static String libre = "[ ]";
    static String yoda = "[Y]";
    static String vader = "[V]";
    static String darthMaul = "[D]";
    static String r2d2 = "[R]";
    static String muro = "[M]";

    // Variables String de enemigos
    static String enemigosYoda = {darthMaul,muro};
    static String enemigosVader = {r2d2, muro};

    static void rellenarTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = libre;
            }
        }
    }

    static void imprimirTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void asignarPersonajeCasilla(String tablero[][], String caracter, int numRepeticiones) {
        int filaAleatorio = -1;
        int columnaAleatorio = -1;
        for (int i = 0; i < numRepeticiones; i++) {
            do {
                filaAleatorio = rand.nextInt(MAX_FILAS);
                columnaAleatorio = rand.nextInt(MAX_COLUMNAS);
            } while (!tablero[columnaAleatorio][filaAleatorio].equals("[ ]"));
            tablero[columnaAleatorio][filaAleatorio] = caracter;
        }
    }
    static void vaciarEnemigos(String[][] tablero, String caracter, int numRepeticiones) {
    }
    static void saltoPersonajes(String[][] tablero, String caracter) {
        int filaAleatorio = -1;
        int columnaAleatorio = -1;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                do {
                    filaAleatorio = rand.nextInt(MAX_FILAS);
                    columnaAleatorio = rand.nextInt(MAX_COLUMNAS);
                }while(!tablero[columnaAleatorio][filaAleatorio].equals("[ ]"));
                tablero[filaAleatorio][columnaAleatorio] = caracter;
            }
        }
    }
    static void comprobarCasillaAnterior(){

}
    public static void main(String[] args) {
        rellenarTablero(tableroYoda);
        rellenarTablero(tableroVader);
        asignarPersonajeCasilla(tableroYoda, yoda, 1);
        asignarPersonajeCasilla(tableroYoda, darthMaul, 5);
        asignarPersonajeCasilla(tableroYoda, muro, 5);
        asignarPersonajeCasilla(tableroVader, vader, 1);
        asignarPersonajeCasilla(tableroVader, r2d2, 5);
        asignarPersonajeCasilla(tableroVader, muro, 5);
        System.out.println("Tablero J1, tienes " + VIDASJ1 + " vidas.");
        imprimirTablero(tableroYoda);
        System.out.println();
        System.out.println("Tablero J2, tienes " + VIDASJ2 + " vidas.");
        imprimirTablero(tableroVader);
        while (VIDASJ1 != 0 || VIDASJ2 !0){

    }
}