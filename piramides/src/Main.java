import java.util.Scanner;

public class Main {
    static Scanner askBlock = new Scanner(System.in);
    static int blckNum;
    static boolean goodBlock = false;
    public static void pedirNum(){
        blckNum = askBlock.nextInt();
    }
    private static void calculateFloor(int numBloques){
        int longitud=1;
        int blocksCount =0;
        int floorNum =0;
        do {
            blocksCount = blocksCount + longitud*longitud;
            longitud = longitud+2;
            floorNum++;
        } while (numBloques> blocksCount);
        if (numBloques == 0){
            goodBlock = true;
        }else {
            System.out.println(floorNum);
        }
    }
    public static void main(String[] args) {
        do {
            pedirNum();
            calculateFloor(blckNum);
        }while (!goodBlock);
    }
}