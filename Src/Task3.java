import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

public class Task3 {

    public static void main(String[] args) {
        primeNumbers(2, 200);
    }

    private static void primeNumbers(int start, int finish) {

        for (int i = start; i <= finish; i++) {
            boolean isPrime = i > 2;
            for (int j = 2; j <= ceil(sqrt(i)); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
