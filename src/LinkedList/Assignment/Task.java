package src.LInkList.Assignment;

import java.util.Scanner;

public class Task {
    static class Node {
        int id, priority;
        String name, date;
        Node next;

        Node(int i, String n, int p, String d) {
            id = i;
            name = n;
            priority = p;
            date = d;
        }
    }

    static Node head, tail, current;
    static Scanner sc = new Scanner(System.in);

    static int size() {
        if (head == null) return 0;
        int n = 0;
        Node p = head;
        do {
            n++;
            p = p.next;
        } while (p != head);
        return n;
    }

    static void add(int pos) {
        System.out.print("Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Task name: ");
        String name = sc.nextLine();
        System.out.print("Priority: ");
        int priority = sc.nextInt();
        sc.nextLine();
        System.out.print("Due date: ");
        String date = sc.nextLine();

        Node x = new Node(id, name, priority, date);
        if (head == null) {
            head = tail = current = x;
            x.next = x;
        } else if (pos == 1) {
            x.next = head;
            head = x;
            tail.next = head;
        } else if (pos > size()) {
            tail.next = x;
            tail = x;
            tail.next = head;
        } else {
            Node p = head;
            for (int i = 1; i < pos - 1; i++) p = p.next;
            x.next = p.next;
            p.next = x;
        }
    }

    static void remove() {
        System.out.print("Task ID: ");
        int id = sc.nextInt();

        if (head == null) return;

        Node p = head, prev = tail;
        do {
            if (p.id == id) {
                if (p == head) head = p.next;
                if (p == tail) tail = prev;

                if (p == head && p == tail) {
                    head = tail = current = null;
                } else {
                    prev.next = p.next;
                    if (current == p) current = p.next;
                    tail.next = head;
                }
                return;
            }
            prev = p;
            p = p.next;
        } while (p != head);

        System.out.println("Not found.");
    }

    static void nextTask() {
        if (current == null) {
            System.out.println("No tasks.");
            return;
        }
        System.out.println("Current: " + current.name);
        current = current.next;
        System.out.println("Next: " + current.name);
    }

    static void display() {
        if (head == null) return;
        Node p = head;
        do {
            System.out.println(p.id + " " + p.name + " " + p.priority + " " + p.date);
            p = p.next;
        } while (p != head);
    }

    static void search() {
        System.out.print("Priority: ");
        int priority = sc.nextInt();
        boolean found = false;

        if (head != null) {
            Node p = head;
            do {
                if (p.priority == priority) {
                    System.out.println(p.id + " " + p.name + " " + p.date);
                    found = true;
                }
                p = p.next;
            } while (p != head);
        }
        if (!found) System.out.println("Not found.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Add beginning  2 Add end  3 Add position");
            System.out.println("4 Remove  5 Current/Next  6 Display  7 Search priority  0 Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3: System.out.print("Position: "); add(sc.nextInt()); break;
                case 4: remove(); break;
                case 5: nextTask(); break;
                case 6: display(); break;
                case 7: search(); break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
