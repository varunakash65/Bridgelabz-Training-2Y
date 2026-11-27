import java.util.*;

public class QueueUsingStacks {
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    void enqueue(int x) {
        first.push(x);
    }

    Integer dequeue() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) second.push(first.pop());
        }
        if (second.isEmpty()) return null;
        return second.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks queue = new QueueUsingStacks();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) queue.enqueue(sc.nextInt());
        Integer x;
        while ((x = queue.dequeue()) != null) System.out.print(x + " ");
        System.out.println();
    }
}
