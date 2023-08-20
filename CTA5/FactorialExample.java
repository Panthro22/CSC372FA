package CTA5;

public class FactorialExample {
    public static int factorial(int n, int depth) {
        // Print indentation for current depth
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println("Calling factorial(" + n + ")");

        // Base case: factorial of 1 is 1
        if (n == 1) {
            // Print unindentation for returning from base case
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println("Returning 1");
            return 1;
        }

        // Recursive call: n! = n * (n-1)!
        int result = n * factorial(n - 1, depth + 1);

        // Print unindentation for returning from recursive call
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println("Returning " + result);
        return result;
    }

    public static void main(String[] args) {
        int number = 7;
        int result = factorial(number, 0);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
