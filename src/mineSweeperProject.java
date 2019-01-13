import java.util.Random;
import java.util.Scanner;

public class mineSweeperProject {
    public static void main(String[] args) {

//        char field[] = {'[', '?', ']'};
        int row = 0;   //use only to change the row in if statement
        char blanck = '?';        // encrypt the information about the field - 1 2 3

        int field[] = new int[100];   //array for taking the value of the field cordinate
        Random bombGenerator = new Random();
        int field1 = 0;    //gadering the numbers from 1 to 3 generated from the random generator
        int x; // system input
        int numberOfBombs = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("[ " + i + " ]");
        }
        System.out.println("");
        for (int i = 0; i < 100; i++) {
            field1 = 1 + bombGenerator.nextInt(4);
            row++;

            if (field1 == 1) {
                numberOfBombs++;

            }
            if (numberOfBombs > 20) {
                field1 = 2;
            }
            if (field1 == 3 || field1 == 4) {
                field1 = 2;
            }


            field[i] = field1;


            if (field[i] == 1 || field[i] == 2) {

                System.out.print("[");
                System.out.print(" " + field[i] + " ");  // blanck or field[i]
                System.out.print("]");
            }
            if (row % 10 == 0) {
                System.out.println("[" + row / 10 + "]");

            }
        }
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Въведете стойност за от 1 до 9 позиция по хоризонтала и вертикала");
            x = input.nextInt();
            checkForMines(x, field);
        } while (x != 101 || x != 0);

    }

    private static void checkForMines(int x, int[] field) {

        if (x < 101 && x > 0) {
            x -= 1;
            if (field[x] == 1) {
                System.out.println("it is a bomb");
            } else if (field[x] == 2) {
                System.out.println("go on");
            }

        } else {
            System.out.println("you have quit the game");
        }


    }

}
