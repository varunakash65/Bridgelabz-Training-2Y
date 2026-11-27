package src.LInkList.Assignment;

import java.util.Scanner;
import java.util.ArrayList;

public class Friends {
    static class User {
        int id, age;
        String name;
        ArrayList<Integer> friends = new ArrayList<>();
        User next;

        User(int i, String n, int a) {
            id = i;
            name = n;
            age = a;
        }
    }

    static User head;
    static Scanner sc = new Scanner(System.in);

    static User find(int id) {
        for (User p = head; p != null; p = p.next)
            if (p.id == id) return p;
        return null;
    }

    static void addUser() {
        System.out.print("User ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();

        User x = new User(id, name, age);
        if (head == null) head = x;
        else {
            User p = head;
            while (p.next != null) p = p.next;
            p.next = x;
        }
    }

    static void connection(boolean add) {
        System.out.print("First user ID: ");
        User a = find(sc.nextInt());
        System.out.print("Second user ID: ");
        User b = find(sc.nextInt());

        if (a == null || b == null || a == b) return;

        if (add) {
            if (!a.friends.contains(b.id)) a.friends.add(b.id);
            if (!b.friends.contains(a.id)) b.friends.add(a.id);
        } else {
            a.friends.remove(Integer.valueOf(b.id));
            b.friends.remove(Integer.valueOf(a.id));
        }
    }

    static void mutual() {
        System.out.print("First user ID: ");
        User a = find(sc.nextInt());
        System.out.print("Second user ID: ");
        User b = find(sc.nextInt());

        if (a == null || b == null) return;

        for (int id : a.friends) {
            if (b.friends.contains(id)) {
                User u = find(id);
                if (u != null) System.out.println(u.name);
            }
        }
    }

    static void displayFriends() {
        System.out.print("User ID: ");
        User u = find(sc.nextInt());

        if (u == null) return;

        for (int id : u.friends) {
            User f = find(id);
            if (f != null) System.out.println(f.id + " " + f.name);
        }
    }

    static void search() {
        System.out.println("1 ID  2 Name");
        int c = sc.nextInt();
        sc.nextLine();

        if (c == 1) {
            System.out.print("ID: ");
            User u = find(sc.nextInt());
            if (u != null) System.out.println(u.name + " " + u.age);
        } else {
            System.out.print("Name: ");
            String name = sc.nextLine();
            for (User p = head; p != null; p = p.next)
                if (p.name.equalsIgnoreCase(name))
                    System.out.println(p.id + " " + p.name + " " + p.age);
        }
    }

    static void countFriends() {
        for (User p = head; p != null; p = p.next)
            System.out.println(p.name + ": " + p.friends.size() + " friends");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Add user  2 Add friend  3 Remove friend");
            System.out.println("4 Mutual friends  5 Display friends  6 Search user  7 Count friends  0 Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1: addUser(); break;
                case 2: connection(true); break;
                case 3: connection(false); break;
                case 4: mutual(); break;
                case 5: displayFriends(); break;
                case 6: search(); break;
                case 7: countFriends(); break;
                case 0: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
