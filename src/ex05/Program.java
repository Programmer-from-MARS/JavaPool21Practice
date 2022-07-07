package ex05;

import java.util.Scanner;

public class Program {

    public static int studentsCount;
    public static int classesCount;
    public static int totalClassesAmountDuringSeptember;
    public static int markedAttendanceCount;

    public static String[] studentsList;
    public static String[] columsInfo;
    public static String[][] september2020; // [][0] - число, [][1] - dayOfWeek, 30 days
    public static String[][] classesTimeDay; // [][0] - время, [][1] - день
    public static String[][] studentsAttendance; // [][0] - name, [][1] - time, [][2] - date, [][3] - Present/not

//    final String BLANK = "          ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studentsList = addStudentNames(scanner);
        september2020 = initialiseSeptember2020();
        classesTimeDay = SaveClassesTimeAndDay(scanner);
        studentsAttendance = parseStudentsAttendance(scanner);
        String tempClassesInfo = printFirstLine();
        String tempClassesInfoWithoutLastSpace = removeLastSpace(tempClassesInfo);
//        System.out.println();
//        System.out.println(totalClassesAmountDuringSeptember);
//        System.out.println(tempClassesInfoWithoutLastSpace);
        columsInfo = splitStringToSubstringsBySpace(tempClassesInfoWithoutLastSpace, totalClassesAmountDuringSeptember * 2);
        printRemainingTimetable();

    }


    public static String[] splitStringToSubstringsBySpace(String str, int word_count) {
        int len = str.length();
        String[] ret = new String[word_count];
        char[] temp = str.toCharArray();
        if (temp[0] == '.')
            return null;
        int j = 0;
        ret[j] = "";
        for (int i = 0; i < len; i++)
        {
            if (temp[i] != ' ')
                ret[j] += temp[i];
            else
            {
                j++;
                ret[j] = "";
            }
        }return ret;
    }

    public static String[] addStudentNames(Scanner scanner)
    {
        String[] studentsList = new String[11];
        for (int i = 0; scanner.hasNextLine() && i < 11; i++)
        {
            studentsList[i] = scanner.nextLine();
            if (studentsList[i].equals("."))
            {
                studentsList[i] = null;
                break;
            }
            studentsCount++;
        }
        return studentsList;
    }

    public static String[][] initialiseSeptember2020() {
        String[][] september = new String[30][];
        String[] weekDays = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        for (int i = 1; i < 31; i++)
        {
            september[i - 1] = new String[2];
            september[i - 1][0] = String.valueOf(i);
            september[i - 1][1] = weekDays[i % 7];
//          System.out.println(september2020[i - 1][0] + " " + september2020[i - 1][1]);
        }
        return september;
    }

    public static String[][] SaveClassesTimeAndDay(Scanner scanner) {
        String[][] classes = new String[10][];
        for (int i = 0; scanner.hasNextLine() && i < 11; i++)
        {
            classes[i] = new String[2];
            String[] temp = Program.splitStringToSubstringsBySpace(scanner.nextLine(), 2);
            if (temp == null)
                break;
            classes[i][0] = temp[0];
            classes[i][1] = temp[1];
            classesCount++;
//            System.out.println(classes[i][0] + " " + classes[i][1]);
        }
        return classes;
    }

    public static String printFirstLine() {
        System.out.print("          ");
        String temp = "";
        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < classesCount; j++)
            {
                if (classesTimeDay[j][1].equals(september2020[i][1]))
                {
                    System.out.print(classesTimeDay[j][0] + ":00 " + september2020[i][1]);
                    System.out.print((september2020[i][0].length() == 2) ? " " : "  ");
                    System.out.print(september2020[i][0] + "|");
                    totalClassesAmountDuringSeptember++;
                    temp += classesTimeDay[j][0] + " " + september2020[i][0] + " ";
                }
            }
        }
        System.out.println();
        return temp;
    }

    public static String removeLastSpace(String tempClassesInfo) {
        int len = tempClassesInfo.length();
        char[] del = tempClassesInfo.toCharArray();
        String str = "";
        for (int i = 0; i < len - 1; i++)
            str += del[i];
        return str;
    }

    public static String[][] parseStudentsAttendance(Scanner scanner)
    {
        String[][] studentsAttendance = new String[10 * 5 * 10][]; // 10 students, 5 weeks, 10 classes a weak
        for (int i = 0; scanner.hasNextLine() && i < 10 * 10 * 5; i++)
        {
            studentsAttendance[i] = new String[4];
            String[] temp = Program.splitStringToSubstringsBySpace(scanner.nextLine(), 4);
            if (temp == null)
                break;
            markedAttendanceCount++;
            studentsAttendance[i][0] = temp[0];
            studentsAttendance[i][1] = temp[1];
            studentsAttendance[i][2] = temp[2];
            studentsAttendance[i][3] = temp[3];
        }
        return studentsAttendance;
    }

    public static void printRemainingTimetable() {
        for (int i = 0; i < studentsCount; i++)
        {
            printStudentName(studentsList[i]);
            for (int j = 0; j < totalClassesAmountDuringSeptember; j++)
            {
                System.out.print("        ");
                System.out.print(decideHowToMarkAttendance(studentsList[i], j));
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static String decideHowToMarkAttendance(String name, int columnIndex) {
        for (int i = 0; i < markedAttendanceCount; i++)
        {
            if (name.equals(studentsAttendance[i][0]))
            {
                if (columsInfo[columnIndex * 2].equals(studentsAttendance[i][1]) && columsInfo[columnIndex * 2 + 1].equals(studentsAttendance[i][2]))
                {
                    if (studentsAttendance[i][3].equals("HERE"))
                        return " 1";
                    else if (studentsAttendance[i][3].equals("NOT_HERE"))
                        return "-1";
                }
            }
        }
        return "  ";
    }

    public static void printStudentName(String name) {
        for (int i = 0; i < 10 - name.length(); i++)
            System.out.print(" ");
        System.out.print(name);
    }
}