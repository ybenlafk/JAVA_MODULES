package ex03;
import java.util.Scanner;

public class Program {
    private static long gradesStorage = 0;
    private static final int BASE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weeks = 0;
        
        try {
            String input;
            while (weeks < 18 && scanner.hasNext()) {
                input = scanner.nextLine();
                if (input.equals("42")) break;
                
                if (!input.equals("Week " + (weeks + 1))) exitWithError();
                
                int min = findMinGrade(scanner);
                gradesStorage = gradesStorage * BASE + min;
                weeks++;
            }
            gradesStorage = reverseNumber((int)gradesStorage);
            for (int week = 1; week <= weeks; week++) {
                int grade = (int)(gradesStorage % BASE);
                printGrade(grade, week);
                gradesStorage /= BASE;
            }
            
        } catch (Exception e) {
            exitWithError();
        }
        scanner.close();
    }
    
    private static void exitWithError() {
        System.err.println("IllegalArgument");
        System.exit(-1);
    }
    
    private static int findMinGrade(Scanner scanner) {
        int minimum = 9;
        int count = 0;
        
        while (count < 5 && scanner.hasNextInt()) {
            int grade = scanner.nextInt();
            if (grade < 1 || grade > 9) exitWithError();
            if (grade < minimum) minimum = grade;
            count++;
        }
        
        if (count != 5) exitWithError();
        scanner.nextLine();
        return minimum;
    }
    
    private static void printGrade(int grade, int weekNum) {
        System.out.print("Week " + weekNum + " ");
        while (grade-- > 0) System.out.print("=");
        System.out.println(">");
    }

    private static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            reversed = reversed * BASE + number % BASE;
            number /= BASE;
        }
        return reversed;
    }
}