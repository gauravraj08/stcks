import java.util.Scanner;

public class primeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        System.out.print("Prime factors of " + num + " are: ");

        // Print the number of 2s that divide num
        while (num % 2 == 0) {
            System.out.print(2 + " ");
            num /= 2;
        }

        // num must be odd at this point, so we can skip even numbers
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            // While i divides num, print i and divide num
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }

        // This condition is to check if num is a prime number greater than 2
        if (num > 2) {
            System.out.print(num);
        }
    }
}
