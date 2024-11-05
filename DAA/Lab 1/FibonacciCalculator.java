import java.util.Scanner;
public class FibonacciCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci numbers to calculate: ");
        int n = scanner.nextInt();
        int stepsRecursion = stepCountRecursion(n);
        System.out.println("Fibonacci Recursion: " + fibonacci(n));
        System.out.println("Fibonacci Recursion Steps: " + stepsRecursion);
        System.out.println("Fibonacci Series (Recursion): ");
        printFibonacciSeriesRecursion(n);
        int stepsIteration = stepCountIteration(n);
        System.out.println("Fibonacci Iteration: " + fibonacciIteration(n));
        System.out.println("Fibonacci Iteration Steps: " + stepsIteration);
        System.out.println("Fibonacci Series (Iteration): ");
        printFibonacciSeriesIteration(n);
    }
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static int stepCountRecursion(int n) {
        if (n <= 1) return 1;
        return stepCountRecursion(n - 1) + stepCountRecursion(n - 2);
    }
    public static void printFibonacciSeriesRecursion(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
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
    public static void printFibonacciSeriesIteration(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int i = 0; i <= n; i++) {
            System.out.print(fib[i] + " ");
        }
        System.out.println();
    }
}

/*
Enter the number of Fibonacci numbers to calculate: 10
Fibonacci Recursion: 55
Fibonacci Recursion Steps: 89
Fibonacci Series (Recursion): 
0 1 1 2 3 5 8 13 21 34 55 
Fibonacci Iteration: 55
Fibonacci Iteration Steps: 9
Fibonacci Series (Iteration): 
0 1 1 2 3 5 8 13 21 34 55
*/    
