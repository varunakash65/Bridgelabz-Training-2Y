import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Long, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put((long) sc.nextInt(), true);
        int max = 0;
        for (long x : map.keySet()) {
            if (!map.containsKey(x - 1)) {
                int count = 1;
                long current = x;
                while (map.containsKey(current + 1)) {
                    current++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }
}
