import java.util.Random; //Faltaba llamar a la biblioteca Random

public class Main {
    public static void main(String[] args) {
        //Array de 10x9
        int filas = 10;
        int columnas = 9;
        int tablero[][] = new int[filas][columnas];
        //Llamamos al Random
        Random random = new Random();
        //Recorremos la matriz rellenando números del 0 al 9, en cada columna se añaden 10 decenas 10-19/20-29...
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //int numAleatorio= random.nextInt(10)+10*(j+1); //10 - 19
                int numAleatorio = random.nextInt(10*(j+1),(10*(j+1)+10));
                tablero[i][j] = numAleatorio;
            }
        }
                /*
          //Método de ordenación en el cuál comparamos el termino en el que nos encontramos, únicamente con el siguiente(fila con columna y fila+1 con columna)
          //Aunque puede parecer correcto, puede fallar al no comparar todos los números
        int cont = 0;
        do {
            for (int i = 0; i < filas -1; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (tablero[i][j] > tablero[i + 1][j]) {
                        int aux;
                        aux = tablero[i][j];
                        tablero[i][j] = tablero[i + 1][j];
                        tablero[i + 1][j] = aux;
                    }
                }
            }
            cont++;
        }while (cont < filas);

                 */
    // Metodo que se parece al método burbuja que hemos empleado en la función final, se basa en bucles for, damos por hecho que
        //se repite 1 vez
        /*for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas; i++) {
                for (int k = 0; k < filas - 1; k++) {
                    if(tablero[k][j] > tablero[k + 1][j]){
                        int aux = tablero[k][j];
                        tablero[k][j] = tablero[k + 1][j];
                        tablero[k + 1][j] = aux;
                    }
                }
            }

        }*/
        //metodo burbuja pr columnas, recorre la matriz varias veces.
       /* for (int i = 0; i < filas-1; i++) { // [0,0][1,0], [1,0][2,0]
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j]>tablero[i+1][j]){
                    int aux = tablero[i+1][j];
                    tablero[i][j] = tablero[i + 1][j];
                    tablero[i + 1][j] = aux;
                }
            }
        }*/
        //Método burbuja para la ordenación de columnas de menor a mayor
        for (int columna = 0; columna < 9; columna++) {

            for (int i = 0; i < filas - 1; i++) {
                for (int j = i; j < filas; j++) {
                    if (tablero[i][columna] > tablero[j][columna]) {
                        int aux = tablero[i][columna];
                        tablero[i][columna] = tablero[j][columna];
                        tablero[j][columna] = aux;
                    }
                }
            }

        }
        //Imprime la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}