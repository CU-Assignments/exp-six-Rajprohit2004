import java.util.*;
import java.util.stream.*;

public class Main {

    // Student class definition
    static class Student {
        private String name;
        private double marks;

        // Constructor
        public Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }

        // Getters
        public String getName() {
            return name;
        }

        public double getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', marks=" + marks + "}";
        }
    }

    // Main method to filter and sort students
    public static void main(String[] args) {
        // List of students with names and marks
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85.5));
        students.add(new Student("Bob", 72.3));
        students.add(new Student("Charlie", 90.0));
        students.add(new Student("David", 60.0));
        students.add(new Student("Eve", 77.8));

        // Using Stream to filter students scoring above 75%, sort by marks, and display their names
        System.out.println("Students scoring above 75% sorted by marks:");

        students.stream()
            .filter(student -> student.getMarks() > 75)  // Filter students who scored above 75%
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())  // Sort in descending order of marks
            .forEach(student -> System.out.println(student.getName()));  // Display names
    }
}
