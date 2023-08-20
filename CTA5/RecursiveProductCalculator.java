package CTA5;

import java.util.Scanner;

public class RecursiveProductCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter five numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = getValidNumber(scanner, "Enter number " + (i + 1) + ": ");
        }
        
        int product = calculateProduct(numbers, 0);
        System.out.println("Product of the five numbers: " + product);
    }
    
    public static int calculateProduct(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index];
        } else {
            return numbers[index] * calculateProduct(numbers, index + 1);
        }
    }
    
    public static int getValidNumber(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        return number;
    }
}
