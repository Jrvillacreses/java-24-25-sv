import java.util.Random;
import java.util.Scanner;

public class Main {

    final static int MAX_ROWS = 4;
    final static int MAX_COLS = 4;
    public static String[][] gameX = new String[MAX_ROWS][MAX_COLS];
    public static String[][] game = new String[MAX_ROWS][MAX_COLS];
    public static String answer;
    static int vidas = 10;
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    public static boolean trueCard = false;
    public static void fillNumbers(){
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                game[i][j] = String.valueOf(rand.nextInt(1,8));
            }
        }
    }
    public static void fillX(){
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                gameX[i][j] = "[X] ";
            }
        }
    }
    public static void printContent(){
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                System.out.print("[" + game[i][j] + "] ");
            }
            System.out.println();
        }
    }
    public static void printContentX(){
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                System.out.print(gameX[i][j]);
            }
            System.out.println();
        }
    }
    public static void hideContent(){
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
    public static void askCoord(){
        do{
            for (int i = 0; i < 1; i++) {
                answer = sc.nextLine();
            }
        }while(vidas < 0);
    }
    public static void compareStrings(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game[i][j].equals(answer)) {
                    gameX[i][j] = answer;
                }
            }
        }
    }
    public static void printResult(){
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                if (!gameX[i][j].equals("X")) {
                    System.out.print("[" + gameX[i][j] + "] ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        fillNumbers();
        printContent();
        Thread.sleep(5000);
        hideContent();
        fillX();
        printContentX();
        askCoord();
        compareStrings();
        printResult();
    }
}