import java.util.Random;
import java.util.Scanner;

public class mineSweeperProject {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int row = 0;   //use only to change the row in if statement
        char blanck = '?';        // encrypt the information about the field - 1 2 3

        int field[] = new int[100];   //array for taking the value of the field cordinates
        Random bombGenerator = new Random();
        int field1 = 0;    //gadering the numbers from 1 to 2 generated from the random generator
        int x; // system input
        int numberOfBombs = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("[ " + i + " ]");
        }
        System.out.println("");
        for (int i = 0; i < field.length; i++) {
            field1 = 1 + bombGenerator.nextInt(4); // the idea is to start from 1
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
                System.out.print(" " + blanck + " ");  // blanck or field[i]
                System.out.print("]");
            }else{
                System.out.print("[");
                System.out.print(" " + "0" + " ");  // blanck or field[i]
                System.out.print("]");
            }
            if (row % 10 == 0) {
                System.out.println("[" + row / 10 + "]");
            }

        }


        do {


            System.out.println("Въведете стойност за  позиция по хоризонтала и вертикала от 1 до 100, " +
                    "ако желаете да излезете от програмата натиснете 0 или число над 101");
            x = input.nextInt();
            if (x > 101) {
                x = 0;
            }
            checkForMines(x, field);
printTableAfetCheck(field, blanck);

        } while (x > 0);

    }

    private static void checkForMines(int x, int[] field) {

        if (x < 101 && x > 0) {
            x -= 1;
            if (field[x] == 1) {
                System.out.println("It is a bomb !");
            } else if (field[x] == 2) {
                System.out.println("Go on");
                field[x] = 0;
            }

        } else {
            System.out.println("you have quit the game");
        }

    }
    public static void printTableAfetCheck(int[] field, int blanck){
        int row3=0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("[ " + i + " ]");
        }
        System.out.println("");
        for (int i = 0; i < field.length; i++) {
            row3++;
            if (field[i] == 1 || field[i] == 2) {
                if (field[i]==2){
                    System.out.print("[");
                    System.out.print(" " + "0" + " ");  // blanck or field[i]
                    System.out.print("]");
                }else {

                    System.out.print("[");
                    System.out.print(" " + blanck + " ");  // blanck or field[i]
                    System.out.print("]");
                }
            }


            if (row3 % 10 == 0) {
                System.out.println("[" + row3 / 10 + "]");
            }

        }
    }

}
