package src.LInkList.Assignment;

import java.util.Scanner;

public class Library {
    static class Node {
        String title, author, genre;
        int id;
        boolean available;
        Node prev, next;

        Node(String t, String a, String g, int i, boolean v) {
            title = t;
            author = a;
            genre = g;
            id = i;
            available = v;
        }
    }

    static Node head, tail;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Genre: ");
        String genre = sc.nextLine();
        System.out.print("Available (true/false): ");
        boolean available = sc.nextBoolean();

        Node x = new Node(title, author, genre, id, available);
        if (head == null || pos == 1) {
            x.next = head;
            if (head != null) head.prev = x;
            else tail = x;
            head = x;
            return;
        }

        Node p = head;
        for (int i = 1; i < pos - 1 && p.next != null; i++) p = p.next;
        x.next = p.next;
        x.prev = p;
        if (p.next != null) p.next.prev = x;
        else tail = x;
        p.next = x;
    }

    static void remove() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();

        for (Node p = head; p != null; p = p.next) {
            if (p.id == id) {
                if (p.prev == null) head = p.next;
                else p.prev.next = p.next;

                if (p.next == null) tail = p.prev;
                else p.next.prev = p.prev;
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void search() {
        System.out.println("1 Title  2 Author");
        int c = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter value: ");
        String value = sc.nextLine();
        boolean found = false;

        for (Node p = head; p != null; p = p.next) {
            String s = c == 1 ? p.title : p.author;
            if (s.equalsIgnoreCase(value)) {
                show(p);
                found = true;
            }
        }
        if (!found) System.out.println("Not found.");
    }

    static void update() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();

        for (Node p = head; p != null; p = p.next) {
            if (p.id == id) {
                System.out.print("Available (true/false): ");
                p.available = sc.nextBoolean();
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void show(Node p) {
        System.out.println(p.id + " " + p.title + " " + p.author + " " +
                           p.genre + " " + p.available);
    }

    static void display(boolean reverse) {
        Node p = reverse ? tail : head;
        while (p != null) {
            show(p);
            p = reverse ? p.prev : p.next;
        }
    }

    static void count() {
        int n = 0;
        for (Node p = head; p != null; p = p.next) n++;
        System.out.println("Total books: " + n);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Add beginning  2 Add end  3 Add position");
            System.out.println("4 Remove  5 Search  6 Update availability");
            System.out.println("7 Forward  8 Reverse  9 Count  0 Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3: System.out.print("Position: "); add(sc.nextInt()); break;
                case 4: remove(); break;
                case 5: search(); break;
                case 6: update(); break;
                case 7: display(false); break;
                case 8: display(true); break;
                case 9: count(); break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
