import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class mineSweeperBeta {
    public static void main(String[] args) {

        Random bombGenerator = new Random();
        Scanner input = new Scanner(System.in);
        int[][] field = new int[6][10];
        int couter = 0;
        int a = 0;
        int b = 0;
        int x;
        int y;

        placeBombsOnTheField(field, bombGenerator);
        placingFlagsOnTheField(field);
        printField(field);


        do {
            System.out.println("Enter coordinate y: ");
            y = input.nextInt();
            System.out.println("Enter coordinate x: ");
            x = input.nextInt();

            if (x < 99 || y < 99) {
                if (x > 9 || y > 5) {
                    System.out.println("Please enter value for X<9 and Y<5 or enter 100 for exit");
                } else {

                    if (field[y][x] == 9) {
                        System.out.println("there is a bomb");
                    } else {

                        if (field[y][x] < 10) {                                                 // to print only da values before changing
                            System.out.println("there is " + field[y][x] + " bombs nearby");
                        }
                    }

                    printFieldAfterCheck(field, y, x);
                    Date time = new Date();
                    String zeroTime = time.toString();
                    System.out.println(zeroTime.substring(14, 19));

                }
            }

            a = checkIfAllTheFieldsOpened(field, b);

        } while ((x != 100 || y != 100) && a == 1);

        System.out.println("You have quit the game");
    }


    public static void printField(int[][] field) {
        for (int i = 0; i <= 9; i++) {
            System.out.print("[ " + i + " ]");
        }
        System.out.println("");
        System.out.println("_________________________________________________");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                System.out.print("[ " + "?" + " ]");  //field[i][j]
            }
            System.out.println("|" + "[ " + i + " ]");
        }
        System.out.println("_________________________________________________");

    }

    public static void printFieldAfterCheck(int[][] field, int y, int x) {
        for (int i = 0; i <= 9; i++) {
            System.out.print("[ " + i + " ]");
        }
        System.out.println("");
        System.out.println("_________________________________________________");


        if (field[y][x] == 1) {
            field[y][x] += 10;
        }
        if (field[y][x] == 2) {
            field[y][x] += 20;
        }
        if (field[y][x] == 3) {
            field[y][x] += 30;
        }
        if (field[y][x] == 4) {
            field[y][x] += 40;
        }
        if (field[y][x] == 5) {
            field[y][x] += 50;
        }
        if (field[y][x] == 6) {
            field[y][x] += 60;
        }
        if (field[y][x] == 0) {
            field[y][x] += 77;
        }
        if (field[y][x] == 9) {
            field[y][x] += 90;
        }


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                if (field[i][j] == 77) {
                    System.out.print("[ " + " " + " ]");  //field[i][j] " "
                }
                if (field[i][j] == 99) {
                    System.out.print("[ " + "*" + " ]");  //field[i][j] "*"
                }
                if (field[i][j] == 66) {
                    System.out.print("[ " + "6" + " ]");  //field[i][j]  "6"
                }
                if (field[i][j] == 55) {
                    System.out.print("[ " + "5" + " ]");  //field[i][j] "5"
                }
                if (field[i][j] == 44) {
                    System.out.print("[ " + "4" + " ]");  //field[i][j] "4"
                }
                if (field[i][j] == 33) {
                    System.out.print("[ " + "3" + " ]");  //field[i][j] "3"
                }
                if (field[i][j] == 22) {
                    System.out.print("[ " + "2" + " ]");  //field[i][j]"2"
                }
                if (field[i][j] == 11) {
                    System.out.print("[ " + "1" + " ]");  //field[i][j]   "1"
                }
                if (field[i][j] != 11 && field[i][j] != 22 && field[i][j] != 33 && field[i][j] != 44 && field[i][j] != 55 && field[i][j] != 66 && field[i][j] != 77 && field[i][j] != 99) {
                    System.out.print("[ " + "?" + " ]");  //"?" field[i][j]
                }
            }

            System.out.println("|" + "[" + i + "]");
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
// gives a flags for the bombs, but cant cover the beginning and the end of the field
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
// give value of flags for the upper part of the array
        flags = 0;
        for (int i = field.length - 1; i < field.length; i++) {
            for (int j = 1; j < field[i].length - 1; j++) {

                if (field[0][j] != 9) {

                    if (field[0][j + 1] == 9) {
                        flags++;
                    }
                    if (field[0][j - 1] == 9) {
                        flags++;
                    }
                    if (field[1][j] == 9) {
                        flags++;
                    }
                    if (field[1][j + 1] == 9) {
                        flags++;
                    }
                    if (field[1][j - 1] == 9) {
                        flags++;
                    }

                    field[0][j] = flags;
                    flags = 0;
                }

                // give value of flags for the down part of the array
                if (field[field.length - 1][j] != 9) {

                    if (field[field.length - 1][j + 1] == 9) {
                        flags++;
                    }
                    if (field[field.length - 1][j - 1] == 9) {
                        flags++;
                    }
                    if (field[field.length - 2][j] == 9) {
                        flags++;
                    }
                    if (field[field.length - 2][j + 1] == 9) {
                        flags++;
                    }
                    if (field[field.length - 2][j - 1] == 9) {
                        flags++;
                    }

                    field[field.length - 1][j] = flags;
                    flags = 0;
                }


            }

            flags = 0;
        }

        flags = 0;
        // give value of flags for the left and right side of the array
        for (int i = 1; i < field.length - 1; i++) {


            if (field[i][0] != 9) {

                if (field[i][1] == 9) {
                    flags++;
                }
                if (field[i - 1][0] == 9) {
                    flags++;
                }
                if (field[i + 1][0] == 9) {
                    flags++;
                }
                if (field[i + 1][1] == 9) {
                    flags++;
                }
                if (field[i - 1][1] == 9) {
                    flags++;
                }

                field[i][0] = flags;
                flags = 0;
            }
            flags = 0;


            if (field[i][field[i].length - 1] != 9) {

                if (field[i][field[i].length - 1] == 9) {
                    flags++;
                }
                if (field[i - 1][field[i].length - 1] == 9) {
                    flags++;
                }
                if (field[i + 1][field[i].length - 1] == 9) {
                    flags++;
                }
                if (field[i + 1][field[i].length - 2] == 9) {
                    flags++;
                }
                if (field[i - 1][field[i].length - 2] == 9) {
                    flags++;
                }

                field[i][field[i].length - 1] = flags;
                flags = 0;
            }
            flags = 0;

        }

        //catching the corners if there is a bomb is nearby
        flags = 0;
        if (field[0][0] != 9) {

            if (field[0][1] == 9) {
                flags++;
            }
            if (field[1][0] == 9) {
                flags++;
            }
            if (field[1][1] == 9) {
                flags++;
            }
            field[0][0] = flags;
        }

        flags = 0;
        if (field[0][9] != 9) {

            if (field[0][8] == 9) {
                flags++;
            }
            if (field[1][9] == 9) {
                flags++;
            }
            if (field[1][8] == 9) {
                flags++;
            }
            field[0][9] = flags;
        }
        flags = 0;
        if (field[5][9] != 9) {

            if (field[5][8] == 9) {
                flags++;
            }
            if (field[4][9] == 9) {
                flags++;
            }
            if (field[4][8] == 9) {
                flags++;
            }
            field[5][9] = flags;
        }
        flags = 0;
        if (field[5][0] != 9) {

            if (field[4][0] == 9) {
                flags++;
            }
            if (field[5][1] == 9) {
                flags++;
            }
            if (field[4][1] == 9) {
                flags++;
            }
            field[5][0] = flags;
        }

        return field;
    }






    public static int checkIfAllTheFieldsOpened(int[][] field, int b) {
        int counterForLeftBombs = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                if (field[i][j] == 0) {
                    b = 1;


                } else {
                    if (field[i][j] == 9) {
                        counterForLeftBombs++;
                    }
                    b = 2;
                }

            }

        }
        if (b == 2) {
            System.out.println("No more fields to open");
            System.out.println("There are still " + counterForLeftBombs + " unopened fields with bombs");
        }
        return b;
    }
}