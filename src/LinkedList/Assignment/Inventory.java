package src.LInkList.Assignment;

import java.util.Scanner;

public class Inventory {
    static class Node {
        String name;
        int id, quantity;
        double price;
        Node next;

        Node(String n, int i, int q, double p) {
            name = n;
            id = i;
            quantity = q;
            price = p;
        }
    }

    static Node head;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Item ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Item name: ");
        String name = sc.nextLine();
        System.out.print("Quantity: ");
        int q = sc.nextInt();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        Node x = new Node(name, id, q, price);
        if (head == null || pos == 1) {
            x.next = head;
            head = x;
            return;
        }

        Node p = head;
        for (int i = 1; i < pos - 1 && p.next != null; i++) p = p.next;
        x.next = p.next;
        p.next = x;
    }

    static void remove() {
        System.out.print("Item ID: ");
        int id = sc.nextInt();

        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }

        Node p = head;
        while (p.next != null && p.next.id != id) p = p.next;
        if (p.next != null) p.next = p.next.next;
    }

    static void update() {
        System.out.print("Item ID: ");
        int id = sc.nextInt();

        for (Node p = head; p != null; p = p.next) {
            if (p.id == id) {
                System.out.print("New quantity: ");
                p.quantity = sc.nextInt();
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void search() {
        System.out.println("1 ID  2 Name");
        int c = sc.nextInt();
        sc.nextLine();
        boolean found = false;

        if (c == 1) {
            System.out.print("Item ID: ");
            int id = sc.nextInt();
            for (Node p = head; p != null; p = p.next) {
                if (p.id == id) {
                    show(p);
                    found = true;
                }
            }
        } else {
            System.out.print("Item name: ");
            String name = sc.nextLine();
            for (Node p = head; p != null; p = p.next) {
                if (p.name.equalsIgnoreCase(name)) {
                    show(p);
                    found = true;
                }
            }
        }
        if (!found) System.out.println("Not found.");
    }

    static void show(Node p) {
        System.out.println(p.name + " " + p.id + " Qty:" + p.quantity + " Price:" + p.price);
    }

    static void display() {
        for (Node p = head; p != null; p = p.next) show(p);
    }

    static void total() {
        double sum = 0;
        for (Node p = head; p != null; p = p.next)
            sum += p.quantity * p.price;
        System.out.println("Total value: " + sum);
    }

    static void sort() {
        System.out.println("1 Name  2 Price");
        int field = sc.nextInt();
        System.out.println("1 Ascending  2 Descending");
        boolean desc = sc.nextInt() == 2;

        for (Node a = head; a != null; a = a.next) {
            for (Node b = a.next; b != null; b = b.next) {
                int cmp = field == 1
                    ? a.name.compareToIgnoreCase(b.name)
                    : Double.compare(a.price, b.price);

                if ((!desc && cmp > 0) || (desc && cmp < 0)) {
                    String name = a.name; a.name = b.name; b.name = name;
                    int id = a.id; a.id = b.id; b.id = id;
                    int q = a.quantity; a.quantity = b.quantity; b.quantity = q;
                    double price = a.price; a.price = b.price; b.price = price;
                }
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Add beginning  2 Add end  3 Add position");
            System.out.println("4 Remove  5 Update quantity  6 Search  7 Display");
            System.out.println("8 Total value  9 Sort  0 Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3: System.out.print("Position: "); add(sc.nextInt()); break;
                case 4: remove(); break;
                case 5: update(); break;
                case 6: search(); break;
                case 7: display(); break;
                case 8: total(); break;
                case 9: sort(); break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
