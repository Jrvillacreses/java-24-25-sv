import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] a1 = {2,4,6,8,10};
        int[] a2 = {1,2,3,4,5};
        int i = 0;
        for(i = 0; i < a2.length; i++ ) {
            a1[i] = a2[i];
        }
        for(int j = 0; j < a2.length; j++ ) {
            a1[j] = a2[i];
        }
        for(int x = 0; x < a1.length; x++ ) {
            System.out.print("a1[" + x + "]=" + a1[x] + ".\n");
        }
    }
}