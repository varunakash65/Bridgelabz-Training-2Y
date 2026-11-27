import java.util.*;

public class PairWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int target = sc.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        for (int x : a) {
            if (map.containsKey((long) target - x)) {
                System.out.println(true);
                return;
            }
            map.put((long) x, 1);
        }
        System.out.println(false);
    }
}
