import java.util.Random;
import java.util.Scanner;


public class Main {

    static Scanner leer= new Scanner(System.in);
    static Random aleatorio= new Random();

    static int numComparaciones;
    static int [] years= new int [3];
    static final int NUM_YEARS=3;

    private static void leerYears() {
        for (int i = 0; i < numComparaciones; i++) {
            years[i]= leer.nextInt();
        }
    }

    private static boolean comprobarOrden() {
        if (years[0]<years[1]){
            if (years[1]<years[2]){
                return true;
            }
        }
        return false;
    }

    private static void ordenarDistancia(){

    }

    public static void main(String[] args) {

        System.out.println("Bienvenido a la máquina virtual de medida de distancia entre fechas.");
        System.out.print("A continuación, indica la cantidad de comparaciones a realizar en orden: ");
        numComparaciones= leer.nextInt();

        for (int i = 0; i < numComparaciones; i++) {
            do {
                leerYears();
            } while (comprobarOrden()==false);
        }

        for (int i = 0; i < NUM_YEARS; i++) {
            System.out.println(years[i]);
        }
    }


}