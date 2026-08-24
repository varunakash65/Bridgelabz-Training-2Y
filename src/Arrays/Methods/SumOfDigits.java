package Methods;

public class SumOfDigits {
    static void sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum = sum + digit;
            num = num / 10;
        }System.out.println("Sum of digits = " + sum);
    }public static void main(String[] args) {
        sumDigits(12345);}
}