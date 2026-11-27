package src.LInkList.Assignment;

import java.util.Scanner;

public class TextEditor {
    static class Node {
        String text;
        Node prev, next;

        Node(String t) {
            text = t;
        }
    }

    static Node head, tail, current;
    static int size = 0;
    static Scanner sc = new Scanner(System.in);

    static void add(String text) {
        if (current != tail) {
            Node p = current.next;
            while (p != null) {
                Node next = p.next;
                p.prev = p.next = null;
                p = next;
                size--;
            }
            current.next = null;
            tail = current;
        }

        Node x = new Node(text);
        if (head == null) head = tail = current = x;
        else {
            x.prev = tail;
            tail.next = x;
            tail = current = x;
        }
        size++;

        if (size > 10) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    static void undo() {
        if (current != null && current.prev != null)
            current = current.prev;
    }

    static void redo() {
        if (current != null && current.next != null)
            current = current.next;
    }

    public static void main(String[] args) {
        add("");

        while (true) {
            System.out.println("\n1 Type text  2 Undo  3 Redo  4 Display  0 Exit");
            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    System.out.print("Enter text: ");
                    add(sc.nextLine());
                    break;
                case 2: undo(); break;
                case 3: redo(); break;
                case 4:
                    System.out.println(current.text);
                    break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
