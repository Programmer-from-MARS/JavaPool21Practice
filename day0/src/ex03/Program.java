package ex03;

import java.util.Scanner;

public class Program {

    static int weekNumberTracker = 1;
    static int minValue;
    static String weekInput;
    static int[] minValues = new int[18];

    static final String WEEK = "Week ";
    static final String ERROR_TXT = "IllegalArgument";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            weekInput = scanner.nextLine();
            if (weekInput.equals("")) // Этот костыль надо убрать, бесит!
                continue;
            if (weekInput.equals("42"))
            {
                PrintResults();
                break;
            }
            if (weekInput.equals(WEEK + weekNumberTracker))
            {
                minValue = 9;
                for (int i = 0; i < 5; i++)
                {
                    int n = scanner.nextInt();
                    minValue = (n < minValue) ? n : minValue;
                }
                minValues[weekNumberTracker - 1] = minValue;
                weekNumberTracker++;
            }
            else {
                ErrorTxtAndExit();
            }
        }
    }

    public static void ErrorTxtAndExit() {
        System.err.println(ERROR_TXT);
        System.exit(-1);
    }

    public static void PrintResults() {
        for (int i = 1; i < weekNumberTracker; i++)
        {
            System.out.print(WEEK + i + " ");
            for (int j = 0; j < minValues[i - 1]; j++)
                System.out.print("=");
            System.out.print(">");
            System.out.println();
        }
    }
}
