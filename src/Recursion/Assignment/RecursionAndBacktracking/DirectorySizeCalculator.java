package src.Recursion.Assignment.RecursionAndBacktracking;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DirectorySizeCalculator {
    // Recursive directory walk; real paths prevent revisiting linked directories.
    private static long calculateSize(Path path, Set<Path> visitedDirectories) throws IOException {
        if (Files.isSymbolicLink(path)) {
            Path realPath;
            try {
                realPath = path.toRealPath();
            } catch (IOException e) {
                return 0; // Broken link or symbolic-link cycle.
            }
            if (Files.isDirectory(realPath)) {
                return calculateSize(realPath, visitedDirectories);
            }
            return Files.size(realPath);
        }

        if (Files.isDirectory(path)) {
            Path realPath = path.toRealPath();
            if (!visitedDirectories.add(realPath)) {
                return 0; // Already visited: avoids a cycle or duplicate traversal.
            }
            long total = 0;
            try (var stream = Files.list(path)) {
                for (Path child : (Iterable<Path>) stream::iterator) {
                    try {
                        total += calculateSize(child, visitedDirectories);
                    } catch (IOException e) {
                        System.out.println("Skipping unreadable item: " + child);
                    }
                }
            }
            return total;
        }
        return Files.size(path);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory or file path: ");
        Path path = Paths.get(sc.nextLine().trim());
        try {
            if (!Files.exists(path)) {
                System.out.println("Path does not exist.");
                return;
            }
            long bytes = calculateSize(path, new HashSet<>());
            System.out.println("Total size: " + bytes + " bytes");
            System.out.printf("Total size: %.2f KB%n", bytes / 1024.0);
        } catch (IOException e) {
            System.out.println("Unable to calculate size: " + e.getMessage());
        }
    }
}
