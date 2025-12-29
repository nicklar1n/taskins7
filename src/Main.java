import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }

        int maxLen = 1;
        int nonDecreasing = 1;
        int nonIncreasing = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                nonDecreasing++;
            } else {
                nonDecreasing = 1;
            }

            if (arr[i] <= arr[i - 1]) {
                nonIncreasing++;
            } else {
                nonIncreasing = 1;
            }

            if (nonDecreasing > maxLen){
                maxLen = nonDecreasing;
            }
            if (nonIncreasing > maxLen){
                maxLen = nonIncreasing;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("= Тесты =");
        int[][] testCases = {
                {},
                {1},
                {1, 2, 3, 2, 1},
                {1, 1, 1, 1, 1},
                {1, 4, 2, 5, 8, 4, 1, 3},
                {1, 5, 2, 6, 3, 7, 4, 8},
                {1, 2, 3, 3, 3, 2, 1, 0},
                {1, 2, 3, 2, 1, 0, -1},
                {4, 2},
                {1, 2, 2, 3, 4}
        };

        for (int[] test : testCases) {
            System.out.println("Массив: " + Arrays.toString(test));
            System.out.println("Максимальная длина монотонной последовательности: " + solution(test));
            System.out.println("---");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("= Наш ввод =");
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Максимальная длина монотонной последовательности: 0");
        } else {
            int[] arr = new int[n];
            System.out.print("Введите элементы: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println("Максимальная длина монотонной последовательности: " + solution(arr));
        }
    }
}
