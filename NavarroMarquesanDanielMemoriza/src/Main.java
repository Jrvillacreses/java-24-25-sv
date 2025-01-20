import java.util.Random;
import java.util.Scanner;
//NAVARRO MARQUESAN DANIEL
public class Main {
    static String[][] tableroJuego = new String[4][4];
    static int[][] tableroNums = new int[4][4];
    static Random aleatorio = new Random();
    static Scanner lector = new Scanner(System.in);
    static String oculto = "*";
    static int contador = 0;
    static int fila;
    static int columna;
    static int fila2;
    static int columna2;
    static int numero = 1;
    static int intentos = 10;
    static int parejas = 0;
    static void rellenartableroJuego(){ //variable que rellena el tablero con *
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tableroJuego[i][j] = String.valueOf(oculto); //introducimos el valor char oculto dentro del string del tablero juego transformandolo
            }
        }
    }
    static void rellenarTableroNums(){ // El tablero se rellena repitiendo el mismo numero 2 veces hasta rellenar la matriz
        do {
            for (contador = 0; contador < 2; contador++ ){
                do {
                    fila = aleatorio.nextInt(4);
                    columna = aleatorio.nextInt(4);
                }while(tableroNums[fila][columna] != 0);
                        tableroNums[fila][columna] = numero;
            }
            numero = numero + 1;
        }while(numero < 9);
    }
    static void imprimirTableroJuego(){ //variable que imprime el tablero
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tableroJuego[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    static void imprimirTableroNums(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tableroNums[i][j] +" ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args){
        rellenartableroJuego();
        rellenarTableroNums();
        imprimirTableroNums();
        imprimirTableroJuego();
        System.out.println("Vamos a jugar a un juego de memorizar");

        do {
            imprimirTableroJuego();
            //Pedimos que el usuario introduzca la primera pos
            System.out.println("¿Cual es la primera fila quieres revisar?");
            int fila = lector.nextInt();
            System.out.println("¿Cual es la primera columna quieres revisar?");
            int columna = lector.nextInt();
            tableroJuego[fila][columna] = String.valueOf(tableroNums[fila][columna]);
            imprimirTableroJuego();
            //Pedimos que el usuario introduzca la segunda posicion
            System.out.println("¿Cual es la segunda fila que quieres revisar?");
            int fila2 = lector.nextInt();
            System.out.println("Cual es la segunda columna que quieres revisar?");
            int columna2 = lector.nextInt();
            tableroJuego[fila2][columna2] = String.valueOf(tableroNums[fila2][columna2]);

            if (!tableroJuego[fila2][columna2].equals(tableroJuego[fila][columna])){ //Si los nº no son iguales, entra al if
                System.out.println("No son iguales, intenta de nuevo");
                tableroJuego[fila2][columna2] = oculto; //reseteamos en caso erroneo que vuelvan a taparse los numeros
                tableroJuego[fila][columna] = oculto;
                intentos = intentos -1;
                System.out.println("Te quedan: " + intentos + " intentos");
            }else {// Si son iguales la pareja ha sido encontrada y pasa a la siguiente
                System.out.println("Pareja encontrada, seguro que ha sido suerte");
                parejas = parejas +1;
            }
        }while(parejas<8 && intentos >0);
        if (parejas == 8){
            System.out.println("Has ganado!");
        }else {
            System.out.println("Has perdido");
        }
    }
}