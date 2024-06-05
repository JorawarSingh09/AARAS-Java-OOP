import java.util.Scanner;

public class Week2 {
    public static void main(String args[]) {
        // Condition and loops
        /*
         * IF(SOMETHING){
         * DO THIS
         * }
         * ELSE IF (something else){
         * do this
         * }
         * Else{
         * Do this}
         */

        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int mynum = 1234;

        if (mynum <= 1233) {
            System.out.println("greater than");
        }

        /*
         * + Plus,
         * - minus,
         * / Divide,
         * * Multiply,
         * % modulo, dividend % Divisor -> remainder
         * dividend / Divisor -> quotient
         * ^ exponent 3^2 == 3*3 == 9
         */

        // System.out.println(3 < 2);

        // Get an input number
        // if that number is less than 23, print "number too small",
        // else if that number is divisable by 23, print "divisable"
        // else, "not divisable"

        Scanner s = new Scanner(System.in);
        // System.out.println("input something: ");
        System.out.print("give me a number: ");
        int input = s.nextInt();
        s.close();
        
        if(input < 23){
            System.out.println("number is not higher than 23");
        }
        else if(input % 23 == 0){
            System.out.println("Is divisable by 23");
        }
        else{
            System.out.println("not divisable by 23");
        }
    }
}