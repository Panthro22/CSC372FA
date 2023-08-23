package CTA6;  // Package name indicating the location of the class

import java.util.Comparator;

// Custom comparator for comparing Student objects based on roll number
public class RollNoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Compare the roll numbers of two Student objects
        // and return the result of the comparison
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}

