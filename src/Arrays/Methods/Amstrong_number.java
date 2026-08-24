package Arrays.Methods;

public class Amstrong_number {
    static void checkArmstrong(int num) {
        int original = num;
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum = sum + (digit * digit * digit);
            num = num / 10;
        }
        if (sum == original) {
            System.out.println(original + " is an Armstrong Number.");
        } else {
            System.out.println(original + " is not an Armstrong Number.");
        }
    }
    public static void main(String[] args) {
        int num = 153;
        checkArmstrong(num);
    }
}
