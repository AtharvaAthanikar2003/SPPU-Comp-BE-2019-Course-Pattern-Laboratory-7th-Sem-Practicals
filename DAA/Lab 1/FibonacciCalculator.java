import java.util.Scanner;
public class FibonacciCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci numbers to calculate: ");
        int n = scanner.nextInt();
        int stepsRecursion = stepCountRecursion(n);
        int stepsIteration = stepCountIteration(n);
        System.out.println("Fibonacci Recursion: " + fibonacci(n));
        System.out.println("Fibonacci Recursion Steps: " + stepsRecursion);
        System.out.println("Fibonacci Iteration: " + fibonacciIteration(n));
        System.out.println("Fibonacci Iteration Steps: " + stepsIteration);
    }
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static int fibonacciIteration(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
    public static int stepCountRecursion(int n) {
        if (n <= 1) return 1;
        return stepCountRecursion(n - 1) + stepCountRecursion(n - 2);
    }
    public static int stepCountIteration(int n) {
        int count = 0;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            count++;
        }
        return count;
    }
}
