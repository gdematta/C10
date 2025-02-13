import java.io.*;
import java.util.*;

public class ScoreTrakker {
    private ArrayList<Student> students;

    // Constructor
    public ScoreTrakker() {
        students = new ArrayList<>();
    }

    // Load student data from a file
    public void loadDataFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                if (!scanner.hasNextLine()) break; // Avoid error if there's a missing score
                int score = Integer.parseInt(scanner.nextLine().trim());
                students.add(new Student(name, score));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing score in file: " + fileName);
        }
    }

    // Sort and print students
    public void printInOrder() {
        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Calls methods to load and process data
    public void processFiles() {
        loadDataFile("scores.txt");
        printInOrder();
    }

    // Main method
    public static void main(String[] args) {
        ScoreTrakker tracker = new ScoreTrakker();
        tracker.processFiles();
    }
}