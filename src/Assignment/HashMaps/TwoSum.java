import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int target = sc.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long need = (long) target - a[i];
            if (map.containsKey(need)) {
                System.out.println("[" + map.get(need) + ", " + i + "]");
                return;
            }
            map.put((long) a[i], i);
        }
        System.out.println("No pair found");
    }
}
