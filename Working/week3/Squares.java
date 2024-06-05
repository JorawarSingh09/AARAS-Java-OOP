import java.util.Scanner;

public class Squares {
    public static void main(String args[]) {
        // Get an input
        Scanner s = new Scanner(System.in);
        System.out.print("Enter side lenght of the square: ");
        int side = s.nextInt();
        s.close();

        // input = 1
        // *

        // input == 3
        // ***
        // ***
        // ***

        // input == 5
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *

        // ***
        // ***
        // ***

        // ***

        for (int col = 0; col < side; col++) {
            for (int row = 0; row < side; row++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}
