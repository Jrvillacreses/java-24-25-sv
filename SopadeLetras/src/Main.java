import java.util.Random;

public class Main {
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static char[][] tablero = new char[MAX_FILAS][MAX_COLUMNAS];
    static Random rand = new Random();
    static String[] palabras = {"LUCIA", "LAURA", "MARLO", "JAIRO", "CAMIL"};


    private static void inicializarTablero() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tablero[i][j] = (char) (rand.nextInt(26) + 'A'); // Genera caracteres de 'A' a 'Z'
            }
        }
    }

    private static void insertarPalabras() {
        for (String palabra : palabras) {
            boolean colocada = false;
            while (!colocada) {
                int filaAl = rand.nextInt(MAX_FILAS);
                int columnaAl = rand.nextInt(MAX_COLUMNAS);
                String direccion = siCaber(filaAl, columnaAl, palabra.length());


                if (!direccion.equals("0")) {
                    colocada = insertarPalabraEnDireccion(filaAl, columnaAl, palabra, direccion);
                }
            }
        }
    }


    private static String siCaber(int fila, int columna, int longitud) {
        if (columna + longitud <= MAX_COLUMNAS) {
            return "HorDer";
        }
        if (columna - longitud >= -1) {
            return "HorIzq";
        }
        if (fila + longitud <= MAX_FILAS) {
            return "VerAb";
        }
        if (fila - longitud >= -1) {
            return "VerAr";
        }
        return "0";
    }


    private static boolean insertarPalabraEnDireccion(int fila, int columna, String palabra, String direccion) {
        switch (direccion) {
            case "HorDer":
                if (columna + palabra.length() <= MAX_COLUMNAS) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila][columna + i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "HorIzq":
                if (columna - palabra.length() >= -1) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila][columna - i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "VerAb":
                if (fila + palabra.length() <= MAX_FILAS) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][columna] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "VerAr":
                if (fila - palabra.length() >= -1) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila - i][columna] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
        }
        System.out.println("no cabe");
        return false;
    }


    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        inicializarTablero();
        System.out.println("Tablero inicial:");
        imprimirTablero();


        insertarPalabras();


        System.out.println("\nTablero con palabras insertadas:");
        imprimirTablero();
    }
}

