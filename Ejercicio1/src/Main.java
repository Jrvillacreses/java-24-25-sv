import java.util.Random;
public class Main {
    static int array[] = new int[10];
    static Random rand = new Random();

    public static void main(String[] args) {
            for (int i = 0; i < 10; i++){
                array[i] = rand.nextInt(10) + 1;
            }
            for (int i = 0; i < 10; i++){
                System.out.print(array[i] + " ");
            }
        }
    }