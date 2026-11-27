package src.LInkList.Assignment;

import java.util.Scanner;

public class Ticket {
    static class Node {
        int id, seat;
        String customer, movie, time;
        Node next;

        Node(int i, String c, String m, int s, String t) {
            id = i;
            customer = c;
            movie = m;
            seat = s;
            time = t;
        }
    }

    static Node head, tail;
    static Scanner sc = new Scanner(System.in);

    static void add() {
        System.out.print("Ticket ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Customer: ");
        String customer = sc.nextLine();
        System.out.print("Movie: ");
        String movie = sc.nextLine();
        System.out.print("Seat number: ");
        int seat = sc.nextInt();
        sc.nextLine();
        System.out.print("Booking time: ");
        String time = sc.nextLine();

        Node x = new Node(id, customer, movie, seat, time);
        if (head == null) {
            head = tail = x;
            x.next = x;
        } else {
            tail.next = x;
            tail = x;
            tail.next = head;
        }
    }

    static void remove() {
        System.out.print("Ticket ID: ");
        int id = sc.nextInt();

        if (head == null) return;

        Node p = head, prev = tail;
        do {
            if (p.id == id) {
                if (p == head) head = p.next;
                if (p == tail) tail = prev;

                if (p == head && p == tail) {
                    head = tail = null;
                } else {
                    prev.next = p.next;
                    tail.next = head;
                }
                return;
            }
            prev = p;
            p = p.next;
        } while (p != head);

        System.out.println("Not found.");
    }

    static void display() {
        if (head == null) return;

        Node p = head;
        do {
            System.out.println(p.id + " " + p.customer + " " + p.movie +
                               " " + p.seat + " " + p.time);
            p = p.next;
        } while (p != head);
    }

    static void search() {
        System.out.println("1 Customer  2 Movie");
        int c = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String value = sc.nextLine();
        boolean found = false;

        if (head != null) {
            Node p = head;
            do {
                String s = c == 1 ? p.customer : p.movie;
                if (s.equalsIgnoreCase(value)) {
                    System.out.println(p.id + " " + p.customer + " " + p.movie);
                    found = true;
                }
                p = p.next;
            } while (p != head);
        }
        if (!found) System.out.println("Not found.");
    }

    static void count() {
        int n = 0;
        if (head != null) {
            Node p = head;
            do {
                n++;
                p = p.next;
            } while (p != head);
        }
        System.out.println("Total tickets: " + n);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Book ticket  2 Remove ticket  3 Display");
            System.out.println("4 Search  5 Count tickets  0 Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1: add(); break;
                case 2: remove(); break;
                case 3: display(); break;
                case 4: search(); break;
                case 5: count(); break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
