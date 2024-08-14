import java.util.*;
public class FractionalKnapsack {
    public static double fractionalKnapsack(double[] weights, double[] values, double capacity) {
        if (weights.length != values.length) {
            throw new IllegalArgumentException("Weights and values must be of the same length.");
        }
        double res = 0;
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            items.add(new Item(weights[i], values[i]));
        }
        items.sort((a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));
        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }
            if (item.weight > capacity) {
                res += capacity * (item.value / item.weight);
                capacity = 0;
            } else {
                res += item.value;
                capacity -= item.weight;
            }
        }
        return res;
    }
    private static class Item {
        double weight;
        double value;
        Item(double weight, double value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int numItems = scanner.nextInt();
        double[] weights = new double[numItems];
        System.out.print("Enter the weights (space-separated): ");
        for (int i = 0; i < numItems; i++) {
            weights[i] = scanner.nextDouble();
        }
        double[] values = new double[numItems];
        System.out.print("Enter the values (space-separated): ");
        for (int i = 0; i < numItems; i++) {
            values[i] = scanner.nextDouble();
        }
        if (weights.length != numItems || values.length != numItems) {
            throw new IllegalArgumentException("The number of weights and values must match the number of items.");
        }
        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();
        double maxValue = fractionalKnapsack(weights, values, capacity);
        System.out.printf("Maximum value in the knapsack: %.2f%n", maxValue);
        scanner.close();
    }
}
