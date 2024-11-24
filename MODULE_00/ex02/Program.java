package ex02;
import java.util.Scanner;

public class Program {

    int getSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.floor(Math.sqrt(number)) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Program program = new Program();
        int count = 0;
        int number = scanner.nextInt();
        while (number != 42) {
            int sum = program.getSum(number);
            boolean isPrime = program.isPrime(sum);
            if (isPrime) count++;
            number = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Count of coffee-request : " + count);
    }
}