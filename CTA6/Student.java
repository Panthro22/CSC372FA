package CTA6;  

// Class representing a student with roll number, name, and address
public class Student {
    private int rollno;        // Student's roll number
    private String name;       
    private String address;    

    // Constructor to initialize student attributes
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;      // Initialize roll number,
        this.name = name;          // Initialize name,
        this.address = address;    // Initialize address
    }

    // Getter method for retrieving roll number
    public int getRollno() {
        return rollno;
    }

    // Getter method for retrieving name
    public String getName() {
        return name;
    }

    // Getter method for retrieving address
    public String getAddress() {
        return address;
    }
}
