import java.util.Arrays;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        int[] array = generateRandomArray(10);
        System.out.println("Array before sort: " + Arrays.toString(array));
        System.out.println("Array after sort:  " + Arrays.toString(shellSort(array)));
    }

    private static int[] shellSort(int[] arr) {
        int delta = arr.length / 2;
        while (delta >= 1) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i - delta; j >= 0; j -= delta) {
                    if (arr[j] > arr[j + delta]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + delta];
                        arr[j + delta] = tmp;
                    }
                }
            }
            delta = delta / 2;
        }
        return arr;
    }

    private static int[] generateRandomArray(int size)
    {
        int[] array = new int[size];
        for (int i = 0; i<size; i++)
        {
            array[i] = new Random().nextInt(200);
        }
        return array;
    }
}
