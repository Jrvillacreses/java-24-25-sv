import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(reader.readLine().trim());

        StringBuilder result = new StringBuilder(); // StringBuilder para resultados rápidos

        for (int i = 0; i < numCasos; i++) {
            String[] line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            // Calcular distancias
            int distanciaA = calcularDistancia(a, b);
            int distanciaC = calcularDistancia(c, b);

            if (distanciaA == distanciaC) {
                result.append("EMPATE\n");
            } else if (distanciaA < distanciaC) {
                result.append(a).append("\n");
            } else {
                result.append(c).append("\n");
            }
        }
        System.out.print(result); // Imprimir todo el resultado de una vez
    }

    // Cálculo de distancia sin Math.abs
    private static int calcularDistancia(int x, int y) {
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) {
            return (x < 0 ? -x : x) + (y < 0 ? -y : y) - 1;
        }
        int dist = x - y;
        return dist < 0 ? -dist : dist;
    }
}
