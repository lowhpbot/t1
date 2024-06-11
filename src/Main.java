import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = getPositiveInteger(scanner, "Введите размер массива (положительное целое число): ");


        double x = getDouble(scanner, "Введите пороговое значение: ");


        double[] randomArray = generateRandomArray(n);


        ArrayList<Integer> indicesAboveThreshold = getIndicesAboveThreshold(randomArray, x);


        System.out.print("Сгенерированный массив: ");
        for (double num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Индексы элементов, значения которых превышают порог " + x + ": ");
        for (int index : indicesAboveThreshold) {
            System.out.print(index + " ");
        }
        System.out.println();
    }


    private static int getPositiveInteger(Scanner scanner, String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Пожалуйста, введите положительное целое число.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // очистка некорректного ввода
            }
        }
        return value;
    }


    private static double getDouble(Scanner scanner, String prompt) {
        double value = 0.0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next(); // очистка некорректного ввода
            }
        }
        return value;
    }


    private static double[] generateRandomArray(int n) {
        Random random = new Random();
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = 0 + (100 - 0) * random.nextDouble();
        }
        return array;
    }


    private static ArrayList<Integer> getIndicesAboveThreshold(double[] array, double x) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > x) {
                indices.add(i);
            }
        }
        return indices;
    }
}