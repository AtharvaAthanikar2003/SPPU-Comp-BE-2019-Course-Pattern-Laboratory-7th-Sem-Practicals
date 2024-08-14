import java.util.*;
public class MatrixMultiplication {
    public static int[][] matrixMultiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int p = B[0].length;
        int[][] result = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    public static int[][] matrixMultiplyRow(int[][] A, int[][] B) throws InterruptedException {
        int m = A.length;
        int n = B.length;
        int p = B[0].length;
        int[][] result = new int[m][p];
        Runnable[] tasks = new Runnable[m];
        for (int i = 0; i < m; i++) {
            final int rowIndex = i;
            tasks[i] = () -> {
                for (int j = 0; j < p; j++) {
                    for (int k = 0; k < n; k++) {
                        result[rowIndex][j] += A[rowIndex][k] * B[k][j];
                    }
                }
            };
        }
        ExecutorService executor = Executors.newFixedThreadPool(m);
        for (Runnable task : tasks) {
            executor.submit(task);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
        return result;
    }
    public static int[][] matrixMultiplyCell(int[][] A, int[][] B) throws InterruptedException {
        int m = A.length;
        int n = B.length;
        int p = B[0].length;
        int[][] result = new int[m][p];
        Runnable[] tasks = new Runnable[m * p];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                final int rowIndex = i;
                final int colIndex = j;
                tasks[index++] = () -> {
                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        sum += A[rowIndex][k] * B[k][colIndex];
                    }
                    result[rowIndex][colIndex] = sum;
                };
            }
        }
        ExecutorService executor = Executors.newFixedThreadPool(m * p);
        for (Runnable task : tasks) {
            executor.submit(task);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Single-threaded matrix multiplication");
            System.out.println("2. Multithreaded (one thread per row)");
            System.out.println("3. Multithreaded (one thread per cell)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            if (option == 4) {
                break;
            }
            System.out.print("Enter number of rows for Matrix A: ");
            int m = scanner.nextInt();
            System.out.print("Enter number of columns for Matrix A (and rows for Matrix B): ");
            int n = scanner.nextInt();
            System.out.print("Enter number of columns for Matrix B: ");
            int p = scanner.nextInt();
            int[][] A = new int[m][n];
            System.out.println("Enter matrix A:");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }
            int[][] B = new int[n][p];
            System.out.println("Enter matrix B:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < p; j++) {
                    B[i][j] = scanner.nextInt();
                }
            }
            long startTime = System.currentTimeMillis();
            int[][] result = null;
            try {
                if (option == 1) {
                    result = matrixMultiply(A, B);
                    System.out.println("Single-threaded result:");
                } else if (option == 2) {
                    result = matrixMultiplyRow(A, B);
                    System.out.println("Multithreaded (one thread per row) result:");
                } else if (option == 3) {
                    result = matrixMultiplyCell(A, B);
                    System.out.println("Multithreaded (one thread per cell) result:");
                } else {
                    System.out.println("Invalid option");
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            printMatrix(result);
            System.out.printf("Time: %.2f ms%n", (endTime - startTime));
        }
        scanner.close();
    }
}
