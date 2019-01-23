import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class mineSweeperBeta {
    public static void main(String[] args) {

        int[][] field = new int[6][10];
        Random bombGenerator = new Random();
        Scanner input = new Scanner(System.in);
        int couter = 0;

        placeBombsOnTheField(field, bombGenerator);
        placingFlagsOnTheField(field);
        printField(field);


        int x = 0;
        int y = 0;
        do {

            System.out.println("Enter coordinate y: ");
            y = input.nextInt();
            System.out.println("Enter coordinate x: ");
            x = input.nextInt();

            if (field[y][x] == 9) {
                System.out.println("there is a bomb");
            } else {
                System.out.println("there is " + field[y][x] + " bombs nearby");
            }
printFieldAfterCheck(field,y,x);

            Date time = new Date();
            String zeroTime = time.toString();
            System.out.println(zeroTime.substring(14, 19));

        } while (x <= 100 || y <= 100);
    }

    public static void printField(int[][] field) {
        System.out.println("_________________________________________________");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                System.out.print("[ " + "?" + " ]");  //field[i][j]
            }
            System.out.println();
        }
        System.out.println("_________________________________________________");

    }

    public static void printFieldAfterCheck(int[][] field, int y, int x) {
        System.out.println("_________________________________________________");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[y][x] == 0) {
                    System.out.print("[ " + " " + " ]");  //field[i][j]
                }
                if (field[y][x] == 9) {
                    System.out.print("[ " + "*" + " ]");  //field[i][j]
                }
                if (field[y][x] != 0||field[y][x] != 9) {
                    System.out.print("[ " + field[y][x] + " ]");  //field[i][j]
                }else {
                    System.out.print("[ " + "?" + " ]");
                }

            }
            System.out.println();
        }
        System.out.println("_________________________________________________");

    }

    public static int[][] placeBombsOnTheField(int[][] field, Random bomb) {

        int generatedBombs = 0;
        for (int i = 1; i < field.length; i++) {

            for (int j = 1; j < field[i].length; j++) {
                generatedBombs = bomb.nextInt(6);

                if (generatedBombs > 0 && generatedBombs < 2) {
                    generatedBombs = 9;
                    field[i][j] = generatedBombs;
                }
            }
        }
        return field;
    }

    public static int[][] placingFlagsOnTheField(int[][] field) {
        int flags = 0;
        for (int i = 1; i < field.length - 1; i++) {
            for (int j = 1; j < field[i].length - 1; j++) {

                if (field[i][j] != 9) {

                    if (field[i][j + 1] == 9) {
                        flags++;
                    }
                    if (field[i][j - 1] == 9) {
                        flags++;
                    }
                    if (field[i - 1][j] == 9) {
                        flags++;
                    }
                    if (field[i + 1][j] == 9) {
                        flags++;
                    }
                    if (field[i + 1][j + 1] == 9) {
                        flags++;
                    }
                    if (field[i - 1][j + 1] == 9) {
                        flags++;
                    }
                    if (field[i + 1][j - 1] == 9) {
                        flags++;
                    }
                    if (field[i - 1][j - 1] == 9) {
                        flags++;
                    }
                    field[i][j] = flags;

                }
                flags = 0;

            }

        }
        return field;
    }

}