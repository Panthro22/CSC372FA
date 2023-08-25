package CTA6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    // Main merge sort method
    public static void mergeSort(List<Student> students, Comparator<Student> comparator) {
        // Base case: If the list has 1 or fewer elements, it's already sorted
        if (students == null || students.size() <= 1) {
            return;
        }

        try {
            // Split the list into two halves
            int middle = students.size() / 2;
            List<Student> left = new ArrayList<>(students.subList(0, middle));
            List<Student> right = new ArrayList<>(students.subList(middle, students.size()));

            // Recursively sort the two halves
            mergeSort(left, comparator);
            mergeSort(right, comparator);

            // Merge the sorted halves back together
            merge(students, left, right, comparator);
        } catch (Exception e) {
            System.err.println("An error occurred during merge sort: " + e.getMessage());
        }
    }

    // Merge two sorted lists
    private static void merge(List<Student> students, List<Student> left, List<Student> right, Comparator<Student> comparator) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        try {
            // Compare and merge elements from the left and right lists
            while (leftIndex < left.size() && rightIndex < right.size()) {
                if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
                    students.set(mergedIndex++, left.get(leftIndex++));
                } else {
                    students.set(mergedIndex++, right.get(rightIndex++));
                }
            }

            // Copy any remaining elements from the left list
            while (leftIndex < left.size()) {
                students.set(mergedIndex++, left.get(leftIndex++));
            }

            // Copy any remaining elements from the right list
            while (rightIndex < right.size()) {
                students.set(mergedIndex++, right.get(rightIndex++));
            }
        } catch (Exception e) {
            System.err.println("An error occurred during merging: " + e.getMessage());
        }
    }
}
