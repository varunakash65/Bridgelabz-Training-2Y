package src.LInkList.Assignment;

import java.util.Scanner;

public class Student {
    static class Node {
        int roll, age;
        String name, grade;
        Node next;

        Node(int r, String n, int a, String g) {
            roll = r;
            name = n;
            age = a;
            grade = g;
        }
    }

    static Node head;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Roll: ");
        int r = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String n = sc.nextLine();
        System.out.print("Age: ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.print("Grade: ");
        String g = sc.nextLine();

        Node x = new Node(r, n, a, g);
        if (head == null || pos == 1) {
            x.next = head;
            head = x;
            return;
        }

        Node p = head;
        for (int i = 1; i < pos - 1 && p.next != null; i++)
            p = p.next;

        x.next = p.next;
        p.next = x;
    }

    static void delete() {
        System.out.print("Roll: ");
        int r = sc.nextInt();

        if (head == null) return;
        if (head.roll == r) {
            head = head.next;
            return;
        }

        Node p = head;
        while (p.next != null && p.next.roll != r)
            p = p.next;

        if (p.next != null)
            p.next = p.next.next;
    }

    static void search() {
        System.out.print("Roll: ");
        int r = sc.nextInt();

        for (Node p = head; p != null; p = p.next) {
            if (p.roll == r) {
                show(p);
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void update() {
        System.out.print("Roll: ");
        int r = sc.nextInt();
        sc.nextLine();

        for (Node p = head; p != null; p = p.next) {
            if (p.roll == r) {
                System.out.print("New grade: ");
                p.grade = sc.nextLine();
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void show(Node p) {
        System.out.println(p.roll + " " + p.name + " " + p.age + " " + p.grade);
    }

    static void display() {
        for (Node p = head; p != null; p = p.next)
            show(p);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Add beginning  2 Add end  3 Add position");
            System.out.println("4 Delete  5 Search  6 Display  7 Update grade  0 Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3: System.out.print("Position: "); add(sc.nextInt()); break;
                case 4: delete(); break;
                case 5: search(); break;
                case 6: display(); break;
                case 7: update(); break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
