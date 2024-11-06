import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static public int number;
    static public int cantidad;
    static public String jeroglifico;
    //Guardamos potencias y su char en strings para compararlas
    static public int[] potencias = {1000000, 100000, 10000, 1000, 100, 10, 1};
    static public char[] simbolos = {'H', 'R', 'D', 'F', 'C', 'G', 'T'};
    //Hacemos la funcion para preguntar jeroglifico
    static public void insertJeroglifico() {
        while (true){
            number = sc.nextInt();
            if (number == 0){
                break;
            }
            // Inicializo jeroglifico como un string vacio para añadir los char posteriormente
            jeroglifico = "";
            // Convierto el número en jeroglifico
            for (int i = 0; i < potencias.length; i++) {
                cantidad = number / potencias[i];
                number = number % potencias[i];
                // Traducimos el número a símbolos
                for (int j = 0; j < cantidad; j++) {
                    jeroglifico += simbolos[i];
                }
            }
            System.out.println(jeroglifico);
        }
        //cerramos el scanner para que solucione el jeroglifico
        sc.close();
    }
    public static void main(String[] args) {
        insertJeroglifico();
    }
}