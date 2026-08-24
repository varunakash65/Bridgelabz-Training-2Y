package Methods;

public class Reverse_Arrays {
    static void reverse(int arr[]) {
        System.out.println("Reversed Array:");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        reverse(arr);
    }
}