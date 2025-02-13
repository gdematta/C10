public class Student implements Comparable<Student> {
    private String name;
    private int score;

    // Constructor
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Compare students based on score
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score);
    }

    // String representation of a student
    @Override
    public String toString() {
        return name + ", " + score;
    }
}
