
import java.util.Random;
import java.util.Scanner;


public class mineSweeperProject {

    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------- initialize
        StopWatch s = new StopWatch();
        s.start();
        long timeForChange = s.getElapsedTime();

        Scanner input = new Scanner(System.in);

        int row = 0;   //use only to change the row in if statement for the array field

        int field[] = new int[100];   //array for  the field
        int[] flags = new int[10];
        Random bombGenerator = new Random();
        int field1 = 0;           //gadering the numbers from 1 to 2 generated from the random generator and fills array
        int x;                    // system keyboard input
        int numberOfBombs = 0;

//------------------------------------------------------------------------------------------------------ initialize






// -------------------------------------------------------------------------generating bombs and and placing them randomly

        for (int i = 1; i <= 10; i++) {
            System.out.print("[ " + i + " ]");
        }
        System.out.println("");
        System.out.println("_____________________________________________________");

        for (int i = 0; i < field.length; i++) {
            field1 = 1 + bombGenerator.nextInt(4); // the idea is to start from 1
            row++;

            if (field1 == 1) {
                numberOfBombs++;

            }
            if (numberOfBombs > 10) {
                field1 = 2;
            }
            if (field1 == 3 || field1 == 4) {
                field1 = 2;
            }


            field[i] = field1;

            if (field[i] == 1 || field[i] == 2) {

                System.out.print("[");
                System.out.print(" ? ");  // blanck or field[i]
                System.out.print("]");

            }
            if (row % 10 == 0) {
                System.out.println("[" + row / 10 + "]");

            }

        }

        System.out.println("_____________________________________________________");
        flagsForBombs(field, flags);

//-------------------------------------------------------------------------generating bombs and field and placing them randomly






// -------------------------------------------------------------------------refreshing the field with the changes


        System.out.println("The flag of the Bombs");


        for (int j = 0; j < flags.length; j++) {
            System.out.print("~ " + flags[j] + " ~");

        }

        System.out.println("");
        System.out.println("_____________________________________________________");

        s.getTimeForAll();

        System.out.println("_____________________________________________________");
        do {
            System.out.println(" ");

            System.out.println("Въведете стойност за  позиция по хоризонтала и вертикала от 1 до 100, " +
                    "ако желаете да излезете от програмата натиснете 0 или число над 101");
            System.out.println(" ");
            x = input.nextInt();
            if (x > 101) {
                x = 0;
            }
            checkForMines(x, field);
            printTableAfetCheck(field, x);


            System.out.println("_____________________________________________________");
            System.out.println("The flag of the Bombs");

            for (int j = 0; j < flags.length; j++) {
                System.out.print("~ " + flags[j] + " ~");

            }
            System.out.println("");
            System.out.println("_____________________________________________________");
            s.getTimeForAll();

            System.out.println("_____________________________________________________");
        } while (x > 0);
        s.stop();
    }

    //-------------------------------------------------------------------------refreshing the field with the changes







    private static void checkForMines(int x, int[] field) {
// checks for mine and gives a different value of the indexes of the array that we are using for the field
        // also display message for quitting  the game


        if (x < 101 && x > 0) {
            x -= 1;
            if (field[x] == 1) {
                System.out.println("It is a bomb !");
                field[x] = 5;
            } else if (field[x] == 2) {
                System.out.println("Go on");
                field[x] = 6;
            }
        } else {
            System.out.println("you have quit the game");
        }
    }
//------------------------------------------------------------------------------------------


    public static void printTableAfetCheck(int[] field, int x) {
        int row3 = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("[ " + i + " ]");
        }
        System.out.println("");
        System.out.println("_____________________________________________________");

        for (int j = 0; j < field.length; j++) {
            row3++;

            if (field[j] == 5) {

                System.out.print("[");
                System.out.print(" " + "@" + " ");  // blanck or field[i]
                System.out.print("]");
            } else if (field[j] == 6) {
                System.out.print("[");
                System.out.print(" " + "0" + " ");  // blanck or field[i]
                System.out.print("]");
            } else {

                System.out.print("[");
                System.out.print(" " + "?" + " ");  // blanck or field[i]
                System.out.print("]");

            }
            if (row3 % 10 == 0) {
                System.out.println("[" + row3 / 10 + "]");
            }
        }

    }





    public static int[] flagsForBombs(int[] field, int[] flags) {
//        ------------------------------------------------------------ gives a value for the flags

        for (int i = 0; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[0]++;
            }
        }

        for (int i = 1; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[1]++;
            }
        }

        for (int i = 2; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[2]++;
            }
        }

        for (int i = 3; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[3]++;
            }
        }

        for (int i = 4; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[4]++;
            }
        }

        for (int i = 5; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[5]++;
            }
        }

        for (int i = 6; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[6]++;
            }
        }

        for (int i = 7; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[7]++;
            }
        }

        for (int i = 8; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[8]++;
            }
        }

        for (int i = 9; i < field.length; i += 10) {
            if (field[i] == 1) {
                flags[9]++;
            }
        }

        return flags;
    }






    //-----------------------------------------------------------------------------stuff for timer

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }


    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }


    //elaspsed time in milliseconds
    public long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = (System.currentTimeMillis() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }


    //elaspsed time in seconds
    public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        } else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }


    public void getTimeForAll() {

        long milliTime = getElapsedTime();
        int[] out = new int[]{0, 0, 0, 0};
        out[0] = (int) (milliTime / 3600000);
        out[1] = (int) (milliTime / 60000) % 60;
        out[2] = (int) (milliTime / 1000) % 60;
        out[3] = (int) (milliTime) % 1000;


        System.out.print("Time past : " + out[0] + ":" + out[1] + ":" + out[2] + "." + out[3]);


        System.out.println(" ");

        //------------------------------------------------------------------stuff for timer
    }

}

