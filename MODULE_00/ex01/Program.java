package ex01;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean isPrime = true;
        int iterations = 0;
        if (number < 2) {
            System.out.println("IllegalArgument");
            System.exit(-1);
        }
        for (int i = 2; i <= Math.floor(Math.sqrt(number)) + 1; i++) {
            iterations++;
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        scanner.close();
        System.out.println((isPrime ? "true" : "false") + " " + iterations);
    }
}