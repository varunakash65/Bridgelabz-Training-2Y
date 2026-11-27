import java.util.*;

public class CircularTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        long[] balance = new long[n];
        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            balance[i] = (long) petrol - distance;
        }
        long surplus = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            queue.offer(i);
            surplus += balance[i];
            total += balance[i];
            if (surplus < 0) {
                queue.clear();
                surplus = 0;
            }
        }
        if (total < 0 || queue.isEmpty()) System.out.println(-1);
        else System.out.println(queue.peek());
    }
}
