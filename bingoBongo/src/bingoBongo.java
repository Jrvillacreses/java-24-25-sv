import java.util.Random;
import java.util.Scanner;

public class bingoBongo {
    static int matriz[][] = new int[3][9];
    static final int MAX_FILAS  = 3;
    static final int MAX_COLUMNAS  = 9;

    static Random aleatorio = new Random();
    static Scanner lector = new Scanner(System.in);

    public static boolean repetidoNumero(int j,int valor){
        for (int i = 0; i < MAX_FILAS; i++) {
            if(valor==matriz[i][j]){
                return true;
            }
        }
        return false;
    }

    public static void rellenarCarton(){
        int valor;
        int decenas = 0;
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            for (int i = 0; i < MAX_FILAS; i++) {
                do{
                valor = aleatorio.nextInt(0,9) + decenas;
                matriz[i][j] = valor;
                }while(repetidoNumero(j, valor)==false);
                matriz[i][j]= valor;
            }
            decenas = decenas +10;
        }
    }

    public static void mostrarMatriz(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rellenarCarton();
        mostrarMatriz();
    }
}

