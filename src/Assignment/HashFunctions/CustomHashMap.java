import java.util.*;

public class CustomHashMap {
    static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    CustomHashMap() {
        buckets = (LinkedList<Node>[]) new LinkedList<?>[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    int hash(int key) {
        return Math.floorMod(key, buckets.length);
    }

    void put(int key, int value) {
        LinkedList<Node> list = buckets[hash(key)];
        for (Node node : list) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        list.add(new Node(key, value));
    }

    Integer get(int key) {
        for (Node node : buckets[hash(key)]) {
            if (node.key == key) return node.value;
        }
        return null;
    }

    void remove(int key) {
        buckets[hash(key)].removeIf(node -> node.key == key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomHashMap map = new CustomHashMap();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) map.put(sc.nextInt(), sc.nextInt());
        int key = sc.nextInt();
        System.out.println(map.get(key));
        map.remove(key);
        System.out.println(map.get(key));
    }
}
