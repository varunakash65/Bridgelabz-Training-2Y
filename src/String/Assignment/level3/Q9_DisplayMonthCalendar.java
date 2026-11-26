package src.String.Assignment.level3;

import java.util.Scanner;

public class Q9_DisplayMonthCalendar {
    private static final String[] MONTHS = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static String getMonthName(int month) {
        return MONTHS[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static int getNumberOfDays(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        return DAYS[month - 1];
    }

    // Returns 0 for Sunday, 1 for Monday, ..., 6 for Saturday.
    public static int getFirstDayOfMonth(int month, int year) {
        int day = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (day + x + 31 * m0 / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        int firstDay = getFirstDayOfMonth(month, year);
        int numberOfDays = getNumberOfDays(month, year);
        System.out.println("\n      " + getMonthName(month) + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < firstDay; i++) System.out.print("    ");
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%4d", day);
            if ((firstDay + day) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        if (month < 1 || month > 12 || year < 1) {
            System.out.println("Invalid month or year.");
        } else {
            displayCalendar(month, year);
        }
        sc.close();
    }
}
