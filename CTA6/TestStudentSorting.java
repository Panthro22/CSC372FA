package CTA6;

import java.util.ArrayList;
import java.util.List;

public class TestStudentSorting {
    public static void main(String[] args) {
        // Create a list of student objects in reverse order
        List<Student> students = new ArrayList<>();
        students.add(new Student(10, "Alice", "123 Main St"));
        students.add(new Student(9, "Bob", "456 Elm St"));
        students.add(new Student(8, "Charlie", "789 Oak St"));
        students.add(new Student(7, "David", "321 Maple Ave"));
        students.add(new Student(6, "Eve", "555 Pine Rd"));
        students.add(new Student(5, "Frank", "987 Cedar Ln"));
        students.add(new Student(4, "Grace", "654 Birch Blvd"));
        students.add(new Student(3, "Helen", "876 Walnut Dr"));
        students.add(new Student(2, "Ivan", "234 Cherry Rd"));
        students.add(new Student(1, "Julia", "432 Orange Ave"));

        // Measure start time
        long startTime = System.nanoTime();

        // Sort the list of students based on roll number using RollNoComparator
        RollNoComparator rollNoComparator = new RollNoComparator();
        MergeSort.mergeSort(students, rollNoComparator);

        // Measure end time
        long endTime = System.nanoTime();

        // Calculate elapsed time in milliseconds with tenths precision
        double elapsedTimeMs = (endTime - startTime) / 1e6;

        // Display sorted students
        System.out.println("Sorted Students (Worst Case):");
        for (Student student : students) {
            System.out.println("Roll No: " + student.getRollno() + ", Name: " + student.getName() + ", Address: " + student.getAddress());
        }

        // Display elapsed time with tenths precision
        System.out.printf("Elapsed Time: %.3f ms%n", elapsedTimeMs);
    }
}
