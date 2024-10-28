import java.util.Scanner;
import static java.lang.Math.abs;

public class Main {

    static int[][] years;
    static Scanner scanner = new Scanner(System.in);


    // Lee y almacena los casos de prueba
    public static void leerCasos(int numCasos) {
        for (int i = 0; i < numCasos; i++) {
            String[] partes = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                years[i][j] = Integer.parseInt(partes[j]);
            }
        }
    }

    // Procesa cada caso y muestra el resultado
    public static void procesarCasos(int numCasos) {
        for (int i = 0; i < numCasos; i++) {
            System.out.println(obtenerAnioCercano(i));
        }
    }

    // Calcula la distancia entre dos años, considerando el salto del año 0
    public static int calcularDistancia(int x, int y) {
        return (x < 0 && y > 0) || (x > 0 && y < 0) ? abs(x) + abs(y) - 1 : abs(x - y);
    }

    // Determina el año más cercano a B o si existe un empate
    public static String obtenerAnioCercano(int i) {
        int a = years[i][0], b = years[i][1], c = years[i][2];
        int distanciaA = calcularDistancia(a, b), distanciaC = calcularDistancia(c, b);

        return (distanciaA == distanciaC) ? "EMPATE" : (distanciaA < distanciaC ? String.valueOf(a) : String.valueOf(c));
    }

    public static void main(String[] args) {
        int numCasos = Integer.parseInt(scanner.nextLine().trim());
        years = new int[numCasos][3];

        leerCasos(numCasos);
        procesarCasos(numCasos);
    }
}

