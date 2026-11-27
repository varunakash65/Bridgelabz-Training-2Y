import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        map.put(0L, new ArrayList<>());
        map.get(0L).add(-1);
        long sum = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (map.containsKey(sum)) {
                for (int index : map.get(sum)) {
                    System.out.println("[" + (index + 1) + ", " + i + "]");
                    found = true;
                }
            } else {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }
        if (!found) System.out.println("No zero sum subarray");
    }
}
