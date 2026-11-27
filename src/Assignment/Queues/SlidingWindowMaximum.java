import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int k = sc.nextInt();
        if (k <= 0 || k > n) {
            System.out.println("Invalid window size");
            return;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = a[dq.peekFirst()];
        }
        System.out.println(Arrays.toString(result));
    }
}
