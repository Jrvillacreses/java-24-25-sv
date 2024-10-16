import java.util.Random;
import java.util.Scanner;

public class Main {
    static String array[] = new String[6];
    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);
    public static void RellenarLoto (){
        for (int i = 0; i < array.length; i++) {
            int numero = rand.nextInt(49) + 1;
            array[i] = Integer.toString(numero);
        }
    }
    public static void comprobarTachar (int numUsuario){
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(String.valueOf(numUsuario)) ){
                array[i] = "X";
            }
        }
    }
    public static void ImprimirLoto(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String[] args) {
            RellenarLoto();
            ImprimirLoto();
            System.out.println("");
            for (int i = 0; i < 3; i++) {
                //Preguntar 3 números al usuario y comprobamos si está
                System.out.println("¿Cuál es el número " + (i+1) + " que crees que están en la Primitiva?");
                int numUsuario = leer.nextInt();
                comprobarTachar(numUsuario);
            }
            //Imprimo la Primitiva
        ImprimirLoto();
    }
}