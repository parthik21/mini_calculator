import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.io.*;


public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public static void main(String[] args) throws IOException {
        Calculations calculations = new Calculations();

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double result,num1,num2;
        long factorial,fact_input;
        char next = 'y';
        while (next == 'y') {
            System.out.println("----------Mini Calculator---------");
            System.out.print("Enter what would you like to do\n1.Square Root\n2.Factorial\n3.Natural Logarithm\n4.Power Function\nEnter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the number: ");
                    num1 = sc.nextDouble();
                    if (num1 < 0) {
                        logger.error("Number entered to get square root is negative!");
                    } else {
                        result = calculations.squareRoot(num1);
                        System.out.println("The square root is: " + Double.toString(result));
                        logger.info("The square root of " + Double.toString(num1) + " is: " + Double.toString(result));
                    }
                    break;
                case 2:
                    System.out.print("Enter the number: ");
                    fact_input = sc.nextLong();
                    if (fact_input < 0) {
                        logger.error("Factorial of a negative number cannot be found!");
                    } else {
                        factorial = calculations.factorial(fact_input);
                        System.out.println("The factorial is: " + Long.toString(factorial));
                        logger.info("The factorial of" + Long.toString(fact_input) + " is: " + Long.toString(factorial));
                    }
                    break;
                case 3:
                    System.out.print("Enter the number: ");
                    num1 = sc.nextDouble();
                    if (num1 < 0) {
                        logger.error("Input to find Nautral Log is Negative!");
                    } else {
                        result = calculations.naturalLog(num1);
                        System.out.println("The natural log is: " + Double.toString(result));
                        logger.info("The natural log of" + Double.toString(num1) + " is: " + Double.toString(result));
                    }
                    break;
                case 4:
                    System.out.print("Enter the number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter the power: ");
                    num2 = sc.nextDouble();
                    result = calculations.powerFunction(num1, num2);
                    System.out.println("The power function value is: " + Double.toString(result));
                    break;
                default:
                    System.out.println("Inappropriate value chosen");
            }
            System.out.print("Enter a 'y' if you want to continue : ");
            next = sc.next().charAt(0);
        }
    }
}
