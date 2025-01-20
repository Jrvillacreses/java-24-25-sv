import java.util.Random;
import java.util.Scanner;

public class Main {
    //Declaramos las constantes del tablero
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static String[][] tableroYoda = new String[MAX_FILAS][MAX_COLUMNAS];
    static String[][] tableroVader = new String[MAX_FILAS][MAX_COLUMNAS];
    static String[][] tableroYoda2 = new String[MAX_FILAS][MAX_COLUMNAS];
    static String[][] tableroVader2 = new String[MAX_FILAS][MAX_COLUMNAS];

    //Declaramos herramientas
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    //Declaramos caracteres
    static final String LIBRE = "[ ]";
    static final String YODA = "[Y]";
    static final String VADER = "[V]";
    static final String DARTH_MAUL = "[D]";
    static final String R2D2 = "[R]";
    static final String FINAL = "[F]";
    static final String MURO = "[M]";
    static final String POCION = "[P]";

    //Declaramos posiciones
    static public int filaYoda;
    static public int columnaYoda;
    static public int filaVader;
    static public int columnaVader;

    public static void inicializarTablero(String[][] tablero){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tablero[i][j] = LIBRE;
            }
        }
        tablero[9][9] = FINAL;
    }
    public static void rellenarTablero(String[][] tablero, String caracter, int numVeces){
        for (int i = 0; i < numVeces; i++) {
            int filaAl = 0;
            int columnaAl = 0;
            do{
                filaAl = rand.nextInt(MAX_FILAS);
                columnaAl = rand.nextInt(MAX_COLUMNAS);
            }while(!tablero[filaAl][columnaAl].equals(LIBRE));
            tablero[filaAl][columnaAl] = caracter;
        }
    }
    public static void imprimirTablero(String[][] tablero){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void movimientos(int saltos, String caracter, String[][] tablero, int fila, int columna){
        if(caracter.equals(YODA)){
            fila = filaYoda;
            columna = columnaYoda;
        }
    }

    public static void main(String[] args) {
        inicializarTablero(tableroYoda);
        inicializarTablero(tableroVader);

        rellenarTablero(tableroYoda, YODA, 1);
        rellenarTablero(tableroYoda, DARTH_MAUL, 5);
        rellenarTablero(tableroYoda, MURO, 5);
        rellenarTablero(tableroYoda, POCION, 2);

        rellenarTablero(tableroVader, VADER, 1);
        rellenarTablero(tableroVader, R2D2, 5);
        rellenarTablero(tableroVader, MURO, 5);
        rellenarTablero(tableroVader, POCION, 2);

        imprimirTablero(tableroYoda);
        System.out.println();
        imprimirTablero(tableroVader);

        do{
            System.out.println("Introduce el número de saltos de tu personaje");
            int saltos1 = sc.nextInt();
            sc.nextLine();
        }while()
    }
}