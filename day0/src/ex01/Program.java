package ex01;

import java.util.Scanner;

public class Program {
    static int userInput;
    static final String ERROR_TXT = "IllegalArgument";
    static int stepsTaken;
    static boolean prime = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextInt();
        checkThatInputIsValid();
        checkNumberForBeingPrime();
        System.out.println(prime + " " + stepsTaken);

    }

    public static void checkThatInputIsValid() {
        if (userInput <= 1)
        {
            System.err.println(ERROR_TXT);
            System.exit(-1);
        }
    }

    public static void checkNumberForBeingPrime () {
        for (int i = 2; i * i < userInput; i++)
        {
            stepsTaken++;
            if (userInput % i == 0)
            {
                prime = false;
                break;
            }
        }
    }
}