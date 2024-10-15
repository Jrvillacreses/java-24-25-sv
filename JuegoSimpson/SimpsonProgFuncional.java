import java.util.Random;

public class SimpsonProgFuncional {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static String[][] tablero;

    public static void main(String[] args) {
        // 1º) Inicializo mi matriz tablero
        tablero = new String[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        //2º) Rellenar el tablero 'L'
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                //[0,0],[0,1],[0,2],[0,3],ETC
                tablero[i][j] = "[ ]" ;
            }
        }
        //3º) Imprimir tablero
        imprimirTablero();
        //4º) Asignar a Bart 
        Random aleatorio = new Random();
        int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9

        tablero[filaAleatorio][columnaAleatorio] = "[B]";

        //5º) Imprimir tablero
        imprimirTablero();
        // 6º) Repartir 10 Homer dentro del tablero
        int filaAleatorioHomer;
        int columnaAleatorioHomer;
        for (int i = 0; i < 10; i++) {
            do{
                filaAleatorioHomer = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
                columnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
            }while (tablero[filaAleatorioHomer][columnaAleatorioHomer]!="[ ]");
            // Cuando tablero[filaAleatorioHomer][columnaAleatorioHomer]="[ ]"
            tablero[filaAleatorioHomer][columnaAleatorioHomer] = "[H]";
        }
        //7º) Imprimir tablero
        imprimirTablero();
        int filaAleatorioMuro;
        int columnaAleatorioMuro;
        for (int i = 0; i < 10; i++) {
            do{
                filaAleatorioMuro = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
                columnaAleatorioMuro = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
            }while (tablero[filaAleatorioMuro][columnaAleatorioMuro]!="[ ]");
            // Cuando tablero[filaAleatorioHomer][columnaAleatorioHomer]="[ ]"
            tablero[filaAleatorioMuro][columnaAleatorioMuro] = "[M]";
        }
        imprimirTablero();
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = "[F]";
        imprimirTablero();
    }

    private static void imprimirTablero(){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                //[0,0],[0,1],[0,2],[0,3],ETC
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
