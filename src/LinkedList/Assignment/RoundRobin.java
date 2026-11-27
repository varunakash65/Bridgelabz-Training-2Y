package src.LInkList.Assignment;

import java.util.Scanner;

public class RoundRobin {
    static class Node {
        int id, burst, remaining, priority;
        Node next;

        Node(int i, int b, int p) {
            id = i;
            burst = b;
            remaining = b;
            priority = p;
        }
    }

    static Node head, tail;
    static Scanner sc = new Scanner(System.in);

    static void add() {
        System.out.print("Process ID: ");
        int id = sc.nextInt();
        System.out.print("Burst time: ");
        int burst = sc.nextInt();
        System.out.print("Priority: ");
        int priority = sc.nextInt();

        Node x = new Node(id, burst, priority);
        if (head == null) {
            head = tail = x;
            x.next = x;
        } else {
            tail.next = x;
            tail = x;
            tail.next = head;
        }
    }

    static void display() {
        if (head == null) {
            System.out.println("No processes.");
            return;
        }

        Node p = head;
        do {
            System.out.println("P" + p.id + " Remaining: " + p.remaining);
            p = p.next;
        } while (p != head);
    }

    static void run() {
        if (head == null) return;

        System.out.print("Time quantum: ");
        int quantum = sc.nextInt();
        if (quantum <= 0) return;

        int n = 0;
        Node p = head;
        do {
            n++;
            p = p.next;
        } while (p != head);

        int[] id = new int[n];
        int[] burst = new int[n];
        int[] completion = new int[n];

        p = head;
        for (int i = 0; i < n; i++) {
            id[i] = p.id;
            burst[i] = p.burst;
            p = p.next;
        }

        int time = 0, left = n;

        while (left > 0) {
            Node current = head;
            int used = Math.min(quantum, current.remaining);
            current.remaining -= used;
            time += used;

            if (current.remaining == 0) {
                for (int i = 0; i < n; i++)
                    if (id[i] == current.id) completion[i] = time;

                if (head == tail) {
                    head = tail = null;
                } else {
                    head = current.next;
                    tail.next = head;
                }
                left--;
            } else {
                head = current.next;
            }

            System.out.println("Queue after turn:");
            display();
        }

        double waiting = 0, turnaround = 0;
        for (int i = 0; i < n; i++) {
            int tat = completion[i];
            int wt = tat - burst[i];
            waiting += wt;
            turnaround += tat;
            System.out.println("P" + id[i] + " Waiting: " + wt + " Turnaround: " + tat);
        }

        System.out.println("Average waiting time: " + waiting / n);
        System.out.println("Average turnaround time: " + turnaround / n);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Add process  2 Display  3 Run Round Robin  0 Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1: add(); break;
                case 2: display(); break;
                case 3: run(); break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
