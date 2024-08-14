import java.util.Random;
import java.util.Scanner;
public class RandomizedQuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the list of numbers (space-separated): ");
        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        int[] arr = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            arr[i] = Integer.parseInt(inputArr[i].trim());
        }
        randomizedQuickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        scanner.close();
    }
    private static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }
    private static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }
    private static int randomPartition(int[] arr, int p, int r) {
        Random random = new Random();
        int i = p + random.nextInt(r - p + 1);
        swap(arr, i, r);
        return partition(arr, p, r);
    }
    private static void randomizedQuickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = randomPartition(arr, p, r);
            randomizedQuickSort(arr, p, q - 1);
            randomizedQuickSort(arr, q + 1, r);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
