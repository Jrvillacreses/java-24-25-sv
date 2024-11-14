import java.util.Scanner;

public class Main {

    // Función principal que coordina la ejecución
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lee cada línea hasta encontrar "0 0"
        while (true) {
            int huevos = scanner.nextInt();  // Cantidad de huevos
            int capacidad = scanner.nextInt();  // Capacidad de la olla

            // Condición de parada
            if (huevos == 0 && capacidad == 0) {
                break;
            }

            // Calcula el tiempo de cocción usando la función auxiliar
            int tiempo = calcularTiempoCoccion(huevos, capacidad);
            System.out.println(tiempo);
        }
        scanner.close();
    }

    // Función que calcula el tiempo de cocción mínimo
    public static int calcularTiempoCoccion(int huevos, int capacidad) {
        // Número de tandas necesarias (redondeo hacia arriba)
        int tandas = (int) Math.ceil((double) huevos / capacidad);

        // Cada tanda toma 10 minutos
        return tandas * 10;
    }
}
