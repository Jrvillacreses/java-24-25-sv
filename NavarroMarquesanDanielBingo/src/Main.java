import java.util.Collection;
import java.util.Random;
//NAVARRO MARQUESAN DANIEL
public class Main {
    static int[][] Bingo = new int[3][9];
    static int fila;
    static int columna = 10;
    static int num;
    static Random aleatorio = new Random();
    static int suma = 10;
    static boolean repetido;

    static void rellenarBingo(){
        for (columna = 0; columna < 9; columna++) {
            for (fila = 0; fila < 3; fila++) {
                do {
                    num = aleatorio.nextInt(1, 10) + suma;
                    repetido = false;
                    for (int columnaAlternativa = 0; columnaAlternativa < 9; columnaAlternativa++) {
                        if (Bingo[fila][columna]==num){
                            repetido = true;
                        }
                    }
                }while(repetido == true);
                Bingo[fila][columna] = num;
            }
            for (fila = 0; fila < 3; fila++) {
                for (int j = 0; j < 9; j++) {
                    for (int k = 0; k < columna; k++) {
                        if (Bingo[fila][k] < Bingo[fila][k+1]) {
                            int auxiliar;
                            auxiliar = Bingo[fila][k];
                            Bingo[fila][k] = Bingo[fila][k+1];
                            Bingo[fila][k+1] = auxiliar;
                        }
                    }
                }
            }
            suma = suma + 10;
        }
    }
    static void imprimirBingo(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Bingo[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args){
    rellenarBingo();
    imprimirBingo();
    }
}