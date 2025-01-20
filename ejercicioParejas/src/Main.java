import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int MAX_FILAS = 4;
    static final int MAX_COLUMNAS = 4;
    static String [][] tablero = new String [MAX_FILAS][MAX_COLUMNAS];
    static String [][] tableroX = new String [MAX_FILAS][MAX_COLUMNAS];
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    static int filaAl;
    static int columnAl;
    static final int VIDAS = 10;

    public static void inicializarTablero(String[][] tablero){
        for (int i = 0; i < MAX_FILAS; i++){
            for (int j = 0; j < MAX_COLUMNAS; j++){
                tablero[i][j] = "[X]";
            }
        }
    }

    public static void rellenarTablero(){
        for (int k = 1; k < 9; k++) {
            for (int i = 0; i < 2; i++) {
                do{
                    filaAl = rand.nextInt(4);
                    columnAl = rand.nextInt(4);
                }while(!tablero[filaAl][columnAl].equals("[X]"));
                tablero[filaAl][columnAl] = String.valueOf(k);
            }
        }
    }
    public static void imprimirTablero(String[][] tablero){
        for (int i = 0; i < MAX_FILAS; i++){
            for (int j = 0; j < MAX_COLUMNAS; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        inicializarTablero(tablero);
        inicializarTablero(tableroX);
        rellenarTablero();
        imprimirTablero(tablero);
        System.out.println();
        imprimirTablero(tableroX);
        while (VIDAS < 10){
            System.out.println("Introduce la posición de la fila del primer nº de la pareja");
            int fila = sc.nextInt();
            System.out.println("Introduce la posición de la columna del primer nº de la pareja");
            int columna = sc.nextInt();
            System.out.println("Introduce la posición de la fila del primer nº de la pareja");
            int fila2 = sc.nextInt();
            System.out.println("Introduce la posición de la columna del primer nº de la pareja");
            int columna2 = sc.nextInt();
            if(tablero[fila][columna].equals(tablero[fila2][columna2])){
                tableroX[fila][columna] = tablero[fila][columna2];
                tableroX[fila2][columna2] = tablero[fila2][columna2];
            }
        }
    }
}