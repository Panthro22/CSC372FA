package FinalProjectAndReflection;  // Package declaration

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentDataIO {
    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {  // Use try-with-resources to automatically close the scanner
            List<Student> studentList = new LinkedList<>();  // Create a list to store student objects

            while (true) {// while as run and uses break to exit loop when user enters quit
                System.out.print("Enter student name or quit to finish: ");
                String name = scnr.nextLine().trim();

                if (name.equalsIgnoreCase("quit")) {  // Check if the user wants to quit data entry
                    break; // Exit the Student name and address loop or the whole data entry loop
                }

                // Validate street address
                String streetAddress;
                do {
                    System.out.print("Enter street address: ");
                    streetAddress = scnr.nextLine().trim();
                    if (streetAddress.isEmpty()) {
                        System.out.println("Street address cannot be empty. Please enter a valid address.");
                    }
                } while (streetAddress.isEmpty());
                // Validate city
                String city;
                do {
                    System.out.print("Enter city: ");
                    city = scnr.nextLine().trim();
                    if (city.isEmpty()) {
                        System.out.println("City cannot be empty. Please enter a valid city name.");
                    }
                } while (city.isEmpty());

                // Validate state abbreviation with exactly 2 uppercase letters
                String state;
                do {
                    System.out.print("Enter state 2-letter abbreviation: ");
                    state = scnr.nextLine().trim();
                    if (state.length() != 2 || !state.equals(state.toUpperCase())) {
                        System.out.println("Invalid state abbreviation. Please enter exactly 2 uppercase letters.");
                    }
                    } while (state.length() != 2 || !state.equals(state.toUpperCase()));


                String zipCode;
                while (true) {                                               //Zip code
                    System.out.print("Enter 5-digit zip code: ");
                    zipCode = scnr.nextLine().trim();

                    // Validate the zip code format 5 digits
                    Pattern zipPattern = Pattern.compile("^\\d{5}$");
                    Matcher zipMatcher = zipPattern.matcher(zipCode);
                    if (zipMatcher.matches()) {
                        break;// Exit the zip code loop when the zip code is valid
                    } else {
                        System.out.println("Invalid zip code. Please enter a 5-digit zip code.");//Invalid zip code
                    }
                }

                // Combine address components into a single address String
                String address = streetAddress + ", " + city + ", " + state + " " + zipCode;

                double GPA;
                while (true) {//GPA
                    System.out.print("Enter student's GPA: ");
                    String gpaInput = scnr.nextLine().trim();

                    try {// Validate GPA is a double
                        GPA = Double.parseDouble(gpaInput);
                        if (GPA < 0 || GPA > 4) {
                            throw new NumberFormatException();// Validate GPA within the range [0, 4]
                        }
                        break;// Exit the student GPA loop
                    } catch (NumberFormatException e) {//Invalid GPA
                        System.out.println("Invalid GPA. Please enter a valid GPA between 0 and 4.");
                    }
                }

                Student student = new Student(name, address, GPA);  // Create a new Student object
                studentList.add(student);  // Add the student to the list
            }

            Collections.sort(studentList);  // Sort the list of students by name

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_data.txt"))) {
                for (Student student : studentList) {
                    writer.write(student.toString());  // Write student data to the file
                    writer.newLine();  // Add a newline between student entries
                }
                System.out.println("Student data has been written to 'student_data.txt'");//Success message
            } catch (IOException e) {  //Error writing to file
                System.err.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
            scnr.close();  // Close the scanner
        } //End of try-with-resources
    }     //End of main method
}         //End of class
