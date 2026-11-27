import java.util.*;

public class SortStackUsingRecursion {
    static void insert(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
            return;
        }
        int top = stack.pop();
        insert(stack, x);
        stack.push(top);
    }

    static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int x = stack.pop();
        sort(stack);
        insert(stack, x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) stack.push(sc.nextInt());
        sort(stack);
        System.out.println(stack);
    }
}
