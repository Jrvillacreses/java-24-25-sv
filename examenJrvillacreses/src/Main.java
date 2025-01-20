import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //Dimensiones tablero y tableros
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    public static String[][] tableroYoda = new String[MAX_FILAS][MAX_COLUMNAS];
    public static String[][] tableroVader = new String[MAX_FILAS][MAX_COLUMNAS];
    public static String[][] tableroYoda2 = new String[MAX_FILAS][MAX_COLUMNAS];
    public static String[][] tableroVader2 = new String[MAX_FILAS][MAX_COLUMNAS];
    //Recursos Java
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    // Personajes
    static final String LIBRE = "[L]";
    static final String YODA = "[Y]";
    static final String VADER = "[V]";
    static final String TRAMPA = "[T]";
    static final String DARTH_MAUL = "[D]";
    static final String R2D2 = "[R]";
    static final String FINAL = "[F]";
    static final String[] ENEMIGOS= new String[]{DARTH_MAUL,R2D2};
    public static int filaYoda;
    public static int columnaYoda;
    public static int filaVader;
    public static int columnaVader;

    //Movimientos
    public static char[]teclas = new char[]{'W','A','S','D','Q','E','R','B'};
    public static int[][] movimientos = new int[][]{
        {1,0}, //W arriba
        {0,-1}, //A izq
        {-1,0}, //S abajo
        {0,1}, //D drch
        {-1,-1}, //Q diag arriba izq
        {-1,1},  //E diag arriba drch
        {1,-1},  //R diag abajo izq
        {1,1} //B diag abajo drch
    };
    // Constantes
    static int vidasYoda = 10;
    static int vidasVader = 10;

    public static void iniciarTablero(String[][] tablero) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tablero[i][j] = LIBRE;
            }
        }
        tablero[9][9] = FINAL;
    }
    public static int buscarFilaPersonaje(String[][] tablero, String personaje){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if(tablero[i][j].equals(personaje)){
                    return i;
                }
            }
        }
        return 0;
    }
    public static int buscarColumnaPersonaje(String[][] tablero, String personaje){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if(tablero[i][j].equals(personaje)){
                    return j;
                }
            }
        }
        return 0;
    }
    public static void imprimirTablero(String[][] tablero) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(tablero[i][j] + "");
            }
            System.out.println();
        }
    }
    public static void rellenarTablero(String[][] tablero, String caracter, int numVeces){
        int filaAl = -1;
        int columnaAl = -1;
        do {for (int i = 0; i < numVeces; i++) {
            filaAl = random.nextInt(MAX_FILAS);
            columnaAl = random.nextInt(MAX_COLUMNAS);
            tablero[filaAl][columnaAl] = caracter;
            }
        }while(tablero[filaAl][columnaAl].equals("[L]"));
    }
    public static void copiarTablero(String[][] tablero, String[][] tablero2){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tablero[i][j]= tablero2[i][j];
            }
        }
    }
    public static void inicializarJuego(){
        iniciarTablero(tableroYoda);
        iniciarTablero(tableroVader);
        iniciarTablero(tableroYoda2);
        iniciarTablero(tableroVader2);
        rellenarTablero(tableroYoda, YODA, 1);
        rellenarTablero(tableroYoda, DARTH_MAUL, 5);
        rellenarTablero(tableroYoda, TRAMPA, 5);
        rellenarTablero(tableroVader,VADER,1);
        rellenarTablero(tableroVader,R2D2, 5);
        rellenarTablero(tableroVader, TRAMPA, 5);
    }
    /*
        filaActual = buscarFilaPersonaje(tablero,personaje);
        columnaActual = buscarColumnaPersonaje(tablero, personaje);
        System.out.println("Introduce el movimiento que quieres realizar: (Ej. 3A)");
        String entrada = sc.nextLine();
        numeroVeces = Character.getNumericValue(entrada.charAt(0));
        tecla = entrada.charAt(1);
        String aux;
        int dx= 0, dy = 0;
        switch (tecla){
            case ('S'):
                tablero[filaActual][columnaActual] = LIBRE;
                aux= tablero[filaActual + 1][columnaActual];
                tablero[filaActual + 1][columnaActual] = personaje;
                break;
            case('A'):
                tablero[filaActual][columnaActual] = LIBRE;
                tablero[filaActual][columnaActual - 1] = personaje;
                break;
            case('W'):
                tablero[filaActual][columnaActual] = LIBRE;
                tablero[filaActual - 1][columnaActual] = personaje;
                break;
            case('D'):
                tablero[filaActual][columnaActual] = LIBRE;
                tablero[filaActual][columnaActual + 1] = personaje;
                break;
            case('Q'):
                tablero[filaActual][columnaActual] = LIBRE;
                tablero[filaActual -1][columnaActual-1] = personaje;
                break;
            case('E'):
                tablero[filaActual][columnaActual] = LIBRE;
                tablero[filaActual -1][columnaActual+1] = personaje;
                break;
            case('R'):
                tablero[filaActual][columnaActual] = LIBRE;
                tablero[filaActual +1 ][columnaActual -1] = personaje;
                break;
            case('B'):
                tablero[filaActual][columnaActual] = LIBRE;
                tablero[filaActual +1 ][columnaActual +1] = personaje;
                break;
                if(aux.equals("[D]")){
                    vidas--;
                    System.out.println("Has perdido una vida");
                }
        }
        imprimirTablero(tableroYoda);
        }
        */
    public static void main(String[] args) {
        inicializarJuego();
        System.out.println("Tablero J1");
        imprimirTablero(tableroYoda);
        System.out.println();
        System.out.println("Tablero J2");
        imprimirTablero(tableroVader);
        int movimientos[][] = new int[8][2];

        // W: Arriba
        movimientos[0][0] = -1;
        movimientos[0][1] = 0;

        // A: Izquierda
        movimientos[1][0] = 0;
        movimientos[1][1] = -1;

        // S: Abajo
        movimientos[2][0] = 1;
        movimientos[2][1] = 0;

        // D: Derecha
        movimientos[3][0] = 0;
        movimientos[3][1] = 1;

        // Q: Diagonal arriba-izquierda
        movimientos[4][0] = -1;
        movimientos[4][1] = -1;

        // E: Diagonal arriba-derecha
        movimientos[5][0] = -1;
        movimientos[5][1] = 1;

        // R: Diagonal abajo-izquierda
        movimientos[6][0] = 1;
        movimientos[6][1] = -1;

        // T: Diagonal abajo-derecha
        movimientos[7][0] = 1;
        movimientos[7][1] = 1;

        char[] letras = {'W', 'A', 'S', 'D', 'Q', 'E', 'R', 'T'};

        boolean isFinalizado = true;

        int contador = 0;

        while (isFinalizado && (vidasYoda >= 0 || vidasVader >= 0)){

            System.out.println("Dime el movimiento:");
            char direccion = sc.next().charAt(0);

            System.out.println("Dime el número de casillas:");
            int casillas = sc.nextInt();  //6

            int coordenada = -1;
            for (int i = 0; i < letras.length; i++) {
                if (letras[i] == direccion) {
                    coordenada = i;
                    break;
                }
            }


            if (contador % 2 == 0){

                // Calcular nueva fila
                filaYoda = buscarFilaPersonaje(tableroYoda,YODA);
                columnaYoda = buscarColumnaPersonaje(tableroYoda, YODA);
                int filaCheck = filaYoda + (movimientos[coordenada][0] * casillas);
                if (filaCheck < 0) {
                    filaCheck = MAX_FILAS + filaCheck;
                } else if (filaCheck >= MAX_FILAS) {
                    filaCheck = filaCheck - MAX_FILAS;
                }

                int columnaCheck = columnaYoda + (movimientos[coordenada][1] * casillas);
                if (columnaCheck < 0) {
                    columnaCheck = MAX_COLUMNAS + columnaCheck;
                } else if (columnaCheck >= MAX_COLUMNAS) {
                    columnaCheck = columnaCheck - MAX_COLUMNAS;
                }

                switch (tableroYoda[filaCheck][columnaCheck]){
                    case LIBRE:
                        tableroYoda[filaYoda][columnaYoda] = "[L]";
                        tableroYoda[filaCheck][columnaCheck] = "[Y]";
                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;
                        break;
                    case DARTH_MAUL:
                        tableroYoda[filaYoda][columnaYoda] = "[L]";
                        tableroYoda[filaCheck][columnaCheck] = "[Y]";
                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;
                        vidasYoda--;
                    case TRAMPA:
                        System.out.println("No puedes Desplazarte a la posicion " + filaCheck + columnaCheck + " Hay una Trampa");
                        vidasYoda--;
                        break;
                    case FINAL:
                        tableroYoda[filaYoda][columnaYoda] = "[L]";
                        tableroYoda[filaCheck][columnaCheck] = "[W]";
                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;
                        System.out.println("HAS GANADO");
                        vidasYoda = -10;
                        isFinalizado = false;
                        break;
                }
                imprimirTablero(tableroYoda);
            }else {

                // Calcular nueva fila
                int filaCheck = filaVader + (movimientos[coordenada][0] * casillas);
                if (filaCheck < 0) {
                    filaCheck = MAX_FILAS + filaCheck;
                } else if (filaCheck >= MAX_FILAS) {
                    filaCheck = filaCheck - MAX_FILAS;
                }

                // Calcular nueva columna
                int columnaCheck = columnaVader + (movimientos[coordenada][1] * casillas);
                if (columnaCheck < 0) {
                    columnaCheck = MAX_COLUMNAS + columnaCheck;
                } else if (columnaCheck >= MAX_COLUMNAS) {
                    columnaCheck = columnaCheck - MAX_COLUMNAS;
                }

                switch (tableroVader[filaCheck][columnaCheck]){
                    case LIBRE:
                        tableroVader[filaVader][columnaVader] = "[L]";
                        tableroVader[filaCheck][columnaCheck] = "[V]";
                        filaVader = filaCheck;
                        columnaVader = columnaCheck;
                        break;
                    case R2D2:

                        tableroVader[filaVader][columnaVader] = "[L]";
                        tableroYoda[filaCheck][columnaCheck] = "[V]";

                        // Actualizar posición del personaje
                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        vidasVader--;

                    case TRAMPA:
                        System.out.println("No puedes Desplazarte a la posicion " + filaCheck + columnaCheck + " Hay una Trampa");
                        vidasVader--;
                        break;
                    case FINAL:
                        tableroVader[filaVader][columnaVader] = "[L]";
                        tableroVader[filaCheck][columnaCheck] = "[W]";

                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        System.out.println("HAS GANADO");
                        vidasVader = -10;
                        isFinalizado = false;
                        break;
                }
                imprimirTablero(tableroVader);
            }
            if (vidasYoda >= 0 || vidasVader >= 0){
                isFinalizado = false;
            }
            contador++;
        }
    }
    }
