package ex02;

import java.util.Scanner;

public class Program {

    static int userInput;
    static boolean prime = true;
    static int sumOfDigits;
    static int primeNumbersAmount;
    static final String ERROR_TXT = "IllegalArgument";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt())
        {
            userInput = scanner.nextInt();
            if (userInput == 42)
            {
                System.out.println("Count of coffee-request - " +  primeNumbersAmount);
                System.exit(0);
            }
//            checkThatInputIsValid();
//            System.out.println(userInput);
            calculateTheSumOfTheDigits();
//            System.out.println(sumOfDigits);
            checkNumberForBeingPrime();
            if (prime)
                primeNumbersAmount++;
//            System.out.println(primeNumbersAmount);
            prime = true;
            sumOfDigits = 0;
        }
    }

//    public static void checkThatInputIsValid() {
//        if (userInput <= 0)
//        {
//            System.err.println(ERROR_TXT);
//            System.exit(-1);
//            calculateTheSumOfTheDigits();
//        }
//    }

    public static void calculateTheSumOfTheDigits() {
        while (userInput > 0)
        {
            sumOfDigits += userInput % 10;
//            System.out.println(sumOfDigits);
            userInput /= 10;
        }
    }

    public static void checkNumberForBeingPrime () {
        for (int i = 2; i * i < sumOfDigits; i++)
        {
            if (sumOfDigits % i == 0)
            {
                prime = false;
                break;
            }
        }
    }
}
