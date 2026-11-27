package src.LInkList.Assignment;

import java.util.Scanner;

public class Movie {
    static class Node {
        String title, director;
        int year;
        double rating;
        Node prev, next;

        Node(String t, String d, int y, double r) {
            title = t;
            director = d;
            year = y;
            rating = r;
        }
    }

    static Node head, tail;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        sc.nextLine();
        System.out.print("Title: ");
        String t = sc.nextLine();
        System.out.print("Director: ");
        String d = sc.nextLine();
        System.out.print("Year: ");
        int y = sc.nextInt();
        System.out.print("Rating: ");
        double r = sc.nextDouble();

        Node x = new Node(t, d, y, r);
        if (head == null || pos == 1) {
            x.next = head;
            if (head != null) head.prev = x;
            else tail = x;
            head = x;
            return;
        }

        Node p = head;
        for (int i = 1; i < pos - 1 && p.next != null; i++)
            p = p.next;

        x.next = p.next;
        x.prev = p;
        if (p.next != null) p.next.prev = x;
        else tail = x;
        p.next = x;
    }

    static void remove() {
        sc.nextLine();
        System.out.print("Title: ");
        String t = sc.nextLine();

        for (Node p = head; p != null; p = p.next) {
            if (p.title.equalsIgnoreCase(t)) {
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
        System.out.println("1 Director  2 Rating");
        int c = sc.nextInt();
        boolean found = false;

        if (c == 1) {
            sc.nextLine();
            System.out.print("Director: ");
            String d = sc.nextLine();
            for (Node p = head; p != null; p = p.next) {
                if (p.director.equalsIgnoreCase(d)) {
                    show(p);
                    found = true;
                }
            }
        } else {
            System.out.print("Rating: ");
            double r = sc.nextDouble();
            for (Node p = head; p != null; p = p.next) {
                if (p.rating == r) {
                    show(p);
                    found = true;
                }
            }
        }
        if (!found) System.out.println("Not found.");
    }

    static void show(Node p) {
        System.out.println(p.title + " | " + p.director + " | " + p.year + " | " + p.rating);
    }

    static void display(boolean reverse) {
        Node p = reverse ? tail : head;
        while (p != null) {
            show(p);
            p = reverse ? p.prev : p.next;
        }
    }

    static void update() {
        sc.nextLine();
        System.out.print("Title: ");
        String t = sc.nextLine();

        for (Node p = head; p != null; p = p.next) {
            if (p.title.equalsIgnoreCase(t)) {
                System.out.print("New rating: ");
                p.rating = sc.nextDouble();
                return;
            }
        }
        System.out.println("Not found.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Add beginning  2 Add end  3 Add position");
            System.out.println("4 Remove  5 Search  6 Forward  7 Reverse  8 Update rating  0 Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3: System.out.print("Position: "); add(sc.nextInt()); break;
                case 4: remove(); break;
                case 5: search(); break;
                case 6: display(false); break;
                case 7: display(true); break;
                case 8: update(); break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
