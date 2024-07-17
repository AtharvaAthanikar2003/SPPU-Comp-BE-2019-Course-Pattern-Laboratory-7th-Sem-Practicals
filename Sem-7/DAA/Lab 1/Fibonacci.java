public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void recursive(int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(fibonacci(i) + " ");
        System.out.println();
    }
    public static void iterative(int n) {
        int a1 = 0;
        int a2 = 1;
        System.out.print(a1 + " " + a2 + " ");
        for (int i = 2; i < n; i++) {
            int a3 = a2 + a1;
            a1 = a2;
            a2 = a3;
            System.out.print(a2 + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        recursive(20);
        System.out.println();
        iterative(15);
    }
}