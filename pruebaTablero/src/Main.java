import java.util.Random;
import java.util.Scanner;

public class Main {
    static String tableroNum[][] = new String[10][10];
    static String tableroX[][] = new String[10][10];
    static final int MAX_FILAS= 10;
    static final int MAX_COLUMNAS= 10;
    static final int NUM_USUARIO = 10;
    static Random aleatorio = new Random();
    static Scanner lector = new Scanner(System.in);
    static String numeroUsuario;
    static int numUser;
    static int aciertos = 0;
    //Rellenamos tablero X
    public static void rellenarTableroX(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroX[i][j] = "XX";
            }
        }
    }
    //Rellenamos tablero de Numeros
    public static void rellenarTableroNum(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroNum[i][j] = String.valueOf(aleatorio.nextInt(10,99));
            }
        }
    }
    //Preguntamos al Usuario
    public static void preguntar(){
        boolean numeroRepetido;
        numeroRepetido = false;
            System.out.println("Introduce un número del 10 al 99 para ver si se encuentra en el tablero.");
            numUser = Integer.parseInt(lector.nextLine());
            numeroUsuario = String.valueOf(numUser);
                if (numUser < 10 || numUser > 99) {
                    System.out.println("El número no es válido. Introduce un número del 10 al 99.");
                    numUser = Integer.parseInt(lector.nextLine());
                    numeroUsuario = String.valueOf(numUser);
                }
    }
    //Comprobamos que el número esté en el tablero
    public static void comprobarNum(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if (tableroNum[i][j].equals(numeroUsuario)) {
                    tableroX[i][j] = String.valueOf(numeroUsuario);
                    aciertos++;
                }
            }
        }
    }
    //Imprimimos el tablero de X
    public static void imprimirTableroX(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print("[" + tableroX[i][j] + "] ");
            }System.out.println();
        }
    }
    //Imprimimos el tablero de Numeros
    public static void imprimirTableroNum(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print("[" + tableroNum[i][j] + "] ");
            }System.out.println();
        }
    }
    //Calculamos las coincidencias en las tablas (aciertos)
    public static void numAciertos() {
        if (aciertos > 0) {
            System.out.println("Has tenido:" + aciertos + " puntos ¡Enhorabuena!");
        } else {
            System.out.println("No has acertado ni  una.¡Eres Malísimo!");
        }
    }

    public static void main(String[] args) {
        rellenarTableroX();
        rellenarTableroNum();
        imprimirTableroNum();
        imprimirTableroX();
        System.out.println("Bienvenido al Busca Números");
        System.out.println("Este juego consiste en encontrar cifras en un tablero de 10x10, si aciertas ganaras 1 punto.");
        for (int i = 0; i < NUM_USUARIO; i++) {
            preguntar();
            comprobarNum();
        }
        imprimirTableroX();
        numAciertos();
    }
}