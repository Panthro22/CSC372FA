package CTA5;

import java.util.Scanner;

public class RecursiveProductCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter five positive integers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = getValidPositiveNumber(scanner, "Enter number " + (i + 1) + ": ");
        }
        
        int product = calculateProduct(numbers, 0);
        System.out.println("Product of the five numbers: " + product);
    }
    
    // Recursive method to calculate the product of numbers in an array
    public static int calculateProduct(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index]; // Base case: return the last number
        } else {
            // Recursively calculate the product of the remaining numbers
            return numbers[index] * calculateProduct(numbers, index + 1);
        }
    }
    
    // Custom method to read valid positive integers from the user
    public static int getValidPositiveNumber(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    break; // Exit the loop if a positive number is entered
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid positive integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        return number; // Return the valid positive number
    }
}
