package CTA6;

import java.util.Comparator;

// Custom comparator for comparing Student objects based on roll number
public class RollNoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int rollno1 = s1.getRollno();
        int rollno2 = s2.getRollno();

        if (rollno1 < rollno2) {
            return -1; // s1 comes before s2
        } else if (rollno1 > rollno2) {
            return 1;  // s1 comes after s2
        } else {
            return 0;  // s1 and s2 have the same roll number
        }
    }
}
