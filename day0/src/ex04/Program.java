package ex04;

import java.util.Scanner;

public class Program {
    public static final int MAX_UNICODE_VALUE = 65535;
    public static int inputLen;
    public static String input;
    public static int maxOccurrence;
    static int[][] charCount = new int[MAX_UNICODE_VALUE][1];
    public static int[][] tableToPrint = new int[12][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initialiseCharHashTable();
        while (scanner.hasNextLine())
        {
            input = scanner.nextLine();
            inputLen = input.length();
            char[] temp = input.toCharArray();
            calculateCharsOccurrence(temp);
//            System.out.println(maxOccurrence);
            if (temp[inputLen - 1] == '2' && temp[inputLen - 2] == '4')
                break;
        }
        createAndFillTableToPrint();
        printTable();
    }

    public static void initialiseCharHashTable() {
        for (int i = 0; i < MAX_UNICODE_VALUE; i++)
        {
            charCount[i] = new int[1];
            charCount[i][0] = 0;
        }

    }

    public static void calculateCharsOccurrence(char[] temp) {
        for (int i = 0; i < inputLen; i++)
        {
//            System.out.println("We are trying to add that char: " + temp[i]);
            charCount[temp[i]][0] += 1;
            maxOccurrence = (charCount[temp[i]][0] > maxOccurrence) ? charCount[temp[i]][0] : maxOccurrence;
        }
    }

    public static void printTable() {
        for (int i = 0; i < 12; i++)
        {
            System.out.print("  ");
            for (int j = 0; j < 10; j++)
            {
                if (tableToPrint[i][j] == -1)
                    System.out.print("#" + "   ");
                else if ((tableToPrint[i][j] == -2))
                    System.out.print(" " + "   ");
                else if (i == 11)
                    System.out.print((char)tableToPrint[i][j] + "   ");
                else
                    System.out.print(tableToPrint[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void createAndFillTableToPrint() {
        for (int i = 0; i < 10; i++)
        {
            tableToPrint[11][i] = (char)findNextMostFrequentLetter();
            int freq = charCount[findNextMostFrequentLetter()][0] * 10 / maxOccurrence;
//            System.out.println("letter: " + (char)tableToPrint[11][i]);
//            System.out.println("Occurrence: " + charCount[findNextMostFrequentLetter()][0]);
//            System.out.println("# count -> " + freq);
            for (int j = 0; j < 11; j++)
            {
                if (j > 10 - freq)
                    tableToPrint[j][i] = -1;
                else if (j == 10 - freq)
                    tableToPrint[10 - freq][i] = charCount[findNextMostFrequentLetter()][0];
                else
                    tableToPrint[j][i] = -2;
            }
            charCount[findNextMostFrequentLetter()][0] = 0;
        }
    }

    public static int findNextMostFrequentLetter() {
        int maxValue = 0;
        int maxIndex = 0;
        for (int i = 0; i < MAX_UNICODE_VALUE; i++)
        {
            if (charCount[i][0]  > maxValue)
            {
                maxValue = charCount[i][0];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


}
