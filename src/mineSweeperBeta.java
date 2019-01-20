import java.util.Date;
import java.util.Scanner;

public class mineSweeperBeta {
    public static void main(String[] args) {



        Scanner input =new Scanner(System.in);
        int a = input.nextInt();
int couter = 0;

        do {
            Date time=new Date();
            String zeroTime= time.toString();
            if(couter==0) {


            System.out.println(zeroTime.substring(14,19));

        }while (input.nextInt() !=0);
    }
}
