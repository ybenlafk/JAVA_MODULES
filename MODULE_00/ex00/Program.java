package ex00;

public class Program {
    public static void main(String[] args) {
        int number = 11122;
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println(sum);
    }
}