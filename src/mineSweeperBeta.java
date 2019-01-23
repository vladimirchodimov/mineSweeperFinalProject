import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class mineSweeperBeta {
    public static void main(String[] args) {

        int[][] field = new int[6][10];
        Random bombGenerator = new Random();
        Scanner input =new Scanner(System.in);


        placeBombsOnTheField(field, bombGenerator);
        placingFlagsOnTheField(field);
        printField(field);



int couter = 0;

        do {
            int a = input.nextInt();
            Date time=new Date();
            String zeroTime= time.toString();



            System.out.println(zeroTime.substring(14,19));

        }while (input.nextInt() !=0);
    }

    public static void printField(int[][] field) {
        System.out.println("______________________________");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                System.out.print("[" + field[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println("______________________________");

    }

    public static int[][] placeBombsOnTheField(int[][] field, Random bomb) {

        int generatedBombs = 0;
        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field[i].length; j++) {
                generatedBombs = bomb.nextInt(5);

                if (generatedBombs > 0 && generatedBombs < 2) {
                    field[i][j] = generatedBombs;
                }
            }
        }
        return field;
    }

    public static int[][]placingFlagsOnTheField(int [][]field){
        int flags=0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                if(field[i][j]!=1) {

                    if (field[i + 1][j + 1] == 1) {
                        flags++;
                    }
                    if (field[i - 1][j - 1] == 1) {
                        flags++;
                    }
                    if (field[i][j + 1] == 1) {
                        flags++;
                    }
                    if (field[i][j - 1] == 1) {
                        flags++;
                    }
                    if (field[i + 1][j] == 1) {
                        flags++;
                    }
                    if (field[i - 1][j] == 1) {
                        flags++;
                    }
                }
                field[i][j]=flags;
                flags=0;
            }

        }
        return field;
    }

}
